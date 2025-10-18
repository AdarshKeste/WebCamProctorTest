package com.example.demo;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private MailSender mailSender;

    public void sendSubmission(TestSubmission submission) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("adarshkeste153@gmail.com");                // ✅ change to YOUR inbox
        message.setSubject("New Coding Test Submission from " + submission.getName());

        StringBuilder body = new StringBuilder();
        body.append("Student Name: ").append(submission.getName()).append("\n");
        body.append("Student Email: ").append(submission.getEmail()).append("\n\n");
        body.append("Answers:\n");

        for (Map.Entry<String, String> entry : submission.getAnswers().entrySet()) {
            body.append(entry.getKey()).append(":\n")
                .append(entry.getValue()).append("\n\n");
        }

        message.setText(body.toString());
        mailSender.send(message);
    }
}