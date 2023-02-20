import static java.lang.Character.isDigit;

public class Main {

    static boolean isInteger(String str)
    {
        for (int i = 0; i < str.length(); i++) {

            // Print current character
            if( !(isDigit(str.charAt(i))))
            {
                return false;
            }

        }
        return true;
    }
    String printLine(int n, int matrix[][])
    {
        String str = "";
        for(int j = 0; j < n; j++)
        {
            str = str + (char)matrix[n][j];
        }
        return str;
    }

    String printColumn(int n, int matrix[][])
    {
        String str = "";
        for(int i = 0; i < n; i++)
        {
            str = str + (char)matrix[i][n];
        }
        return str;
    }
    public static void main(String[] args) {

        System.out.println("Hello world!");

        if(isInteger(args[0]))
        {
            System.out.println("Your argument is an integer");
        }
        else {
            System.out.println("Your argument is NOT an integer");
        }

        int n = Integer.parseInt(args[0]);

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int[][] matrix = new int[n][n];

        int k = 0;
        for(int i = 0; i < n; i++)
        {

            for(int j = 0; j < n; j++)
            {
                matrix[i][j] = arr[(k + j) % n];
                System.out.print(matrix[i][j] + " ");
            }
            k++;
            System.out.println("");
        }


    }
}