import static java.lang.Character.isDigit;
import static java.lang.System.exit;

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
    public static void main(String[] args) {
        long startTime = System.nanoTime();


        if(isInteger(args[0]))
        {
            System.out.println("Your argument is an integer");
        }
        else {
            System.out.println("Your argument is NOT an integer");
            exit(1);
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

        String[] lineArr = new String[n];
        String[] columnArr = new String[n];

        for (int i = 0; i < n; i++) {
            String line = "";
            for (int j = 0; j < n; j++) {
                line += Integer.toString(matrix[i][j]);
            }
            lineArr[i] = line;
            if(n <= 30000)
            {
                System.out.println("Line " + i + ": " + lineArr[i]);
            }

        }

        for (int i = 0; i < n; i++) {
            String column = "";
            for (int j = 0; j < n; j++) {
                column += Integer.toString(matrix[j][i]);
            }
            columnArr[i] = column;
            if(n <= 30000)
            {
                System.out.println("Column " + i + ": " + columnArr[i]);

            }
        }



        if(n > 30000)
        {
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(totalTime);
        }
    }
}
