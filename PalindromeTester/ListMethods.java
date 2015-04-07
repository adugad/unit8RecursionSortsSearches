import java.util.*;

public class ListMethods
{
    public static ArrayList makeList(int n)
    {
        ArrayList<Integer> tempList = null;
        if (n <= 0)
        {


        }
        else
        {


        }
        return tempList;
    }

    public static ArrayList<Integer> reverseList(ArrayList<Integer> list) 
    {
        ArrayList<Integer> list = ListMethods.deepClone(tList); 
        if (list.size() <= 1)
        {
            return list;
        }
        else
        {
            char c = list.get(0);
            list.remove(0);
            list.add(c);
        }
        return list;
    }

    public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        for (Integer i : tList)
        {
            list.add(new Integer(i));
        }
        return list;
    }
}
