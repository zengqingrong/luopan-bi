package org.luopanbi.dal.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.luopanbi.dal.entity.Datasource;
import org.luopanbi.dal.mapper.DatasourceMapper;
import org.luopanbi.dal.dao.DatasourceDAO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author luopan
 * @since 2023-07-15
 */
@Service
public class DatasourceDAOImpl extends ServiceImpl<DatasourceMapper, Datasource> implements DatasourceDAO {
    @Override
    public Datasource getByName(String name) {
        QueryWrapper<Datasource> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Datasource::getName, name);
        return this.getOne(queryWrapper);
    }
}
