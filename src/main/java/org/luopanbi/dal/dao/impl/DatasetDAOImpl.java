package org.luopanbi.dal.dao.impl;

import org.luopanbi.dal.entity.Dataset;
import org.luopanbi.dal.mapper.DatasetMapper;
import org.luopanbi.dal.dao.DatasetDAO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luopan
 * @since 2023-07-15
 */
@Service
public class DatasetDAOImpl extends ServiceImpl<DatasetMapper, Dataset> implements DatasetDAO {

}
