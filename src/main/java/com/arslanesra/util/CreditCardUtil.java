package com.arslanesra.util;

import lombok.Data;

@Data
public class CreditCardUtil {
    public static String maskCreditCardNumber(String cardNumber) {
        String cleanCardNumber = cardNumber.replaceAll("[\\s\\-\\,]", "");

        if (cleanCardNumber.length() < 10) {
            throw new IllegalArgumentException("Invalid credit card number.");
        }

        String maskedNumber = cleanCardNumber.substring(0, 6) + "******" + cleanCardNumber.substring(cleanCardNumber.length() - 4);
        return maskedNumber;
    }
}
