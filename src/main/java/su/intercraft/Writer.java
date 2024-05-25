package su.intercraft;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Writer {
    private static final File png = new File("v17.png");
    private static Map<Integer, byte[]> pngs = new HashMap<>();
    public static void addMap(Contanier contanier){
        synchronized (png){
            pngs.put(contanier.getNumber(), contanier.getPng());
        }
    }
    public static void writePng(){
        try(BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(png))) {
            for (int i = 0; i < pngs.entrySet().size(); i++) {
                writer.write(pngs.get(i));
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
