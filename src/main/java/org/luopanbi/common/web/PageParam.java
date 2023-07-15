package org.luopanbi.common.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageParam {
    private Integer current = 1;

    private Integer size = 10;
}
