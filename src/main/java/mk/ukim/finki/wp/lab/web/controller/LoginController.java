package mk.ukim.finki.wp.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", "Invalid username or password");
        }
        return "login";
    }

    @GetMapping("/403")
    public String accessDeniedPage() {
        return "403";
    }
}
