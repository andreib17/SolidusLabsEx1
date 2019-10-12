package com.company.solidusEx1.utils;

public class Utils {

    /**
     * convert the byte array into a hex hash
     */
    public static String bytesToHexStr(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
