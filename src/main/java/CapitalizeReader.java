import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by veyra.gutierrez on 09/04/2016.
 */
public class CapitalizeReader extends BufferedReader{

    @Override
    public String readLine(){
        String line = null;
        try {
            line = super.readLine();
            if(line != null){
                return line.toUpperCase();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public CapitalizeReader(Reader reader) {
        super(reader);
    }
}
