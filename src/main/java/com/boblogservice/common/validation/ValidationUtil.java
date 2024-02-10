package com.boblogservice.common.validation;

import com.boblogservice.common.exception.FormValidationException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Component
public class ValidationUtil {
    public static void confirmError(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FormValidationException(bindingResult.getFieldErrors().stream().map(FieldErrorDetail::create).toList());
        }
    }
}
