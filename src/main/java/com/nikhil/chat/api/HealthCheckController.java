package com.nikhil.chat.api;

import io.swagger.annotations.Api;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "System Health Resource")
@RestController
public class HealthCheckController {
    @Setter
    private boolean shutDownApp = false;

    @Value("${git.commit.id}")
    public String gitCommitId;

    @GetMapping(value = "/health_check", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity healthCheck() {
        Map<String, Object> response = new HashMap<>();
        response.put("gitCommitId", gitCommitId);

        if (shutDownApp) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        } else {
            response.put("status", "OK");
            return ResponseEntity.ok().body(response);
        }
    }
}
