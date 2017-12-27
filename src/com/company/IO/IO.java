package com.company.IO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {

    public static int get_Input(String[] options){
        Scanner input = new Scanner(System.in);
        Boolean valid;
        int choice;
        try {
            System.out.printf("What would you like to do (1 - %s)" ,options.length);
            choice = input.nextInt();
            if(choice > options.length) {
                System.out.printf("Input is not in range of %s \n" ,options.length);
                return get_Input(options);
            }

            return choice;
        } catch (InputMismatchException error) {
            System.out.println(error + ". Please enter an integer.");
            return get_Input(options);
        }
    }

    public static void print_Options(String[] options){
        for (int i = 0; i < options.length; i++){
            System.out.println((i+1) + "." + options[i]);
        }
    }

    public static void print_Header(String s){
        System.out.println("===================================");
        System.out.println(s);
        System.out.println("===================================");

    }
}
