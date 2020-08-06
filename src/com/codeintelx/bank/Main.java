package com.codeintelx.bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

    System.out.println("Enter 1 to create an account");
    System.out.println("Enter 2 to view account by account number");
    System.out.println("Enter 3 to withdraw from an account");
    System.out.println("Enter 4 to deposit to an account");

    int service = input.nextInt();
        while (service<1 || service>4) {
            System.out.println("invalid input, please select options 1 - 4");
             service = input.nextInt();
        }
            switch (service) {
                case 1:
                    System.out.println("Selected 1 to create an account");
                    break;
                case 2:
                    System.out.println("Selected 2 to view account by account number");
                    break;
                case 3:
                    System.out.println("Selected 3 to withdraw from an account");
                    break;
                case 4:
                    System.out.println("Selected: 4 to deposit to an account");
                    break;
                default:
                    // code block
            }
        }



    }


