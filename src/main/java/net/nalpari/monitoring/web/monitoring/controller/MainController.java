package net.nalpari.monitoring.web.monitoring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/thymeleaf")
public class MainController {

    @GetMapping(value = {"/", ""})
    public String main() {
        return "main";
    }
}
