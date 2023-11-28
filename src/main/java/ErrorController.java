package com.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Provide custom error handling logic or return a view for the error page
        return "error";
    }

    // Add this method to fix the compilation error
    public String getErrorPath() {
        return "/error";
    }
}