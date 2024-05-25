package su.intercraft;

import java.io.*;

public class Reader extends Thread {
    Contanier contanier;
    File file;

    Reader(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file))) {
            byte[] bytes = new byte[4];
            stream.read(bytes);
            int byteSize = ((bytes[0] & 0xFF) << 24) + ((bytes[1] & 0xFF) << 16) + ((bytes[2] & 0xFF) << 8) + (bytes[3] & 0xFF);
            //System.out.println(byteSize + " " + file.getName());
            byte[] pngBytes = new byte[byteSize];
            stream.read(pngBytes);
            int count1 = 0;
            for (int i = 0; i < pngBytes.length; i++) {
                count1 += Integer.bitCount(pngBytes[i]);
            }
            int realParity = count1%2;
            //System.out.println(count1);

            stream.read(bytes);
            int parity = ((bytes[0] & 0xFF) << 24) + ((bytes[1] & 0xFF) << 16) + ((bytes[2] & 0xFF) << 8) + (bytes[3] & 0xFF);

            if (parity!=realParity) throw new ParityException();

            stream.read(bytes);
            int number = ((bytes[0] & 0xFF) << 24) + ((bytes[1] & 0xFF) << 16) + ((bytes[2] & 0xFF) << 8) + (bytes[3] & 0xFF);

            this.contanier = new Contanier(byteSize, pngBytes, parity, number);
            Writer.addMap(contanier);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParityException e) {
            e.printStackTrace();
        }
    }
}
