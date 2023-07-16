package org.luopanbi.business.datasource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.luopanbi.common.constant.ExceptionCode;
import org.luopanbi.common.exception.CustomException;
import org.luopanbi.common.utils.TimeUtil;
import org.luopanbi.common.web.PageParam;
import org.luopanbi.common.web.PageResult;
import org.luopanbi.converter.DatasourceConverter;
import org.luopanbi.dal.dao.DatasourceDAO;
import org.luopanbi.dal.entity.Datasource;
import org.luopanbi.web.vo.AddDatasourceReq;
import org.luopanbi.web.vo.DatasourceVO;
import org.luopanbi.web.vo.EditDatasourceReq;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;

@Service
public class DatasourceBizService {

    private final DatasourceDAO datasourceDAO;


    public DatasourceBizService(DatasourceDAO datasourceDAO) {
        this.datasourceDAO = datasourceDAO;
    }

    public PageResult<DatasourceVO> listAll(PageParam pageParam) {
        Page<Datasource> page = new Page<>(pageParam.getCurrent(), pageParam.getSize());
        datasourceDAO.page(page);
        return PageResult.from(page, DatasourceConverter::toVo);
    }

    public DatasourceVO addDatasource(AddDatasourceReq addDatasourceReq, String userId) {
        Datasource existDatasource = datasourceDAO.getByName(addDatasourceReq.getName());
        if (existDatasource != null) {
            throw new CustomException(ExceptionCode.PARAM_ERROR, "数据源编码名重复");
        }
        Datasource datasource = DatasourceConverter.toDo(addDatasourceReq);
        datasource.setCreatedAt(TimeUtil.now());
        datasource.setCreatedBy(userId);
        datasource.setUpdatedAt(TimeUtil.now());
        datasource.setUpdatedBy(userId);
        datasourceDAO.save(datasource);
        return DatasourceConverter.toVo(datasource);
    }

    public DatasourceVO editDatasource(Integer id, EditDatasourceReq editDatasourceReq, String userId) {
        Datasource datasource = datasourceDAO.getById(id);
        if (datasource == null) {
            throw new CustomException(ExceptionCode.PARAM_ERROR, "数据源不存在");
        }
        if (StringUtils.hasText(editDatasourceReq.getShowName())) {
            datasource.setShowName(editDatasourceReq.getShowName());
        }
        if (StringUtils.hasText(editDatasourceReq.getDescription())) {
            datasource.setDescription(editDatasourceReq.getDescription());
        }
        if (StringUtils.hasText(editDatasourceReq.getUsername())) {
            datasource.setUsername(editDatasourceReq.getUsername());
        }
        if (StringUtils.hasText(editDatasourceReq.getPassword())) {
            datasource.setPassword(Base64Utils.encodeToString(editDatasourceReq.getPassword().getBytes(StandardCharsets.UTF_8)));
        }
        if (StringUtils.hasText(editDatasourceReq.getSourceType())) {
            datasource.setSourceType(editDatasourceReq.getSourceType());
        }
        if (StringUtils.hasText(editDatasourceReq.getConnectionUrl())) {
            datasource.setConnectionUrl(editDatasourceReq.getConnectionUrl());
        }
        datasource.setUpdatedAt(TimeUtil.now());
        datasource.setUpdatedBy(userId);
        datasourceDAO.updateById(datasource);
        return DatasourceConverter.toVo(datasource);
    }

    public DatasourceVO deleteDatasource(Integer id) {
        Datasource datasource = datasourceDAO.getById(id);
        if (datasource == null) {
            throw new CustomException(ExceptionCode.PARAM_ERROR, "数据源不存在");
        }
        datasourceDAO.removeById(id);
        return DatasourceConverter.toVo(datasource);
    }
}
