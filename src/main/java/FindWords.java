import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by veyra.gutierrez on 13/04/2016.
 */
public class FindWords {

    FileReader reader = null;
    BufferedReader bReader = null;
    List<String> oListDictionary = null;


    public FindWords(){
        getWords();
    }
    public List<String> getWords()
    {
        try {

            reader = new FileReader("src\\utilities\\Text50Words.txt");
            bReader = new BufferedReader(reader);
            oListDictionary = new ArrayList<String>();

            String line;
            while ((line = bReader.readLine()) != null)
            {
                oListDictionary.add(line);
            }

            return oListDictionary;

        }
        catch (FileNotFoundException eFielNotFound)
        {
            eFielNotFound.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            if (bReader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return oListDictionary;
    }


    public List<String> getListPossibleWords(String sInputText){

        //Local variables
        String sWordToIterate = sInputText.toUpperCase();

        int iStringLenght = sWordToIterate.length();

        List<String> oListPossibleWords = new ArrayList<String>();
        List<String> oListFinalPWords = new ArrayList<String>();

        char [] aCharToIterate = sWordToIterate.toCharArray();
        char [] aCharPossibleWord;

        //New list for length

        for (String anOListDictionary : oListDictionary) {
            if (anOListDictionary.toString().length() == iStringLenght) {
                oListPossibleWords.add(anOListDictionary);
            }
        }

        //Discard the words that not match with the Input Word
        for (String sPossibleWord: oListPossibleWords) {

            boolean bCharOk = true;

            aCharPossibleWord = sPossibleWord.toCharArray();

            Arrays.sort(aCharPossibleWord);
            Arrays.sort(aCharToIterate);

            for (int j = 0; j < aCharToIterate.length; j++) {
                    if (aCharToIterate[j] != aCharPossibleWord[j]) {
                        bCharOk = false;
                        break;
                }
            }
            if(bCharOk){
                //System.out.println("Posible Word:" + sPossibleWord);
                oListFinalPWords.add(sPossibleWord);
            }
        }

        //return de final list of words
        return oListFinalPWords;
    }
}
