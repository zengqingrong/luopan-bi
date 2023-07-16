package org.luopanbi.common.constant;

import lombok.Getter;
import org.luopanbi.common.exception.CustomException;
import org.luopanbi.common.web.R;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionCode {

    PARAM_ERROR(400, "参数异常", HttpStatus.BAD_REQUEST),
    INTERNAL_ERROR(500, "内部系统异常", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;

    private final String message;

    private final HttpStatus httpStatus;

    ExceptionCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public R<String> toResp(String detail) {
        return new R<>(this.code, this.message, detail);
    }

    public CustomException toException(String detail) {
        return new CustomException(this, detail);
    }
}
