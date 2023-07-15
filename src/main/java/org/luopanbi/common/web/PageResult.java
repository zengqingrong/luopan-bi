package org.luopanbi.common.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResult<T> {
    public Integer total;

    public Integer current;

    public Integer size;

    public List<T> result;

    public static <K> PageResult<K> from(Page<K> page) {
        PageResult<K> pageResult = new PageResult<>();
        pageResult.setTotal((int) page.getTotal());
        pageResult.setCurrent((int) page.getCurrent());
        pageResult.setSize((int) page.getSize());
        pageResult.setResult(page.getRecords());
        return pageResult;
    }
}
