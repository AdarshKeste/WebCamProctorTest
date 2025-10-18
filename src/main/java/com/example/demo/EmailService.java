package com.example.demo;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class EmailService {

    @Value("${SENDGRID_API_KEY}")
    private String apiKey;

    public void sendSubmission(TestSubmission submission) {
        Email from = new Email("no-reply@neopal.tech"); // any placeholder "from"
        String subject = "New Coding Test Submission from " + submission.getName();
        Email to = new Email("adarshkeste153@gmail.com"); // ✅ your inbox

        StringBuilder body = new StringBuilder();
        body.append("Student Name: ").append(submission.getName()).append("\n");
        body.append("Student Email: ").append(submission.getEmail()).append("\n\n");
        body.append("Answers:\n");

        for (Map.Entry<String, String> entry : submission.getAnswers().entrySet()) {
            body.append(entry.getKey()).append(":\n")
                .append(entry.getValue()).append("\n\n");
        }

        Content content = new Content("text/plain", body.toString());
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println("SendGrid response code: " + response.getStatusCode());
        } catch (IOException ex) {
            System.err.println("SendGrid send failed: " + ex.getMessage());
        }
    }
}