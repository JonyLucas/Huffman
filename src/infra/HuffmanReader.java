package infra;

import java.io.*;

public class HuffmanReader
{
    private FileInputStream fileInputStream;
    private BufferedReader reader;

    public HuffmanReader(String filePath)
    {
        File file = new File(filePath);

        try {
            reader = new BufferedReader( new InputStreamReader( new FileInputStream( filePath ), "UTF-8" ) );
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
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

            current = reader.read();
            return current;

        } catch (IOException e) {
            reader.close();
            throw new Exception("Falha na leitura de arquivo");
        }

    }

    public void close() throws IOException {
        reader.close();
    }


}
