package de.alexkrieg.springapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class MessageController {

    @GetMapping("/form")
    public String formGet(Model model) {
        makeEffort();
        model.addAttribute("greet", "Hello from Spring!");
        return "message";
    }

    private void makeEffort() {
        for (int i = 0; i < 1000000; i++) {
            if (i % 100 == 0) {
                System.out.print("," + i);
            }
        }
    }

}