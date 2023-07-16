package org.luopanbi.common.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
public class PageResult<T> {
    public Integer total;

    public Integer current;

    public Integer size;

    public List<T> result;

    public static <K, V> PageResult<K> from(Page<V> page, Function<V, K> convert) {
        PageResult<K> pageResult = new PageResult<>();
        pageResult.setTotal((int) page.getTotal());
        pageResult.setCurrent((int) page.getCurrent());
        pageResult.setSize((int) page.getSize());
        pageResult.setResult(page.getRecords().stream().map(convert::apply).collect(Collectors.toList()));
        return pageResult;
    }
}
