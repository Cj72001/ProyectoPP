package com.uca.spring.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalExceptionHandler implements ErrorController{

    @GetMapping("/error")
    public String handleError(ModelMap modelMap, HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);


            modelMap.put("errorGeneral", status.toString());
            return "customError.jsp";
    }

}
