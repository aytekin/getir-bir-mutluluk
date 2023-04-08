package com.example.demo.common.exception;

import com.example.demo.common.exception.error.Code;
import com.example.demo.common.exception.error.response.ResponseBean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResponseBean exceptionHandler(Exception e) {
        log.error("Getir Global Exception", e);
        return new ResponseBean(Code.SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(value = {GetirException.class})
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResponseBean getirHandler(GetirException e) {
        log.error("Getir Global Exception", e);
        return new ResponseBean(Code.SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(value = {EntityNotFound.class})
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResponseBean notFoundHandler(EntityNotFound e) {
        return new ResponseBean(Code.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(InvalidTokenException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResponseBean invalidTokenHandler(InvalidTokenException e) {
//        log.error("Invalid Token Exception", e);
        return new ResponseBean(Code.TOKEN_ERROR, e.getMessage());
    }
}
