package infra;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

public class HuffmanWriter {

    BufferedWriter writer;

    public void saveFile(String filePath, HashMap<Integer,Integer> frequency, String finalCode){

        try {
            writer = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String frequencies = "";

        for (Integer integer : frequency.keySet()){
            frequencies += integer + " " + frequency.get(integer) + " ";
            //System.out.println("Char: " + (char) (int) integer + " - F: " + frequency.get(integer));
        }

        frequencies += "\n";

        try {
            writer.write(frequencies);
            writeCode(around(finalCode));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeCode(String finalCode) throws IOException
    {
        int aux = 0, k = 7;

        for(int i = 0; i < finalCode.length(); i++)
        {
            aux += Character.getNumericValue(finalCode.charAt(i))*Math.pow(2, k);
            k--;
            if(k < 0)
            {
                k = 7;
                writer.write(aux);
                aux = 0;
            }
        }
    }

    private String around(String finalCode)
    {
        while(finalCode.length()%8 != 0) {
            finalCode += '0';
        }
        return finalCode;
    }

}
