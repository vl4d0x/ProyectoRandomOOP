package net.camionesdonerik;

import net.camionesdonerik.util.AutobusListWithArray;
import net.camionesdonerik.util.PasajerosListWithArray;

public class MainProgram {

    public static void main(String[] args) {
        AutobusListWithArray autobusesArray = new AutobusListWithArray();
        PasajerosListWithArray pasajerosMatrix = new PasajerosListWithArray();
        Menu menu = new Menu(autobusesArray, pasajerosMatrix);
        menu.desplegarMenu();
    }
}
