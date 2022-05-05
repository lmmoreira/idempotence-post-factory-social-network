package br.com.project.leonardo.leonardobasics.utils;

import java.util.Arrays;
import java.util.Base64;

public class Hash {

    public static String encode(String key) {
        return Base64.getEncoder().encodeToString(key.getBytes());
    }

    public static String decode(String key) {
        byte[] decodedBytes = Base64.getDecoder().decode(key);
        return Arrays.toString(decodedBytes);
    }

}
