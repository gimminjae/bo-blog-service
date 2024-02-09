package com.boblogservice.common.validation;

import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import org.springframework.context.MessageSource;
import org.springframework.validation.FieldError;

import java.util.Locale;

@Value
public class FieldErrorDetail {
    private String objectName;
    private String field;
    private String code;
    private String message;

    public static FieldErrorDetail create(FieldError fieldError) { //, MessageSource messageSource, Locale locale
        return new FieldErrorDetail(
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getCode(),
                fieldError.getDefaultMessage()
//                messageSource.getMessage(fieldError, locale)
        );
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("%s: %s,".formatted("objectName", this.objectName));
        sb.append("%s: %s,".formatted("field", this.field));
        sb.append("%s: %s,".formatted("code", this.code));
        sb.append("%s: %s".formatted("message", this.message));
        sb.append("}");
        return sb.toString();
    }
}
