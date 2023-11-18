package com.uca.spring.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(Exception e, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Un error inesperado ha ocurrido. Por favor, inténtalo de nuevo más tarde.");
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("customError"); // Tu página JSP de error
        return mav;
    }
}
