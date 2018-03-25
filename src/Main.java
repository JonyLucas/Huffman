import controller.HuffmanEncoder;
import controller.HuffmanCounter;
import infra.HuffmanWriter;

public class Main
{
    public static void main (String args[])
    {
        String path = "C:\\Users\\Joao\\IdeaProjects\\huffmanEncoder\\src\\examples\\file.txt";

        HuffmanCounter huffmanCounter = new HuffmanCounter(path);
        huffmanCounter.readAndCount();

        HuffmanEncoder huffmanEncoder = new HuffmanEncoder(path, huffmanCounter.getFrenquency());
        huffmanEncoder.readAndDecrement();

        new HuffmanWriter().saveFile("C:\\Users\\Joao\\IdeaProjects\\huffmanEncoder\\src\\examples\\result.txt", huffmanCounter.getFrenquency(), huffmanEncoder.getCode());
    }

}
