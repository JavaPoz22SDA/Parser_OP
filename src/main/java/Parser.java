import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    private Path file =  Paths.get( "file.csv");

    public List<RealEstate> readFile() throws IOException {

        byte[] data = Files.readAllBytes(file);
        String convertData = new String(data);
        String[] dataArray = convertData.split("\\r");

        List<String> dataList =new ArrayList<>(Arrays.asList(dataArray)) ;
        dataList.remove(0);
        List<RealEstate> newListEstate = new ArrayList<>();

        for( String line : dataList){ // wyswitluje cilyj plik w konsoli

            String[] l = line.split(",");
            String street = l[0];
            String city = l[1];
            Integer zip = Integer.parseInt(l[2]);
            String state = l[3];
            Integer beds = Integer.parseInt(l[4]);
            Integer baths = Integer.parseInt(l[5]);
            Integer squareFt = Integer.parseInt(l[6]);
            String type = l[7];
            String saleDates = l[8];
            Integer price = Integer.parseInt(l[9]);
            Float lat = Float.parseFloat(l[10]);
            Float lot = Float.parseFloat(l[11]);
            newListEstate.add(new RealEstate(street, city, zip, state, beds, baths, squareFt, type, saleDates, price, lat,lot));

        }



        return newListEstate;
    }
}
