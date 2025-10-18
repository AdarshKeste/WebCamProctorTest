package com.example.demo;


import java.util.Map;

public class TestSubmission {

    private String name;
    private String email;
    private Map<String, String> answers;

    public TestSubmission() {}

    public TestSubmission(String name, String email, Map<String, String> answers) {
        this.name = name;
        this.email = email;
        this.answers = answers;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Map<String, String> getAnswers() { return answers; }
    public void setAnswers(Map<String, String> answers) { this.answers = answers; }
}