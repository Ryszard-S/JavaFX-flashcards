package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {
    String[] y;
    private ArrayList Lista = new ArrayList<>();

    public void read() {
        Scanner file = null;
        try {
            file = new Scanner(new File(setGetPath.getPath()),StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        while(file.hasNext()) {
            String x = file.nextLine();
            y = x.split(";");
            String q1 = y[0];
            String q2 = y[1];
            Integer q3 = Integer.parseInt(y[2]);
            Integer q4 = Integer.parseInt(y[3]);
            Lista.add(new Lista_slowek(q1,q2,q3,q4));
    }
        file.close();
        setGetLista l = new setGetLista();
        l.setLista(Lista);
    }
}
