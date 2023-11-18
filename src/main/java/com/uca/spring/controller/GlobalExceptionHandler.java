package com.uca.spring.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class GlobalExceptionHandler implements ErrorController {

    @GetMapping("/error")
    public String handleError(ModelMap modelMap, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Throwable throwable = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

        String errorMessage = (throwable != null) ? throwable.getMessage() : "N/A";
        LocalDateTime timestamp = LocalDateTime.now();
        String formattedDateTime = timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        modelMap.put("statusCode", status != null ? status.toString() : "N/A");
        modelMap.put("timestamp", formattedDateTime);
        modelMap.put("errorMessage", errorMessage);

        return "customError.jsp";
    }
}
