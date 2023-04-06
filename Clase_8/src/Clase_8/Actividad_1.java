package Clase_8;

import java.io.IOException;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actividad_1 {

    public static void main(String[] args) {

        Producto produ;
        ItemCarrito ICarr;
        Carrito carri;

        List<Producto> PLista = new ArrayList<>();
        ArrayList<ItemCarrito> ICLista = new ArrayList<>();
        ArrayList<Carrito> CLista = new ArrayList<>();

        float PrecioTotal;
        String d;

        String ArchEntrada = "C:\\Users\\pablo\\OneDrive\\Documentos\\JAVA\\Clase 8\\clase_8\\Entrada2.csv";

////////////LECTURA DE LISTA DE PRODUCTOS + ARMADO DEL LISTADO DE PRODUCTOS/////        
        try {
            for (String lectura : Files.readAllLines(Paths.get(ArchEntrada))) {
                String Listado[] = lectura.split(";");
                produ = new Producto(Integer.parseInt(Listado[0]),
                        Listado[1], Listado[2], Float.parseFloat(Listado[3]));
                PLista.add(produ);
            }
        } catch (IOException ex) {
            System.out.println("\nNo se pieron leer los productos.");
        }

///////////////////Mostrar productos en lista///////////////////////////////////
//        for (Producto p : PLista) {
//            System.out.println("Codigo: " + p.getCodigoProd() + " Nombre: "
//                    + p.getNombre() + " \t\tDescripcion: " + p.getDescripcion()
//                    + " Precio: " + p.getPrecio());
//        }
//////////////////ARMO EL CARRITO DE COMPRAS CON LOS CODIGOS Y CANTIDAD//////////
        Scanner entrada = new Scanner(System.in);
        int e, c, x = 0;

        while (TRUE) {

            System.out.println("Ingrese codigo de nuevo item (ingrese 0 para salir):");
            e = entrada.nextInt();

            if (e == 0) {
                break;
            }

            System.out.println("Ingrese cantidad del item anterior:");
            c = entrada.nextInt();

            ICarr = new ItemCarrito(x + 1, e, c);
            ICLista.add(ICarr);
            x++;
        }

///////////////////Mostrar ItemCarrito/////////////////////////////////////////
//       for (ItemCarrito ic : ICLista) {
//            System.out.println("No.: " + ic.getOrden() +
//                    " Item: " + ic.getItem() + 
//                    " Cantidad: " + ic.getCantidad());
//        }
///////////Creo la lista de compras - CARRITO/////////////////////////////////
        Producto pID;
        for (ItemCarrito ic : ICLista) {
            for (int z = 0; z < PLista.size(); z++) {
                pID = PLista.get(z);
                if (ic.getItem() == pID.getCodigoProd()) {
                    carri = new Carrito(ic.getOrden(),
                            pID.getCodigoProd(), pID.getNombre(),
                            pID.getDescripcion(),
                            ic.getCantidad(), pID.getPrecio());
                    CLista.add(carri);
                }
            }
        }

////////////////////////Mostrar Carrito/////////////////////////////////////////
//        for (Carrito cc : CLista) {
//            System.out.println("Item: " + cc.getOrden() + " - Codigo: "
//                    + cc.getID() + " - Nombre: \"" + cc.getNombre()
//                    + "\" - Descr.: " + cc.getDescripcion()
//                    + " - Cantidad: " + cc.getCantidad() + " - Precio: $"
//                    + cc.getPrecio() + " - Fecha de carga: "
//                    + cc.getFechaOperacion());
//            PrecioTotal = PrecioTotal + cc.getPrecio();
//        }
        carri = new Carrito();
        PrecioTotal = carri.mostrarCarro(CLista);

        System.out.println("\nPrecio total sin descuento: $" + PrecioTotal);

        Excepcion ex = new Excepcion();
        boolean DescuentoAprobado = FALSE;

        try {
            DescuentoAprobado = ex.exc1(PrecioTotal);
        } catch (Excepcion ex1) {
            Logger.getLogger(Actividad_1.class.getName()).log(Level.SEVERE, "No se puede aplicar descuento a precio total 0", ex1);
            //System.out.println("No se puede aplicar descuento a precio total 0");
        }

////////////////////////////Calculo del tipo de descuento//////////////////////        
        if (DescuentoAprobado) {
            System.out.println("\nIngrese tipo de descuento (f)fijo, (p)porcentual o con (t)tope:");

            Scanner entrada2 = new Scanner(System.in);
            d = entrada2.nextLine();

            switch (d) {
                case "f" -> {
                    Descuento desc1 = new DescuentoFijo();
                    float descFijo = 50;
                    desc1.setDesc(descFijo);
                    desc1.setItems(CLista.size());
                    System.out.println("Precio con descuento fijo: $"
                            + desc1.valorFinal(PrecioTotal));
                }

                case "p" -> {
                    float descPor = 15;
                    Descuento desc2 = new DescuentoPorcentaje();
                    desc2.setDesc(descPor);
                    System.out.println("Precio con descuento de " + descPor
                            + "%: $" + desc2.valorFinal(PrecioTotal));
                }

                case "t" -> {
                    float descPorTop = 20;
                    float Tope = 1000;
                    Descuento desc3 = new DescuentoPorcentajeTope();
                    desc3.setDesc(descPorTop);
                    desc3.setTope(Tope);
                    System.out.println("Precio con descuento de " + descPorTop
                            + "% con tope: $"
                            + desc3.valorFinal(PrecioTotal));
                }

                default ->
                    System.out.println("No se realizo ningun descuento: Precio final: $"
                            + PrecioTotal);
            }
        }
    }
}
