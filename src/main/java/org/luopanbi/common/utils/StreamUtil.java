package org.luopanbi.common.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamUtil {

    public static <T, K> List<T> mapList(Collection<K> origins, Function<K, T> mapping) {
        if (CollectionUtils.isEmpty(origins)) {
            return new ArrayList<>();
        }
        return origins.stream().map(mapping).collect(Collectors.toList());
    }
}
