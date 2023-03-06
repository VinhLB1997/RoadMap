package com.java.roadmap.java8;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64App {
    /**
     * Encode String need Security
     * @param rawString
     * @return
     */
    public String encodeBase64(String rawString){
        byte[] data = rawString.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * Decode String
     * @param encodeString
     * @return
     */
    public String decodeBase64(String encodeString){
        byte[] data = Base64.getDecoder().decode(encodeString);
        String rawString = new String(data, StandardCharsets.UTF_8);
        return rawString;
    }

    public static void main(String[] args) {
        String stringSecure = "This is my string that need security";
        Base64App app = new Base64App();
        String encode = app.encodeBase64(stringSecure);
        System.out.println("Encode: " + encode);
        System.out.println("Decode: " + app.decodeBase64(encode));
    }
}
