package ru.yandex.practicum.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CatsController {

    private int happiness = 0;

    @GetMapping("/cats/converse")
    public Map<String, String> say() {
        happiness++;
        return Map.of("say", "Meow");
    }

    @GetMapping("/cats/stroke")
    public Map<String, String> stroke(@RequestParam(required = false) final Integer count) {
        happiness += count;
        return Map.of("say", "Murr".repeat(count));
    }

    @GetMapping("/cats/happiness")
    public Map<String, Integer> happiness() {
        return Map.of("happiness", happiness);
    }
}
