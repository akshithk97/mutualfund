package com.aliceblue.mutualfund.v3;

import lombok.experimental.UtilityClass;

import java.security.SecureRandom;

@UtilityClass
public class Utility {

    public static final String MF_PASSWORD_URI = "http://bsestarmf.in/MFOrderEntry/getPassword";
    public static final String MF_DEFAULT_URI = "https://www.bsestarmf.in/MFOrderEntry/MFOrder.svc/Secure";

    public String passKeyGeneration() {
        SecureRandom secureRnd = new SecureRandom();
        int i, randLen = secureRnd.nextInt(11);
        while (randLen < 7) {
            randLen = secureRnd.nextInt(11);
        }
        String SOURCE = "QA1Zws2xED3Crf4vTG5Byhn6UJMik7OLpq8azWS9Xedc0RFVtgbYHNujmIKolP";
        StringBuilder sb = new StringBuilder(randLen);
        for (i = 0; i < randLen; i++) {
            sb.append(SOURCE.charAt(secureRnd.nextInt(SOURCE.length())));
        }
        return sb.toString();
    }
}
