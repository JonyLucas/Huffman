package infra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

public class HuffmanWriter {

    public void saveFile(String filePath, HashMap<Integer,Integer> frequency, String finalCode){

        String frequencies = "";

        for (Integer integer : frequency.keySet()){
            frequencies += integer + " " + frequency.get(integer) + " ";
        }

        frequencies += "\n";

        try {
            Files.deleteIfExists(Paths.get(filePath));
            Files.createFile(Paths.get(filePath));
            Files.write(Paths.get(filePath), frequencies.getBytes(), StandardOpenOption.WRITE);
            writeCode(around(finalCode), filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*

        try(FileWriter fileWriter = new FileWriter(new File(filePath))){
            for (Integer integer : frequency.keySet()){
                fileWriter.write(integer + " " + frequency.get(integer) + " ");
            }
            fileWriter.write("\n");

            byte[] b = toBytes(around(finalCode));
            fileWriter.write(cb);
        } catch (IOException e) {
            System.out.println("Não foi possível salvar o arquivo");
        }
        */
    }

    private void writeCode(String finalCode, String filePath) throws IOException
    {
        byte[] b = new byte[1];

        int aux = 0, j = 0, k = 7;

        for(int i = 0; i < finalCode.length(); i++)
        {
            aux += Character.getNumericValue(finalCode.charAt(i))*Math.pow(2, k);
            k--;

            if(k < 0)
            {
                k = 7;
                b[0] = (byte) aux;
                //System.out.println("Char: " + (char) aux + " value: " + aux);
                Files.write(Paths.get(filePath), b, StandardOpenOption.APPEND);
                aux = 0;
            }
        }
    }

    private String around(String finalCode)
    {
        while(finalCode.length()%8 != 0)
        {
            finalCode += '0';
        }

        return finalCode;
    }

}
