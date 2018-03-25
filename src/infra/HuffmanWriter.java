package infra;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class HuffmanWriter {

    public void saveFile(String filePath, HashMap<Integer,Integer> frequency, String finalCode){

        try(FileWriter fileWriter = new FileWriter(new File(filePath))){
            for (Integer integer : frequency.keySet()){
                fileWriter.write(integer + " " + frequency.get(integer) + " ");
            }
            fileWriter.write("\n" + finalCode);
        } catch (IOException e) {
            System.out.println("Não foi possível salvar o arquivo");
        }

    }

}
