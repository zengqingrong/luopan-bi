package org.luopanbi.common.web;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class R<T> {

    private int code = HttpStatus.OK.value();

    private String message = "success";

    private T result;

    public static <K> R<K> ok(K result) {
        R<K> ok = new R<>();
        ok.setResult(result);
        return ok;
    }
}
