package com.Mamoun.HRFDE.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/negotiation")
public class NegotiationController {

    @PostMapping("/counter")
    public Map<String, Object> negotiate(@RequestBody Map<String, Object> payload) {
        int clientOffer = (int) payload.get("client_offer");
        int ourMax = (int) payload.get("our_max");
        int round = (int) payload.get("round");
        int maxRounds = (int) payload.get("max_rounds"); // comes from request

        int newRound = round + 1;

        Map<String, Object> response = new HashMap<>();
        String outcome;
        Integer agreedPrice = null;
        Integer counterOffer = null;

        if (clientOffer <= ourMax) {
            outcome = "deal";
            agreedPrice = clientOffer;
        } else if (newRound > maxRounds) {
            outcome = "tooManyRounds";
        } else {
            outcome = "continue";
            counterOffer = (clientOffer + ourMax) / 2; // midpoint strategy
        }

        response.put("round", newRound);
        response.put("outcome", outcome);
        response.put("agreed_price", agreedPrice);
        response.put("counter_offer", counterOffer);

        return response;
    }
}
