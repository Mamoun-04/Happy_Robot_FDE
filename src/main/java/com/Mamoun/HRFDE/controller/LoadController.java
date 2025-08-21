package com.Mamoun.HRFDE.controller;

import com.Mamoun.HRFDE.model.Load;
import com.Mamoun.HRFDE.service.LoadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loads")
public class LoadController {

    private static final Logger log = LoggerFactory.getLogger(LoadController.class);

    private final LoadService loadService;

    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    }

    @GetMapping
    public List<Load> getLoads(
            @RequestParam(required = false) String origin,
            @RequestParam(required = false) String destination) {

        // Log incoming request
        log.info("📥 Incoming request: origin={}, destination={}", origin, destination);

        List<Load> loads = loadService.getLoads(origin, destination);

        // Log size + results
        log.info("📤 Returning {} loads (origin={}, destination={})",
                loads.size(), origin, destination);

        return loads;
    }
}
