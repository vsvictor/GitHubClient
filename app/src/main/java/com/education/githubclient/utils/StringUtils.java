package com.education.githubclient.utils;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

public class StringUtils {
    public static String encodeString(String s) {
        byte[] data = new byte[0];

        try {
            data = s.getBytes("UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            String base64Encoded = Base64.encodeToString(data, Base64.NO_WRAP);
            return base64Encoded;
        }
    }

    public static String decodeString(String encoded) {
        byte[] dataDec = Base64.decode(encoded, Base64.DEFAULT);
        String decodedString = "";
        try {

            decodedString = new String(dataDec, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        } finally {

            return decodedString;
        }
    }
}
