package org.luopanbi.converter;

import org.luopanbi.dal.entity.Datasource;
import org.luopanbi.web.vo.AddDatasourceReq;
import org.luopanbi.web.vo.DatasourceVO;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

public class DatasourceConverter {

    public static DatasourceVO toVo(Datasource datasource) {
        if (datasource == null) {
            return null;
        }
        DatasourceVO datasourceVO = new DatasourceVO();
        datasourceVO.setId(datasource.getId());
        datasourceVO.setName(datasource.getName());
        datasourceVO.setShowName(datasource.getShowName());
        datasourceVO.setDescription(datasourceVO.getDescription());
        datasourceVO.setSourceType(datasource.getSourceType());
        datasourceVO.setConnectionUrl(datasource.getConnectionUrl());
        datasourceVO.setCreatedAt(datasource.getCreatedAt());
        datasourceVO.setUsername(datasource.getUsername());
        datasourceVO.setUpdatedAt(datasource.getUpdatedAt());
        datasourceVO.setCreatedBy(datasource.getCreatedBy());
        datasourceVO.setUpdatedBy(datasource.getUpdatedBy());
        return datasourceVO;
    }

    public static Datasource toDo(AddDatasourceReq datasourceReq) {
        if (datasourceReq == null) {
            return null;
        }
        Datasource datasource = new Datasource();
        datasource.setName(datasourceReq.getName());
        datasource.setShowName(datasourceReq.getShowName());
        datasource.setDescription(datasourceReq.getDescription());
        datasource.setSourceType(datasourceReq.getSourceType());
        datasource.setConnectionUrl(datasourceReq.getConnectionUrl());
        datasource.setUsername(datasourceReq.getUsername());
        datasource.setPassword(Base64Utils.encodeToString(datasourceReq.getPassword().getBytes(StandardCharsets.UTF_8)));
        return datasource;
    }
}
