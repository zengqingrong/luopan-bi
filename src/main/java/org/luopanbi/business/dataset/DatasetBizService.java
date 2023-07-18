package org.luopanbi.business.dataset;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.luopanbi.business.column.ColumnManager;
import org.luopanbi.business.column.model.ColumnModel;
import org.luopanbi.common.constant.ExceptionCode;
import org.luopanbi.common.utils.StreamUtil;
import org.luopanbi.common.web.PageParam;
import org.luopanbi.common.web.PageResult;
import org.luopanbi.converter.ColumnInfoConverter;
import org.luopanbi.converter.DatasetConverter;
import org.luopanbi.dal.dao.ColumnInfoDAO;
import org.luopanbi.dal.dao.DatasetDAO;
import org.luopanbi.dal.dao.DatasourceDAO;
import org.luopanbi.dal.entity.Dataset;
import org.luopanbi.dal.entity.Datasource;
import org.luopanbi.web.vo.AddDatasetReq;
import org.luopanbi.web.vo.DatasetVO;
import org.luopanbi.web.vo.EditDatasetReq;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DatasetBizService {

    private final DatasetDAO datasetDAO;

    private final DatasourceDAO datasourceDAO;

    private final ColumnInfoDAO columnInfoDAO;

    private final ColumnManager columnManager;

    public DatasetBizService(DatasetDAO datasetDAO, DatasourceDAO datasourceDAO, ColumnInfoDAO columnInfoDAO, ColumnManager columnManager) {
        this.datasetDAO = datasetDAO;
        this.datasourceDAO = datasourceDAO;
        this.columnInfoDAO = columnInfoDAO;
        this.columnManager = columnManager;
    }

    public PageResult<DatasetVO> listAll(PageParam pageParam) {
        Page<Dataset> page = new Page<>(pageParam.getCurrent(), pageParam.getSize());
        datasetDAO.page(page, new QueryWrapper<>());
        return PageResult.from(page, DatasetConverter::toVo);
    }

    public DatasetVO getById(Integer id) {
        Dataset dataset = datasetDAO.getById(id);
        return DatasetConverter.toVo(dataset);
    }

    public DatasetVO addDataset(AddDatasetReq addDatasetReq) {
        Dataset dataset = DatasetConverter.toDo(addDatasetReq);
        if (datasetDAO.getByName(dataset.getName()) != null) {
            throw ExceptionCode.PARAM_ERROR.toException("数据集编码重复");
        }
        if (dataset.isVirtualTable() && !StringUtils.hasText(dataset.getVirtualSql())) {
            throw ExceptionCode.PARAM_ERROR.toException("虚拟表SQL为空");
        }
        Datasource datasource = datasourceDAO.getById(dataset.getDatasourceId());
        if (datasource == null) {
            throw ExceptionCode.PARAM_ERROR.toException("数据源不存在");
        }
        List<ColumnModel> columns;
        if (dataset.isVirtualTable()) {
            columns = columnManager.getColumnsBySql(datasource, dataset.getVirtualSql());
        } else {
            columns = columnManager.getColumnsBySql(datasource, dataset.getName());
        }
        if (CollectionUtils.isEmpty(columns)) {
            throw ExceptionCode.PARAM_ERROR.toException("数据集没有列信息");
        }
        columnInfoDAO.saveBatch(StreamUtil.mapList(columns, ColumnInfoConverter::toDo));
        datasetDAO.save(dataset);
        return DatasetConverter.toVo(dataset);
    }

    public DatasetVO editDataset(Integer id, EditDatasetReq editDatasetReq) {
        Dataset dataset = datasetDAO.getById(id);
        if (dataset == null) {
            throw ExceptionCode.PARAM_ERROR.toException("数据集不存在");
        }
        if (StringUtils.hasText(editDatasetReq.getShowName())) {
            dataset.setShowName(editDatasetReq.getShowName());
        }
        if (StringUtils.hasText(editDatasetReq.getDescription())) {
            dataset.setDescription(editDatasetReq.getDescription());
        }
        datasetDAO.updateById(dataset);
        return DatasetConverter.toVo(dataset);
    }
}
