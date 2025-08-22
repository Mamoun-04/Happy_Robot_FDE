package com.Mamoun.HRFDE.controller;

import com.Mamoun.HRFDE.model.CallLog;
import com.Mamoun.HRFDE.repository.CallLogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class CallLogController {

    private final CallLogRepository repository;

    public CallLogController(CallLogRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CallLog> getAllLogs() {
        return repository.findAll();
    }

    @PostMapping
    public CallLog createLog(@RequestBody CallLog log) {
        return repository.save(log);
    }
}
