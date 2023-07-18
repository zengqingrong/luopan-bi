package org.luopanbi.web.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EditDatasetReq {
    /**
     * 数据集 ID
     */
    @NotNull
    @NotEmpty
    private Integer id;

    /**
     * 展示名称
     */
    @Size(min = 1, max = 255)
    private String showName;

    /**
     * 描述信息
     */
    private String description;
}
