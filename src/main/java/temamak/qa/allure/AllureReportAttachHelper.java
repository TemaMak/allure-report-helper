package temamak.qa.allure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.qameta.allure.Allure;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AllureReportAttachHelper {
    /**
     * Attache buffered image to allure report
     * @param image
     * @param comment
     */
    public static void attacheBufferedImage(BufferedImage image, String comment){
        if(image == null){
            return;
        }

        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "png", os);
            InputStream is = new ByteArrayInputStream(os.toByteArray());

            Allure.addAttachment(comment, is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * Attache pretty-print formatted json
     * @param name
     * @param json
     */
    public static void attacheJson(String name, String json){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(json);
        String prettyJsonString = gson.toJson(je);

        Allure.addAttachment(name, "application/json", prettyJsonString);
    }

}
