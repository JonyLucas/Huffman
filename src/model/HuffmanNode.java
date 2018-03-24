package model;

import java.util.ArrayList;

public class HuffmanNode {

    private HuffmanNode leftSon, rightSon;
    private int frequencySum = 0;
    private ArrayList<String> symbols = new ArrayList<>();


    public HuffmanNode(HuffmanNode leftSon, HuffmanNode rightSon){
        this.leftSon = leftSon;
        this.rightSon = rightSon;
        frequencySum = leftSon.getFrequency() + rightSon.getFrequency();
        symbols.addAll(leftSon.getSymbols());
        symbols.addAll(rightSon.getSymbols());
    }

    public HuffmanNode(String symbol, int frequency) {
        symbols.add(symbol);
        frequencySum = frequency;
    }

    public int getFrequency(){
        return this.frequencySum;
    }

    public ArrayList<String> getSymbols() {
        return symbols;
    }

    public HuffmanNode getLeftSon() {
        return leftSon;
    }

    public HuffmanNode getRightSon() {
        return rightSon;
    }
}
