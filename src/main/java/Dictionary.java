/**
 * Created by veyra.gutierrez on 13/04/2016.
 */
public enum Dictionary {
    MONTERREY("MONTERREY"),
    HOUSE("HOUSE"),
    CAR ("CAR"),
    DICTIONARY ("DICTIONARY"),
    ANIMAL("ANIMAL"),
    BIRD("BIRD"),
    TABLE("TABLE"),
    CABLE("CABLE"),
    USA("USA"),
    MEXICO("MEXICO"),
    AMERICAN("AMERICAN"),
    ;


    private final String sWord;

    private  Dictionary(String sPalabra){
        this.sWord = sPalabra;
    }

//    public void setDictionary(){
//
//    }

    public String getWord(){
        return sWord;
    }
}
