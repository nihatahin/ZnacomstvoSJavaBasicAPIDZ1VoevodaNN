package task2;

public class task {
    public static void main(String[] args) {
        int n = 1000;
        System.out.printf("List of prime numbers from 1 to 1000:");
        for (int i = 2; i <= n; ++i)
        {
            boolean is_primer = true;
            for (int j = 2; j <= (int)(Math.sqrt(i)); ++j)
            {
                if (i % j == 0)
                {
                    is_primer = false;
                    break;
                }
            }
            if (is_primer)
                System.out.printf(" " + i);
        }
        System.out.println();
    }


}
