package org.luopanbi.common.config;

import org.luopanbi.common.constant.ExceptionCode;
import org.luopanbi.common.exception.CustomException;
import org.luopanbi.common.web.R;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<R<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append(": ").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
        return new ResponseEntity<>(ExceptionCode.PARAM_ERROR.toResp(msg), ExceptionCode.PARAM_ERROR.getHttpStatus());
    }

    @ResponseBody
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<R<String>> handleConstraintViolationException(ConstraintViolationException ex) {
        return new ResponseEntity<>(ExceptionCode.PARAM_ERROR.toResp(ex.getMessage()), ExceptionCode.PARAM_ERROR.getHttpStatus());

    }

    @ResponseBody
    @ExceptionHandler({CustomException.class})
    public ResponseEntity<R<String>> handleCustomException(CustomException ex) {
        return new ResponseEntity<>(ex.toResp(), ex.getHttpStatus());

    }

    @ResponseBody
    @ExceptionHandler({Exception.class})
    public ResponseEntity<R<String>> handleSystemException(Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(ExceptionCode.INTERNAL_ERROR.toResp(ex.getMessage()), ExceptionCode.INTERNAL_ERROR.getHttpStatus());
    }
}
