package infra;

import java.io.*;

public class HuffmanReader
{
    private FileInputStream fileInputStream;

    public HuffmanReader(String filePath)
    {
        File file = new File(filePath);

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public HuffmanReader()
    {
        this("file");
    }

    public int nextByte() throws Exception
    {
        int current = -1;
        try {

            current = fileInputStream.read();
            System.out.print(current);
            return current;

        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }

    }


}