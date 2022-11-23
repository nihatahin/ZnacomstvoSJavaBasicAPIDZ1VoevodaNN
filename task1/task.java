package task1;

import java.util.Scanner;




public class task {
    public static void main(String[] args) {
        int num = enter_num();

        System.out.println("Sum from 1 to " + num + " is " + add_mass(num) + ".");
        System.out.println("Production from 1 to " + num + " is " + mul_mass(num) + ".");
    }

    public static int add_mass(int fin) {
        int sum = 0;
        for (int i = 1; i <= fin; ++i)
        {
            sum += i;
        }
        return sum;
    }

    public static int mul_mass(int fin) {
        int mul = 1;
        for (int i = 1; i <= fin; ++i)
        {
            mul *= i;
        }
        return mul;
    }


    public static int validation(String str_n) {
        try{
            return (Integer.parseInt(str_n) > 0) ? 1 : -1;    
        }
        catch (NumberFormatException ex){
            return -2;
        }
    }
    
    public static void validation_print(int id) {
        switch(id)
        {
            case -1:
                System.out.println("Non positive value was entered!");
                return;
            case -2:
                System.out.println("Non integer value was entered");
                return;
            case 1:
                return;
            default:
                System.out.println("ERROR!!!");
                return;
        }

    }

    public static int enter_num() {
        Scanner iScanner = new Scanner(System.in);
        String str_num = "";
        int is_valid = 0;
        while(!(is_valid == 1))
        {
            System.out.printf("Enter integer positive number: ");
            str_num = iScanner.nextLine();
            is_valid = validation(str_num);
            validation_print(is_valid);
        }
        iScanner.close();
        return Integer.parseInt(str_num);
    }


}
