import static java.lang.Math.pow;

public class Main {

    public static int getDigitsSum(int n)
    {
        int sum = 0;
        while(n != 0)
        {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
    public static int getDecimal(String hex){
        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int val = 0;
        for (int i = 0; i < hex.length(); i++)
        {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }
    public static void main(String[] args) {

        System.out.println("Hello world!\n");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        n *= 3;

        n += pow(2, 4) + pow(2, 2) + pow(2, 0);

        n += getDecimal("FF");

        n *= 6;

        int nr = getDigitsSum(n);
        while(nr < 9 || nr > 9)
        {
            nr = getDigitsSum(nr);
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[nr]);
    }
}