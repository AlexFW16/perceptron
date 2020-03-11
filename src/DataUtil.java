import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DataUtil {

    //utility class to get input from .data files and convert it into usable lists
    public static ArrayList<double[]> getInputFromFile(String path, String separator, Boolean shuffle){

         ArrayList<double[]> outList = new ArrayList<>();
        try {
            InputStream data = new FileInputStream(new File(path));
            Scanner sc = new Scanner(data);
            ArrayList<String> dataList = new ArrayList<>();

            sc.forEachRemaining(dataList::add);

            dataList.forEach(element ->{

                String[] contentArray = element.split(separator);
                double[] contentArrayDouble = new double[contentArray.length];

                for(int i = 0; i<contentArray.length; i++)
                    contentArrayDouble[i] = Double.parseDouble(contentArray[i]);

                outList.add(contentArrayDouble);
            });

            if(shuffle)
                Collections.shuffle(outList);

    }

        catch (IOException e){
            e.printStackTrace();
        }

        return outList;
    }
}
