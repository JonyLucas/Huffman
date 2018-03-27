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

    private DataOutputStream writer;

    public void saveFile(String filePath, HashMap<Integer,Integer> frequency, String finalCode){

        try {
            writer = new DataOutputStream(new FileOutputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String frequencies = "";

        for (Integer integer : frequency.keySet()){
            frequencies += integer + " " + frequency.get(integer) + " ";
        }

        frequencies += "\n";

        try {
            writer.writeBytes(frequencies);
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
                writer.writeByte(aux);
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
