package com.scalable.task03.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scalable.task03.config.DataSeeder;

@RestController
public class SeedController {

    private final DataSeeder dataSeeder;

    public SeedController(DataSeeder dataSeeder) {
        this.dataSeeder = dataSeeder;
    }

    @GetMapping("/api/seed")
    public ResponseEntity<Map<String, String>> seed() {
        boolean adminSeeded = dataSeeder.seedAdminAccount();
        boolean productsSeeded = dataSeeder.seedSampleProducts();
        return ResponseEntity.ok(Map.of(
                "admin", adminSeeded ? "SEEDED" : "SKIPPED, IT IS ALREADY SEEDED",
                "products", productsSeeded ? "SEEDED" : "SKIPPED, IT IS ALREADY SEEDED"));
    }
}
