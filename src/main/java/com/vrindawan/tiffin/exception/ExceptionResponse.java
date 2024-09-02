package com.vrindawan.tiffin.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private String error;
    private String message;
    private LocalDateTime timestamp;

    // Constructor
    public ExceptionResponse(String error, String message) {
        this.error = error;
        this.message = message;
        this.timestamp = LocalDateTime.now(); // Automatically set to the current time
    }

    // Getters and setters
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
