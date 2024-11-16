package com.board.common.util;

public final class Base62Util {

    private static final String BASE62_CHARS =
            "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String encode(long number) {
        if(number == 0){
            return Character.toString(BASE62_CHARS.charAt(0));
        }

        final StringBuilder sb = new StringBuilder();
        while(number > 0){
            int reminder = (int) (number % 62);
            sb.append(BASE62_CHARS.charAt(reminder));
            number /= 62;
        }

        return sb.reverse().toString();
    }

    public static long decode(String str){
        long result = 0;

        for(int i = 0; i < str.length(); i++) {
            result = result * 62 + BASE62_CHARS.indexOf(str.charAt(i));
        }

        return result;
    }

}
