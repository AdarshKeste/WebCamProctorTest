package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/submit")
    public ResponseEntity<String> handleSubmission(@RequestBody TestSubmission submission) {
        try {
            emailService.sendSubmission(submission);
            return ResponseEntity.ok("✅ Test submitted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body("❌ Error sending submission email: " + e.getMessage());
        }
    }
}