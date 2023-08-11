package com.arslanesra;

import lombok.Data;

@Data
public class CreditCardUtil {
    public static String maskCreditCardNumber(String cardNumber) {
        // Boşluklar, ayraçlar ve diğer gereksiz karakterleri temizle
        String cleanCardNumber = cardNumber.replaceAll("[\\s\\-\\,]", "");

        // Kart numarasının uzunluğunu kontrol et
        if (cleanCardNumber.length() < 10) {
            throw new IllegalArgumentException("Invalid credit card number.");
        }

        // Maskeleme mantığını uygula
        String maskedNumber = cleanCardNumber.substring(0, 6) + "******" + cleanCardNumber.substring(cleanCardNumber.length() - 4);
        return maskedNumber;
    }
}
