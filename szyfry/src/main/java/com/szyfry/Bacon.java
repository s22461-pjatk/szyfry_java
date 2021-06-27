package com.szyfry;
import java.lang.Math;
import javax.swing.JOptionPane;

public class Bacon {
    String alpha;
    char[] bacons;

    public Bacon() {
        this.alpha = new String("aąbcćdeęfghijklłmnńoópqrsśtuvwxyzźż");
        this.bacons = "ab 01".toCharArray();
        
    }

    public Bacon(String alpha, char[] bacons) {
        this.alpha = alpha;

    }
    public char[] encrypt(char[] message) {

        char[] letters = alpha.toCharArray();
        String bacon_len = Integer.toString(letters.length, 2);

        char[] cryptogram = new char[(message.length)*(bacon_len.length()+1)];

        for(int i = 0; i < message.length; ++i)
        {   
            int message_letter_index = alpha.indexOf(Character.toLowerCase(message[i]));
            if (message_letter_index == -1)
            {
                cryptogram[(i*bacon_len.length())+2] = " ".charAt(0);
            }
            else{
            
                for(int j = bacon_len.length() -1; j > -1; --j){

                    if (message_letter_index%2 == 1){
                        cryptogram[(bacon_len.length()+1)*i + j] = bacons[1];    
                    }

                    if(message_letter_index%2 == 0) {
                        cryptogram[(bacon_len.length()+1)*i + j] = bacons[0];
                           
                    }
                    message_letter_index = (message_letter_index - message_letter_index%2)/2;
                }           
            }
        }
        return cryptogram;

    }
    public char[] decrypt(char[] cryptogram) {
        char[] letters = alpha.toCharArray();
        String bacon_len = Integer.toString(letters.length, 2);


        char[] message = new char[cryptogram.length];
        char[] letter = new char[bacon_len.length()];
        int j = 0;
        int index = 0;
        
        for(int i = 0; i < cryptogram.length; ++i){
            if ((cryptogram[i] == bacons[0] || cryptogram[i] == bacons[1]) || cryptogram[i] == bacons[2]){

            if (cryptogram[i] != bacons[2]){

                if (cryptogram[i] == bacons[0]) {
                    letter[j] = bacons[3];
                    
                }

                else if (cryptogram[i] == bacons[1]) {
                    letter[j] = bacons[4];
                    index += Math.pow(2, bacon_len.length()-j-1);
                    System.out.println(index);
                    
                }

                j = j+1;
            }

            if (cryptogram[i] == bacons[2]) {
                message[i] = bacons[2];
            }

            if (j == bacon_len.length()){
                letter = new char[bacon_len.length()];

                if (index < letters.length){
                    message[i] = letters[index];       
                }
                j = 0;
                index = 0;
            }
            }
            else {
                JOptionPane.showMessageDialog(null, "Hej wprowadziłeś nie te znaki do deszyfracji!");
                break;
            }
        }
            
        return message;

    }
}
