package com.ksusha.vel.marvelfanj.data.remotedata.service;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ParamsResponseKye {

    public static final String API_KEY = "58d04bd91489ba9a35600b375dd3ba32";
    private static final String PRIVATE_KEY = "71db9e17f07154c68c48896972e85d0c013cc5e1";

    public static String getTimestamp() {
        String timestamp = String.valueOf(System.currentTimeMillis());

        return timestamp;
    }

    public static String getHash() {

        String input = getTimestamp() + PRIVATE_KEY + API_KEY;

        return getMd5(input);
    }

    public static String getMd5(String input) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);


            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


    }


}
