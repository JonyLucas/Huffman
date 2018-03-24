package model;

public class HuffmanNode {

    private HuffmanNode leftSon, rightSon;
    private int frequencySum = 0;

    public HuffmanNode(HuffmanNode leftSon, HuffmanNode rightSon){
        this.leftSon = leftSon;
        this.rightSon = rightSon;
        frequencySum = leftSon.getFrequency() + rightSon.getFrequency();
    }

    public int getFrequency(){
        return this.frequencySum;
    }

}
