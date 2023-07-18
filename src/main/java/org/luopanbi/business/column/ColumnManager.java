package org.luopanbi.business.column;

import org.luopanbi.business.column.model.ColumnModel;
import org.luopanbi.dal.entity.Datasource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ColumnManager {

    public List<ColumnModel> getColumnsByTable(Datasource datasource, String table) {
        return null;
    }

    public List<ColumnModel> getColumnsBySql(Datasource datasource, String sql) {
        return null;
    }
}
