package org.luopanbi.converter;

import org.luopanbi.dal.entity.Dataset;
import org.luopanbi.web.vo.AddDatasetReq;
import org.luopanbi.web.vo.DatasetVO;

public class DatasetConverter {

    public static DatasetVO toVo(Dataset dataset) {
        if (dataset == null) {
            return null;
        }
        DatasetVO datasetVO = new DatasetVO();
        datasetVO.setId(dataset.getId());
        datasetVO.setName(dataset.getName());
        datasetVO.setShowName(dataset.getShowName());
        datasetVO.setType(dataset.getType());
        datasetVO.setDescription(dataset.getDescription());
        datasetVO.setDatasourceId(dataset.getDatasourceId());
        datasetVO.setVirtualSql(dataset.getVirtualSql());
        datasetVO.setCreatedAt(dataset.getCreatedAt());
        datasetVO.setCreatedBy(dataset.getCreatedBy());
        datasetVO.setUpdatedAt(dataset.getUpdatedAt());
        datasetVO.setUpdatedBy(dataset.getUpdatedBy());
        return datasetVO;
    }

    public static Dataset toDo(AddDatasetReq addDatasetReq) {
        if (addDatasetReq == null) {
            return null;
        }
        Dataset dataset = new Dataset();
        dataset.setName(addDatasetReq.getName());
        dataset.setShowName(addDatasetReq.getShowName());
        dataset.setType(addDatasetReq.getType());
        dataset.setDescription(addDatasetReq.getDescription());
        dataset.setDatasourceId(addDatasetReq.getDatasourceId());
        dataset.setVirtualSql(addDatasetReq.getVirtualSql());
        return dataset;
    }
}
