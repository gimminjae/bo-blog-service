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
            StringBuilder sb = new StringBuilder();
            List<FieldErrorDetail> errorMessages = bindingResult.getFieldErrors().stream().map(error -> FieldErrorDetail.create(error)).toList();
//            sb.append("[");
//            errorMessages.forEach(message -> sb.append("%s,".formatted(message.toString())));
//            sb.append("]");
            throw new FormValidationException(errorMessages);
        }
    }
}
