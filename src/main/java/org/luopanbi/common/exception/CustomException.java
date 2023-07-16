package org.luopanbi.common.exception;

import lombok.Getter;
import org.luopanbi.common.constant.ExceptionCode;
import org.luopanbi.common.web.R;
import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private final ExceptionCode exception;

    private final String detail;

    public CustomException(ExceptionCode exception, String detail) {
        this.exception = exception;
        this.detail = detail;
    }

    public R<String> toResp() {
        return new R<>(this.exception.getCode(), this.exception.getMessage(), detail);
    }

    public HttpStatus getHttpStatus() {
        return this.exception.getHttpStatus();
    }
}
