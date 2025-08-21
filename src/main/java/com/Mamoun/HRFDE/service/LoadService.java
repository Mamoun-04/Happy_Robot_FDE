package com.Mamoun.HRFDE.service;

import com.Mamoun.HRFDE.model.Load;
import com.Mamoun.HRFDE.repository.LoadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LoadService {

    private final LoadRepository loadRepository;
    private final Random random = new Random();

    public LoadService(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    public List<Load> getLoads(String origin, String destination) {
        List<Load> results;

        if (origin != null && destination != null) {
            results = loadRepository.findByOriginIgnoreCaseContainingAndDestinationIgnoreCaseContaining(origin, destination);
        } else if (origin != null) {
            results = loadRepository.findByOriginIgnoreCaseContaining(origin);
        } else if (destination != null) {
            results = loadRepository.findByDestinationIgnoreCaseContaining(destination);
        } else {
            results = loadRepository.findAll();
        }

        //  Fallback: if no matches, return a single random load
        if (results.isEmpty()) {
            List<Load> allLoads = loadRepository.findAll();
            if (!allLoads.isEmpty()) {
                Load randomLoad = allLoads.get(random.nextInt(allLoads.size()));
                return List.of(randomLoad); // wrap single load in list
            }
        }

        return results;
    }
}
