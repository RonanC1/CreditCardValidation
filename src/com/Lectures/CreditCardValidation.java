package com.Lectures;

import javax.swing.*;

public class CreditCardValidation {
    /*
    This is a test.
     */

    public static void main(String[] args) {
	    String cardNumber = JOptionPane.showInputDialog(null, "Enter credentials");
	    String pattern = "^([0-9]{16})|([0-9]{13})$";
        String currentDigit;
        String output;
        int[] digitArray = new int[cardNumber.length()];


        //compare user input to Regex pattern before going any further, to ensure user input conforms to what is needed
        if(cardNumber.matches(pattern)){
            //First put every number in an array
            for(int i=0; i<digitArray.length; i++) {

                //first add current character to a string, the parse to an int
                currentDigit = "" + cardNumber.charAt(i);
                digitArray[i] = Integer.parseInt(currentDigit);
            }

            //The luhnsAlgorithm() method is called, with the digitArray passed as a parameter.
            // If returned true, the credit card is valid. Else, it is invalid
            if(luhnsAlgorithm(digitArray)){
                output = "Credit card is valid.";
            }
            else{
                output = "Credit card is not valid";
            }
        }

        else{
            output = "Incorrect credentials";
        }

        JOptionPane.showConfirmDialog(null, output);
    }


    //This method is passed an array of ints, with the purpose of checking if a sequence of numbers are valid credit
    //card credentials

    public static boolean luhnsAlgorithm(int[] array){
        int digit = 0;
        int total = 0;

        //For loop is used to access each digit of the given credit card number
        for(int i=0; i<array.length; i++) {
            //1. Take every odd positioned digit. Get the character at i in the String
            //then parse int, and multiply by two
            digit = array[i];
            if ((i+1) % 2 == 1) {
                digit *= 2;

                //if the resulting number is > 9, add both numbers together
                if (digit > 9) {
                    int leftDigit = digit / 10;
                    int rightDigit = digit % 10;
                    digit = leftDigit + rightDigit;
                }
                //add to total
                total += digit;
            }

            //Sum all even digits to total
            else{
                total += digit;
            }
        }

        //Mod the result by 10. if it's 0, it's valid and return true
        if(total%10 == 0){
            return true;
        }
        else{
            return false;
        }
    }
}

