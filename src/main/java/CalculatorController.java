package com.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculator() {
        return "calculator";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam(name = "operand1") double operand1,
                            @RequestParam(name = "operand2") double operand2,
                            @RequestParam(name = "operator") String operator,
                            Model model) {
        double result;
        switch (operator) {
            case "add":
                result = operand1 + operand2;
                break;
            case "subtract":
                result = operand1 - operand2;
                break;
            case "multiply":
                result = operand1 * operand2;
                break;
            case "divide":
                result = operand1 / operand2;
                break;
            default:
                result = 0;
        }
        model.addAttribute("result", result);
        return "calculator";
    }
}
