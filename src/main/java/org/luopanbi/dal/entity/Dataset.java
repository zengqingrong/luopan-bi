package org.luopanbi.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author luopan
 * @since 2023-07-15
 */
@Getter
@Setter
public class Dataset implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据集 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 数据集名称
     */
    private String name;

    /**
     * 展示名称
     */
    private String showName;

    /**
     * 数据源类型
     * @see org.luopanbi.business.dataset.constant.DatasetType
     */
    private String type;

    /**
     * 虚拟表sql
     */
    private String virtualSql;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 数据源 ID
     */
    private Integer datasourceId;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}
