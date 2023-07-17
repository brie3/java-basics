package packages.user.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;

import org.apache.commons.codec.binary.Base64;

public class FileOperationJSON extends FileOperationImpl {

    private String fileName;

    public FileOperationJSON(String fileName) {
        super(fileName);
        this.fileName = fileName;
    }

    @Override
    public List<String> readAllLines() {
        List<String> list = super.readAllLines();
        String text = String.join("", list);

        List<String> result = new ArrayList<>();
        List<Map> users = null;
        Gson gson = new Gson();
        try {
            var decodedString = Base64.decodeBase64(text);
            users = gson.fromJson(new String(decodedString), ArrayList.class);
        } catch (Exception e) {
            saveAllLines(new ArrayList<String>());
        }

        if (users == null) {
            return result;
        }

        for (Map map : users) {
            result.add(gson.toJson(map));
        }

        return result;
    }

    @Override
    public void saveAllLines(List<String> lines) {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        Gson gson = new Gson();

        List<Map> result = new ArrayList<>();

        for (String str : lines) {
            Map map = gson.fromJson(str, Map.class);
            result.add(map);
        }

        String text = gson.toJson(result);
        var encodedString = Base64.encodeBase64URLSafeString(text.getBytes());

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(encodedString);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
