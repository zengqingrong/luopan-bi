package org.luopanbi.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("column_info")
public class ColumnInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 列信息 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 列名
     */
    private String name;

    /**
     * 展示名称
     */
    private String showName;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 数据集 ID
     */
    private Integer datasetId;

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
