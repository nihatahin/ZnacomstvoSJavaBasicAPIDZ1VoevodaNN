package task4;

import java.util.Scanner;



public class task {
    public static void main(String[] args) {
        System.out.println("Mathematical expression type: a + b = c");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter a. You can use digits or '?': ");
        String a = enter_x_num(scanner);
        System.out.printf("Enter b. You can use digits or '?': ");
        String b = enter_x_num(scanner);
        System.out.printf("Enter c. You can use digits or '?': ");
        String c = enter_x_num(scanner);
        scanner.close();
        System.out.println("Input expression: " + a + " + " + b + " = " + c);
        //---------
        
        
        if (length_check(a.length(),b.length(),c.length()))
        {
            System.out.println("Solution variants:");
            int[] boards_a = boards_int(a);
            int[] boards_b = boards_int(b);
            int[] boards_c = boards_int(c);
            int sum_var = 0;
            int i_a = boards_a[0];
            while(i_a <= boards_a[1])
            {
                int i_b = boards_b[0];
                while(i_b <= boards_b[1])
                {
                    int i_c = boards_c[0];
                    while(i_c <= boards_c[1])
                    {
                        int var_a = merge(a, i_a);
                        int var_b = merge(b, i_b);
                        int var_c = merge(c, i_c);
                        if ((var_a + var_b) == var_c)
                        {
                            System.out.println(var_a + " + " + var_b + " = " + var_c);
                            sum_var += 1;
                        }
                        ++i_c;
                    }
                    ++i_b;
                }
                ++i_a;
            }
            System.out.println("Number of solutions: " + sum_var + ".");
            if (sum_var == 0)
                System.out.println("No solution!");
        }
        else
            System.out.println("No solution! Invalid parameters digit depth!");
    }

    public static int merge(String oper, int invar){
        char[] ch_oper = oper.toCharArray();
        int ch_len = ch_oper.length;
        int fin = 0;
        for (int i = ch_len - 1; i >= 0 ; --i)
        {
            if (ch_oper[i] == '?')
            {
                ch_oper[i] = (char)(invar % 10 + '0'); 
                invar/= 10;
            }
            fin += (int)Math.pow(10, ch_len - 1 - i) * Character.digit(ch_oper[i], 10);
        }
        return fin;
    }


    public static int[] boards_int(String oper){
        char[] ch_oper = oper.toCharArray();
        int len = ch_oper.length;
        int digit_range = qm_number(oper);
        int[] min_max = new int[2];
        min_max[0] = ((start_qm_flag(ch_oper[0])) && (len > 1)) ? (int)Math.pow(10, (digit_range - 1)) : 0;
        min_max[1] =(int)Math.pow(10, (digit_range)) - 1;
        

        return min_max;
    }

    public static boolean start_qm_flag(char st){
        return st == '?';
    }

    public static int qm_number(String num){
        int qm_sum = 0;
        char[] ch_arr_num = num.toCharArray();
        for (int i = 0; i < ch_arr_num.length; ++i)
            if (ch_arr_num[i] == '?')
                qm_sum += 1;
        return qm_sum;
    }

    public static boolean length_check(int la, int lb, int lc) {
        if ((la > lc) || (lb > lc))
            return false;
        else if ((la < lc - 1) && (lb < lc - 1))
            return false;
        else
            return true;
    }

    public static boolean validation(String str) {
        char[] ch_arr = str.toCharArray();
        if ((ch_arr[0] == '0') && (ch_arr.length > 1))
        {
            System.out.printf("Number can't start with 0. Try again: ");
            return false;
        }
        else
        {
            for (int i = 0; i < ch_arr.length; ++i)
            {
                if (!is_digit_or_qm(ch_arr[i]))
                {
                    System.out.printf("Invalid symbols! Try again: ");
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean is_digit_or_qm(char sym)
    {
        switch(sym)
        {
            case '?':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false; 


        }

    }


    public static String enter_x_num(Scanner iScanner) {
        String str_num = "";
        boolean is_valid = false;
        while(!is_valid)
        {
            str_num = iScanner.nextLine();
            is_valid = validation(str_num);
        }
        return str_num;
    }

}
