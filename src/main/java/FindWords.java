import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by veyra.gutierrez on 13/04/2016.
 */
public class FindWords {

    FileReader reader = null;
    BufferedReader bReader = null;
    CapitalizeReader cReader = null;

    String allText = "";
    List<String> oListDictionary = null;


    public FindWords(){
        getWords();
    }
    public List<String> getWords() {
        try {
            reader = new FileReader("C:\\Temp\\Text50Words.txt");
            bReader = new BufferedReader(reader);
            //cReader = new CapitalizeReader(bReader);
            oListDictionary = new ArrayList<String>();

            String line;
            while ((line = bReader.readLine()) != null) {
                //allText += line + "\n";
                oListDictionary.add(line);

            }

            return oListDictionary;

        } catch (FileNotFoundException eFielNotFound) {
            eFielNotFound.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        String sWordToIterate = sInputText.toUpperCase();
        int iStringLenght = sWordToIterate.length();
        List<String> oListPossibleWords = new ArrayList<String>();
        List<String> oListFinalPWords = new ArrayList<String>();

        char [] aCharToIterate = sWordToIterate.toCharArray();
        char [] aCharPossibleWord;


        for (String anOListDictionary : oListDictionary) {
            if (anOListDictionary.toString().length() == iStringLenght) {
                oListPossibleWords.add(anOListDictionary);
            }
        }


        for (String sPossibleWord: oListPossibleWords) {

            sPossibleWord.contains(sInputText);

//            boolean bCharOk = false;
//            int iCharsCount = 0;
//            aCharPossibleWord = sPossibleWord.toCharArray();

//            for (int j= 0; j< aCharToIterate.length; j++) {
//                for (int k=0; k< sPossibleWord.length(); k++) {
//                    if (aCharToIterate[j]==aCharPossibleWord[k])
//                    {
//                        bCharOk = true;
//                        iCharsCount++;
//                        break;
//                    }
//                }
//            }
//            if(bCharOk && (iCharsCount == aCharToIterate.length)){
//                System.out.println("Posible Word:" + sPossibleWord);
//                oListFinalPWords.add(sPossibleWord);
//            }

        }

        return oListFinalPWords;
    }

}
