package com.andrecordeiro.items.controller.advice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.andrecordeiro.items.controller.exception.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(NOT_FOUND)
  public String notFoundHandler(NotFoundException ex) {
    return ex.getMessage();
  }
}
