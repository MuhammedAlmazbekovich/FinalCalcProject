package com.company;

import java.util.Scanner;

public class Calculator {

    static String[] pars(String input) {
        String[] inputWord = input.split(" ");
        if (inputWord.length != 3 ) {
            Scanner input_a_value_again = new Scanner(System.in);
            System.out.println("Вводите неправильное значение");
            input = input_a_value_again.nextLine();
            return pars(input);
        } else {
            return inputWord;
        }
    }



    public static void calc(){
        Scanner inputOperationWord = new Scanner(System.in);

        System.out.print("Введите выражение, разделяя каждый символ пробелом -> ");

        String input = inputOperationWord.nextLine();

        while (!input.isEmpty()) {
            String[] inputWord = Calculator.pars(input);
            String operation = inputWord[1];

            int value1 = 0;
            int value2 = 0;

            boolean numbers = true;

            try {
                value1 = Integer.parseInt(inputWord[0]);
                value2 = Integer.parseInt(inputWord[2]);
                if (value1 <= 10 && value2 <= 10) {
                    System.out.println();
                }

            } catch(NumberFormatException exception){
                System.out.println("Введены римские цифры");
            }

            Number values = new Operation(value1, value2);

            if (operation.equals("*") && value1 <= 10 && value2 <= 10) {
                values.mul();

            } else if (operation.equals("/") && value1 <= 10 && value2 <= 10) {
                values.div();

            } else if (operation.equals("+") && value1 <= 10 && value2 <= 10) {
                values.sum();

            } else if (operation.equals("-") && value1 <= 10 && value2 <= 10) {

                values.sub();
            }else {
                System.out.println("Консолго туура эмес маалымат киргиздиниз");
            }
            if (numbers) {
                System.out.println("Ответ: " + values.getResult());
            } else {
                System.out.println("Ответ: " + values.getStringResult());
            }

            input = inputOperationWord.nextLine();
        }
        System.out.println("Вы вышли из калькулятора");
    }
}

