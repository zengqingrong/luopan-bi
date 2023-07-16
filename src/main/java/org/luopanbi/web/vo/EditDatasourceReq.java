package org.luopanbi.web.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EditDatasourceReq {
    /**
     * 数据源名词
     */
    @JsonProperty("show_name")
    @Size(min = 3, max = 255)
    private String showName;

    /**
     * 用户名
     */
    @Size(min = 1, max = 255)
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 数据源类型
     */
    @JsonProperty("source_type")
    @Pattern(regexp = "MYSQL|CLICKHOUSE|ORACLE")
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
}
