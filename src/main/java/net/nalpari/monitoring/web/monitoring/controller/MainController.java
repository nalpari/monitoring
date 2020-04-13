package net.nalpari.monitoring.web.monitoring.controller;

import lombok.RequiredArgsConstructor;
import net.nalpari.monitoring.config.exception.AppError;
import net.nalpari.monitoring.config.exception.FilePathException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/thymeleaf")
public class MainController {

    @GetMapping(value = {"/", ""})
    public String main() {
        return "main";
    }

    @GetMapping("/test")
    public void test() throws Exception {
        throw new FilePathException();
    }

}
