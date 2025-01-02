package com.example.kundensendungsservice.controller;

import com.example.kundensendungsservice.service.VerordnungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerordnungController {

    private final VerordnungService verordnungService;

    @Autowired
    public VerordnungController(VerordnungService verordnungService) {
        this.verordnungService = verordnungService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> getSendungStatus(){
        System.out.println("ASGADSGSASG");
        return verordnungService
                .find()
                .map(verordnung -> ResponseEntity.ok("VVV: " + verordnung.getBelegnummer()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
