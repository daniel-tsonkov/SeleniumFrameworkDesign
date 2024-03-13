package rahulshettyacademy.data;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DataReader {
    public String getJsonDataMap() throws IOException {
        //read JSON file
        String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json"));

        //convert to hashMap

    }
}
