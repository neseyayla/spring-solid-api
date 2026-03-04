package com.nese.backend_new.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HealthController: Simple health check endpoint to monitor application status.
 */
@RestController
public class HealthController {

    /**
     * Checks if the server is running and reachable.
     * Often used by Docker, Kubernetes, or Load Balancers.
     */
    @GetMapping("/health")
    public String health() {
        // Confirms the application context is loaded and responding
        return "The server is up.";
    }
}