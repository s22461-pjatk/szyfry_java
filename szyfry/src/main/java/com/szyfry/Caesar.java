package com.szyfry;

public class Caesar {
        String alpha;

    public Caesar() {
        this.alpha = new String("aąbcćdeęfghijklłmnńoópqrsśtuvwxyzźż");     
    }

    public Caesar(String alpha) {
        this.alpha = alpha;

    }

    public char[] encrypt(char[] message, int shift) {
        
        char[] letters = alpha.toCharArray();
        char[] cryptogram = new char[message.length];

        for(int i = 0; i < message.length; ++i)
        {
            int message_letter_index = alpha.indexOf(Character.toLowerCase(message[i]));
            if (message_letter_index == -1) {
                cryptogram[i] = " ".charAt(0);
            }
            else {
                cryptogram[i] = letters[((message_letter_index + shift + letters.length)%letters.length)];
            }            
        }
        
        return cryptogram;

    }

    public char[] decrypt(char[] cryptogram, int shift) {
        char[] letters = alpha.toCharArray();
        char[] message = new char[cryptogram.length];

        for(int i = 0; i < message.length; ++i)
        {
            int cryptogram_letter_index = alpha.indexOf(Character.toLowerCase(cryptogram[i]));
            if (cryptogram_letter_index == -1) {
                message[i] = " ".charAt(0);
            }

            else {
                message[i] = letters[((cryptogram_letter_index - shift + letters.length)%letters.length)];
            }
        }

        return message;
    }
}
