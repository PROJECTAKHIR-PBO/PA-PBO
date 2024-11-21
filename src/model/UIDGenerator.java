/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Random;

/**
 *
 * @author Regar
 */
public class UIDGenerator {
    private static String generateRandomChar(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            randomString.append(chars.charAt(index));
        }

        return randomString.toString();
    }
    
    public static String generateUID() {
        String randomChar = generateRandomChar(10);
        return randomChar;
    }
}
