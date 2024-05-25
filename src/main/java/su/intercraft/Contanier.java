package su.intercraft;

public class Contanier {
    private int byteSize;
    private byte[] png;
    private int parity;
    private int number;

    public Contanier(int byteSize, byte[] png, int parity, int number) {
        this.byteSize = byteSize;
        this.png = png;
        this.parity = parity;
        this.number = number;
    }

    public int getByteSize() {
        return byteSize;
    }

    public void setByteSize(int byteSize) {
        this.byteSize = byteSize;
    }

    public byte[] getPng() {
        return png;
    }

    public void setPng(byte[] png) {
        this.png = png;
    }

    public int getParity() {
        return parity;
    }

    public void setParity(int parity) {
        this.parity = parity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
