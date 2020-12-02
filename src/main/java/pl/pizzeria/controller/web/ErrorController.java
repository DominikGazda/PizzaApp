package pl.pizzeria.controller.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ErrorController {

    @GetMapping("/error")
    public String getError(Model model){
        return "error";
    }
}
