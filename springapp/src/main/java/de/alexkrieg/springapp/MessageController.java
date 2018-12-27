package de.alexkrieg.springapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class MessageController {

    @GetMapping("/form")
    public String formGet(Model model) {
        model.addAttribute("greet", "Hello from Spring!");
        return "message";
    }

}