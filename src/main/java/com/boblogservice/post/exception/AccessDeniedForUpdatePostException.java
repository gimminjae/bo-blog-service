package com.boblogservice.post.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "access denied for update post")
public class AccessDeniedForUpdatePostException extends RuntimeException {
    public AccessDeniedForUpdatePostException(String message) {
        super(message);
    }
}
