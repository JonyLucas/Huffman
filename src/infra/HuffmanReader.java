package infra;

import java.io.*;

public class HuffmanReader
{
    private DataInputStream reader;

    public HuffmanReader(String filePath)
    {
        try {
            reader = new DataInputStream(new FileInputStream(filePath));
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
        int current = 300;
        try {
            current = reader.readByte();
            return current;

        } catch (EOFException eof)
        {
            reader.close();
            return 300;
        } catch (IOException e) {
            reader.close();
            throw new Exception("Falha na leitura de arquivo");
        }

    }

    public void close() throws IOException {
        reader.close();
    }


}
