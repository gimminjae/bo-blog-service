package com.boblogservice.common.exception;

import com.boblogservice.common.validation.FieldErrorDetail;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "validation failed")
@Getter
public class FormValidationException extends RuntimeException {
    private List<FieldErrorDetail> errors;
    public FormValidationException(List<FieldErrorDetail> errors) {
        super("message");
        this.errors = errors;
    }
}
