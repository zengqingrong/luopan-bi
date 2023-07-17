package org.luopanbi.web.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AddDatasetReq {
    /**
     * 数据集名称
     */
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 16)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String name;

    /**
     * 展示名称
     */
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String showName;

    /**
     * 数据源类型
     *
     * @see org.luopanbi.business.dataset.constant.DatasetType
     */
    @NotNull
    @NotEmpty
    @Pattern(regexp = "PHYSICS|VIRTUAL")
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
    @NotNull
    @NotEmpty
    private Integer datasourceId;
}
