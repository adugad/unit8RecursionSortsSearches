import java.net.URL;
import java.util.Scanner;
import java.io.PrintWriter;
public class WebPage
{
    public static void main(String[] args) throws java.net.MalformedURLException, java.io.IOException
    {
        String address = "http://www.naperville203.org/nnhs";
        URL pageLocation = new URL(address);
        Scanner in = new Scanner(pageLocation.openStream());
        PrintWriter out = new PrintWriter("output.txt");
        in.useDelimiter("\n");
        while(in.hasNext())
        {
            out.println(in.next());
        }
        out.close();
        in.close();
    }
}