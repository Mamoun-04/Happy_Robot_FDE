package com.Mamoun.HRFDE.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class VerifyController {

    @GetMapping("/verify")
    public Map<String, Object> verifyMcNumber(@RequestParam String mcNumber) {
        Map<String, Object> response = new HashMap<>();
        response.put("mcNumber", mcNumber);
        response.put("verified", true); // Always true (dummy response)
        return response;
    }
}
