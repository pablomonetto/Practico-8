package Clase_8;

//import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Excepcion extends Exception {

    public boolean exc1(float precio) throws Excepcion {
        if (precio == 0) {
            throw new Excepcion();
        } else {
            return TRUE;
        }
    }

    public float exc2(float descFijo) throws Excepcion {
        if (descFijo < 0) {
            throw new Excepcion();
        } else {
            return descFijo;
        }
    }

}
