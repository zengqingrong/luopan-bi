package org.luopanbi.web.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DatasourceVO {
    /**
     * 数据源 ID
     */
    private Integer id;

    /**
     * 数据源编码名
     */
    private String name;

    /**
     * 数据源名词
     */
    @JsonProperty("show_name")
    private String showName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 数据源类型
     */
    @JsonProperty("source_type")
    private String sourceType;

    /**
     * 连接 URL
     */
    @JsonProperty("connection_url")
    private String connectionUrl;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 创建人
     */
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 创建时间
     */
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 更新人
     */
    @JsonProperty("updated_by")
    private String updatedBy;

    /**
     * 更新时间
     */
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
