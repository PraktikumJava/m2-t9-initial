package ru.yandex.practicum.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DogsController {
    private int happiness = 0;

    @GetMapping("/dogs/converse")
    public Map<String, String> say() {
        happiness += 2;
        return Map.of("say", "Bark");
    }

    @GetMapping("/dogs/stroke")
    public Map<String, String> stroke(@RequestParam(required = false) final Integer count) {
        happiness += count;
        return Map.of("say", "wagging its tail ".repeat(count));
    }

    @GetMapping("/dogs/happiness")
    public Map<String, Integer> happiness() {
        return Map.of("happiness", happiness);
    }
}
