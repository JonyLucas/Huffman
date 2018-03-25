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
            return current;

        } catch (IOException e) {
            fileInputStream.close();
            throw new Exception("Falha na leitura de arquivo");
        }

    }

    public void close() throws IOException {
        fileInputStream.close();
    }


}
