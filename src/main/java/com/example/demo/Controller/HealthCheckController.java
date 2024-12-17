package com.example.demo.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@Tag(name = "HealthCheck")
public class HealthCheckController {

    @GetMapping
    @Operation(summary = "Check Service Health", description = "Retorna o status da aplicação.")
    public ResponseEntity<String> checkHealth() {
        System.out.println("HealthCheck Manual: Service Running");
        return ResponseEntity.ok("{\"status\":\"UP\"}");
    }
}
