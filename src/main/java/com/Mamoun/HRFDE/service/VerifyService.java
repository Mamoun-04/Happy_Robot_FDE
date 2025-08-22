package com.Mamoun.HRFDE.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class VerifyService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_HOST = "mobile.fmcsa.dot.gov";

    public Map<String, Object> verifyMcNumber(String mcNumber, String apiKey) {
        Map<String, Object> apiResponse = null;

        // FMCSA docket-number endpoint
        String url = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(BASE_HOST)
                .path("/qc/services/carriers/docket-number/" + mcNumber)
                .queryParam("webKey", apiKey)
                .toUriString();

        try {
            apiResponse = restTemplate.getForObject(url, Map.class);
        } catch (Exception e) {
            // fallback to search endpoint if needed
            String fallbackUrl = UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host(BASE_HOST)
                    .path("/qc/services/carriers/search/docket-number/" + mcNumber)
                    .queryParam("webKey", apiKey)
                    .toUriString();
            try {
                apiResponse = restTemplate.getForObject(fallbackUrl, Map.class);
            } catch (Exception ex) {
                apiResponse = null;
            }
        }

        // Determine if verified
        boolean verified = false;
        if (apiResponse != null && apiResponse.containsKey("content")) {
            Object content = apiResponse.get("content");
            if (content instanceof Iterable) {
                for (Object item : (Iterable<?>) content) {
                    if (item instanceof Map && ((Map<?, ?>) item).containsKey("carrier")) {
                        verified = true;
                        break;
                    }
                }
            }
        }

        // Return only mcNumber + verified
        Map<String, Object> response = new HashMap<>();
        response.put("mcNumber", mcNumber);
        response.put("verified", verified);
        return response;
    }
}
