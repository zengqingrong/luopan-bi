package org.luopanbi.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
    }

    public static <T> String toString(T t) {
        if (t == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromString(String data, Class<T> type) {
        if (data == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(data, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> fromArrayString(String data, Class<T> type) {
        if (data == null) {
            return null;
        }
        try {
            JavaType typeReference = OBJECT_MAPPER.getTypeFactory().constructParametricType(ArrayList.class, type);
            return OBJECT_MAPPER.readValue(data, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
