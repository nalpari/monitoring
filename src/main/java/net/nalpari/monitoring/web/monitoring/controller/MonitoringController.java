package net.nalpari.monitoring.web.monitoring.controller;

import lombok.extern.slf4j.Slf4j;
import net.nalpari.monitoring.web.monitoring.model.Sample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MonitoringController {

    @GetMapping(value = {"", "/"})
    public Sample index() {
        Sample result = new Sample();
        result.setId("1");
        result.setMessage("result");
        return result;
    }

    @GetMapping("/long-process")
    public String pause() throws InterruptedException {
        log.info("#### thread start");
        Thread.sleep(10000);
        log.info("#### thread end");
        return "Process finished";
    }
}
