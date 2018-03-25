package model;

public class HuffmanTree {

    private HuffmanNode root;
    private HuffmanNode searchNode;

    public HuffmanTree(HuffmanNode node){
        this.root = node;
        searchNode = root;
    }

    public String codifySymbol(String symbol, String code){
        if(searchNode.hasSymbol(symbol)){
            if(searchNode.getLeftSon().hasSymbol(symbol)){
                searchNode = searchNode.getLeftSon();
                return codifySymbol(symbol, (code+"1"));
            }else if(searchNode.getRightSon().hasSymbol(symbol)){
                searchNode = searchNode.getRightSon();
                return codifySymbol(symbol, (code+"0"));
            }else {
                return code;
            }
        }else{
            return null;
        }
    }

}
