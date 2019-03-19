

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.ArrayList;

public class NoobChain {
    public static ArrayList<Block> blockchain  =  new ArrayList<Block>();
    public static int difficulty =0;
    public static void main(String[] args) {
        byte[] key = "hello world".getBytes();
        String a = new BASE64Encoder().encode(key);
        System.out.println("hello world");
        System.out.println(key);
        System.out.println(a);
        try {
            byte[] kenDen = new BASE64Decoder().decodeBuffer(a);
            System.out.println(new String(kenDen));
        }catch (Exception e)
        {}



        Block genesisBlock = new Block("this is the first block ","0");
        System.out.println("Hash for the block 1:"+ genesisBlock.getHash());
        genesisBlock.mineBlock(difficulty);


        Block sencondBlock  =  new Block("this is the second block",genesisBlock.getHash());
        System.out.println("hash for block 2 :" +sencondBlock.getHash());
        sencondBlock.mineBlock(difficulty);

        Block thirdBlock  =  new Block("this is the third block :",sencondBlock.getHash());
        System.out.println("hash for block 3 :"+ thirdBlock.getHash());
        thirdBlock.mineBlock(difficulty);



        blockchain.add(genesisBlock);
        blockchain.add(sencondBlock);
        blockchain.add(thirdBlock);
        System.out.println("blockchain is  valid :" + StringUtil.isChainValid(blockchain));
        //String blockchainJson =  new JSONWriter(blockchain);
    }
}
