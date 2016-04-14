import java.util.ArrayList;
import java.util.List;

/**
 * Created by veyra.gutierrez on 13/04/2016.
 */
public class MainClass {
    private static List<String> oList = new ArrayList<String>();

    public static void main (String [] args){
        FindWords oFindWords = new FindWords();
        oList= oFindWords.getListPossibleWords("LSTA");

        System.out.println(oList.toString());

    }
}
