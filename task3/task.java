package task3;

import java.util.Scanner;




public class task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter first operand (double type number): ");
        double num1 = enter_num(scanner);
        System.out.printf("Enter second operand (double type number): ");
        double num2 = enter_num(scanner);
        System.out.printf("Enter operator (+, -, * or /): ");
        char oper = enter_oper(scanner);
        
        scanner.close();

        System.out.println(num1 + " " + oper + " " + num2 + " = " + operation(num1, num2, oper));
    }

    public static double operation(double n1, double n2, char o) {
        switch(o)
        {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
        }
        return 0.0;
    }

    public static boolean validation(String str_n) {
        try{
            Double.parseDouble(str_n);
            return true;    
        }
        catch (NumberFormatException ex){
            System.out.printf("Invalid value was entered! Try again: ");
            return false;
        }
    }
    
    public static double enter_num(Scanner iScanner) {
        String str_num = "";
        boolean is_valid = false;
        while(!is_valid)
        {
            str_num = iScanner.nextLine();
            is_valid = validation(str_num);
        }
        return Double.parseDouble(str_num);
    }


    public static boolean validation_ch(String str_n) {
        switch(str_n)
        {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            default:
                System.out.printf("Invalid operator was entered! Try again: ");
                return false;
        }
    }

    public static char enter_oper(Scanner iScanner) {
        
        String str_num = "";
        boolean is_valid = false;
        while(!is_valid)
        {
            str_num = iScanner.nextLine();
            is_valid = validation_ch(str_num);
        }
        
        return str_num.toCharArray()[0];
    }


}
