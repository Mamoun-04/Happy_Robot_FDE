package com.Mamoun.HRFDE.controller;

import com.Mamoun.HRFDE.service.VerifyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class VerifyController {

    private final VerifyService verifyService;

    @Value("${fmcsa.api.key}")
    private String apiKey;

    public VerifyController(VerifyService verifyService) {
        this.verifyService = verifyService;
    }

    @GetMapping("/verify")
    public Map<String, Object> verifyMcNumber(@RequestParam String mcNumber) {
        return verifyService.verifyMcNumber(mcNumber, apiKey);
    }
}
