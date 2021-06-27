package com.szyfry;
public class Vigenere {
    String alpha;

    public Vigenere() {
        this.alpha = new String("abcdefghijklmnopqrstuvwxyz");    
    }
    
    public Vigenere(String alpha) {
        this.alpha = alpha;
    }

    public char[] encrypt(char[] message, char[] key) {
        char[] letters = alpha.toCharArray();
        char[] cryptogram = new char[message.length];
        
        for(int i = 0; i < message.length; ++i)
        {   
            int message_letter_index = alpha.indexOf(Character.toLowerCase(message[i]));
            int key_letter_index = alpha.indexOf(Character.toLowerCase(key[i%key.length]));
            if (message_letter_index == -1 | key_letter_index == -1)
            {
                cryptogram[i] = " ".charAt(0);
            }

            else
            {
                cryptogram[i] = letters[(message_letter_index + key_letter_index)%letters.length];
            } 

            
        }
        
        return cryptogram;
    }
        
    public char[] decrypt(char[] cryptogram, char[] key) {

        char[] letters = alpha.toCharArray();
        char[] message = new char[cryptogram.length];
            
        for(int i = 0; i < message.length; ++i)
        {   
            int cryptogram_letter_index = alpha.indexOf(Character.toLowerCase(cryptogram[i]));
            int key_letter_index = alpha.indexOf(Character.toLowerCase(key[i%key.length]));
            if (cryptogram_letter_index == -1 | key_letter_index == -1)
            {
                message[i] = " ".charAt(0);
            }

            else {
                message[i] = letters[(cryptogram_letter_index - key_letter_index + letters.length)%letters.length];  
            }
            
        }
            
        return message;

    
    }
}
