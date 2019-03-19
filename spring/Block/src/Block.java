

import java.util.Date;

public class Block {
    public String hash;
    public String previouseHash;
    public String data;
    public long timeStamp;
    public int nonce;
    public Block(String data,String previouseHash)
    {
        this.data = data;
        this.previouseHash = previouseHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash()
    {
        String calculateHash = StringUtil.applySha256(previouseHash+Long.toString(timeStamp)+data);
        return  calculateHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviouseHash() {
        return previouseHash;
    }

    public void setPreviouseHash(String previouseHash) {
        this.previouseHash = previouseHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void mineBlock(int difficulty)
    {
        if(difficulty>=1) {
            String target = new String(new char[difficulty]).replace('\0', '0');
            System.out.println(target);
            while (!hash.substring(0, difficulty).equals(target)) {
                System.out.println(nonce);
                nonce++;
                hash = calculateHash();

            }
        }
        else
        {
            hash = calculateHash();
        }
        System.out.println("Block mined !!!"+hash);
    }
}
