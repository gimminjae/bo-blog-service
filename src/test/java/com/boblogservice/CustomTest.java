package com.boblogservice;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class CustomTest {
    @Test
    void test() {
        System.out.println("%s%s%s".formatted(
                LocalDate.now().toString().replace("-", ""),
                "M",
                UUID.randomUUID().toString()
        ));
    }
}
