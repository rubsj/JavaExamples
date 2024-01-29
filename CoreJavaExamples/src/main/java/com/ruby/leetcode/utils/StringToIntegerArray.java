package com.ruby.leetcode.utils;

public class StringToIntegerArray {
    // converts "[1,2,4]" to new int[]{1, 2, 4}

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    // converts "[1,2, NULL,4]" to new Integer[]{1, 2, null, 4}
    public static Integer[] leetcodeStringToArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new Integer[0];
        }

        String[] parts = input.split(",");
        Integer[] output = new Integer[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = part.equalsIgnoreCase("NULL") ? null: Integer.parseInt(part);
        }
        return output;
    }


}
