import java.util.Scanner;
import java.io.File;

public class WC
{
    public static void main(String[] args) throws java.io.FileNotFoundException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the file name: ");
        String name = in.nextLine();
        File inputFile = new File(name + ".txt");
        Scanner in2 = new Scanner(name);
        in2.reset();
        in2.useDelimiter("");
        int in2int = 0;
        while(in2.hasNext())
        {
            char ch = in2.next().charAt(0);
            in2int++;
        }
        System.out.println(in2int);
        in2.useDelimiter(" ");
        int in2int2 = 0;
        while(in2.hasNext())
        {
            char ch = in2.next().charAt(0);
            in2int2++;
        }
        System.out.println(in2int2);
        in2.useDelimiter("\n");
        int in2int3 = 0;
        while(in2.hasNext())
        {
            char ch = in2.next().charAt(0);
            in2int3++;
        }
        System.out.println(in2int3);
        in2.close();
    }
}