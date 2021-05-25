package sample;

import java.util.ArrayList;

public class setGetLista {
    private static ArrayList<Lista_slowek>Lista;
    public static ArrayList getLista() {
        return Lista;
    }

    public void setLista(ArrayList Lista) {
        this.Lista = Lista;
    }
}
