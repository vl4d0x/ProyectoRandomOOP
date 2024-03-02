package net.camionesdonerik;

import java.util.Scanner;
import net.camionesdonerik.model.Autobus;
import net.camionesdonerik.model.Pasajero;
import net.camionesdonerik.util.AutobusListWithArray;
import net.camionesdonerik.util.PasajerosListWithArray;

public class Menu {

    final private int REGISTRO_AUTOBUS = 1;
    final private int MODIFICAR_PRECIO_AUTOBUS = 2;
    final private int CONSULTA_DE_AUTOBUSES = 3;
    final private int REGISTRO_DE_VENTA_BOLETO = 4;
    final private int CONSULTA_NUM_AUTOBUS = 5;
    AutobusListWithArray autobusArray;
    PasajerosListWithArray pasajerosMatrix;
    Scanner consola = new Scanner(System.in);

    public Menu(AutobusListWithArray autobusArray, PasajerosListWithArray pasajerosMatrix) {
        this.autobusArray = autobusArray;
        this.pasajerosMatrix = pasajerosMatrix;
    }

    public void desplegarMenu() {
        boolean salir = false;
        while (!salir) {
            printMenu();
            int option = consola.nextInt();
            switch (option) {
                case REGISTRO_AUTOBUS:
                    clearScrean();
                    registroAutobus();
                    break;
                case MODIFICAR_PRECIO_AUTOBUS:
                    clearScrean();
                    modificarPrecio();
                    break;
                case CONSULTA_DE_AUTOBUSES:
                    clearScrean();
                    imprimirAutobuses();
                    break;
                case REGISTRO_DE_VENTA_BOLETO:
                    clearScrean();
                    ventaBoleto();
                    break;
                case CONSULTA_NUM_AUTOBUS:
                    clearScrean();
                    consultaPorAutobus();
                    break;
                case 6:
                    salir = true;
                    System.out.println("Gracias por usar >:)");
                    break;
            }

        }

    }

    private void printMenu() {
        System.out.println("---- CAMIONES DON ERIK ----");
        System.out.println("   _____________\n"
                + " _/_|[][][][][] | - -\n"
                + "(    Don Erik   | - -\n"
                + "=--OO-------OO--=dwb \n");
        System.out.println("~~~ SELECCIONA UNA OPCION ~~~ ");
        System.out.println("1 -> Registro de autobus");
        System.out.println("2 -> Modificaciones de precio por autobus");
        System.out.println("3 -> Consulta de autobuses");
        System.out.println("4 -> Registro de venta de boleto");
        System.out.println("5 -> Consulta por numero de autobus");
        System.out.println("6 -> Cerrar aplicacion");
    }

    public void registroAutobus() {
        Autobus autobus = new Autobus();
        System.out.println("\n \n **** REGISTRO DE AUTOBUSES ****");

        System.out.print("Ingrese la linea del autobus: ");
        autobus.setLinea(consola.nextLine());
        System.out.println("");
        autobus.setLinea(consola.nextLine());
        System.out.println("");

        System.out.println("Ingrese el origen del autobus: ");
        autobus.setOrigen(consola.nextLine());

        System.out.println("Ingrese el destino del autobus: ");
        autobus.setDestino(consola.nextLine());

        boolean precioIncorrecto = true;

        do {
            System.out.println("Ingrese el precio de un boleto de autobus: $");
            double precio = consola.nextDouble();
            autobus.setPrecio(precio);
            precioIncorrecto = (precio <= 0);
        } while (precioIncorrecto);

        System.out.println("Ingrese el numero de asientos del autobus: ");
        autobus.setNumAsientos(consola.nextInt());

        System.out.println("Ingrese la hora de salida: ");
        autobus.setHoraSalida(consola.nextLine());
        autobus.setHoraSalida(consola.nextLine());

        System.out.println("Ingrese la fecha de salida: ");
        autobus.setFecha(consola.nextLine());

        autobusArray.addElement(autobus);
        pasajerosMatrix.addElement(autobus.getNumAutobus(), autobus.getNumAsientos(), null);

        System.out.println("¡Tu autbous fue agregado exitosamente!");
        System.out.println("Numero de autobus: " + autobus.getNumAutobus());

    }

    public void modificarPrecio() {
        System.out.println("$$$$ Modificaciones de precio por autobus $$$$");
        System.out.println("Ingresa el autobus al que desees modificar el precio:");
        int numAutobus = consola.nextInt();
        System.out.println("Ingresa la cantidad a la que deseas cambiar el precio:");
        int nuevoPrecio = consola.nextInt();
        try {
            autobusArray.getArray()[numAutobus].setPrecio(nuevoPrecio);
            System.out.println("\n Precio del autobus " + numAutobus + " cambiado exitosamente! \n");
        } catch (Exception e) {
            System.out.println("\n ERROR! El autobus no existe. \n");
        }

    }

    public void imprimirAutobuses() {
        System.out.println(" #### Consulta de autobuses #### \n");
        String format = "%-15s%-30s%-45s%-60s%-75s%-90s%n";
        System.out.printf(format, "NumAutobus", "Origen", "Destino", "Fecha", "Hora", "Precio");
        for (int i = 0; i < autobusArray.getArray().length; i++) {
            System.out.printf(format, autobusArray.getArray()[i].getNumAutobus(),
                    autobusArray.getArray()[i].getOrigen(),
                    autobusArray.getArray()[i].getDestino(),
                    autobusArray.getArray()[i].getFecha(),
                    autobusArray.getArray()[i].getHoraSalida(),
                    "$" + Double.toString(autobusArray.getArray()[i].getPrecio()));
        }
    }

    public void ventaBoleto() {
        System.out.println("$$$$ Registro de venta de boleto $$$$");
        Pasajero pasajero = new Pasajero();
        System.out.println("Autobuses disponibles:");
        for (int i = 0; i < pasajerosMatrix.getMatrix().length; i++) {
            System.out.println("Autobus num " + i);
        }
        System.out.println("Selecciona el numero del autobus:");
        int autobusRow = consola.nextInt();

        System.out.println("Asientos disponibles del autobus num " + autobusRow);
        for (int i = 0; i < autobusArray.getArray()[autobusRow].getNumAsientos(); i++) {
            if (pasajerosMatrix.getMatrix()[autobusRow][i] == null) {
                System.out.println("Asiento " + i);
            }
        }
        System.out.println("Selecciona el asiento:");
        pasajero.setNumAsiento(consola.nextInt());

        System.out.println("Ingresa el nombre del pasajero:");
        pasajero.setNombre(consola.nextLine());
        pasajero.setNombre(consola.nextLine());

        System.out.println("Ingresa el primer apellido del pasajero:");
        pasajero.setPap(consola.nextLine());

        System.out.println("Ingresa el segundo apellido del pasajero");
        pasajero.setSap(consola.nextLine());

        pasajero.setBoleto("" + autobusRow + "-" + pasajero.getNumAsiento());

        pasajerosMatrix.getMatrix()[autobusRow][pasajero.getNumAsiento()] = pasajero;

        System.out.println("Su compra de boleto ha sido exitosa!");
        System.out.println("Numero de boleto:" + pasajero.getBoleto());
    }

    public void consultaPorAutobus() {
        System.out.println(" #### Consulta por numero de autobus #### \n");
        System.out.println("Ingresa el autobus del que quieres recibir informacion:");
        int autobus = consola.nextInt();
        String format = "%-20s%-30s%-40s%-50s%-60s%n";
        System.out.printf(format, "numAsiento", "Nombre", "Primer Apellido", "Segundo Apellido", "Boleto");
        for (int i = 0; i < pasajerosMatrix.getMatrix()[autobus].length; i++) {
            if (pasajerosMatrix.getMatrix()[autobus][i] != null) {
                System.out.printf(format, pasajerosMatrix.getMatrix()[autobus][i].getNumAsiento(),
                        pasajerosMatrix.getMatrix()[autobus][i].getNombre(),
                        pasajerosMatrix.getMatrix()[autobus][i].getPap(),
                        pasajerosMatrix.getMatrix()[autobus][i].getSap(),
                        pasajerosMatrix.getMatrix()[autobus][i].getBoleto());
            }

        }
    }

    public void clearScrean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
