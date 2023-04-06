package Clase_8;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DescuentoFijo extends Descuento {
    
    @Override 
    public float valorFinal (float valorInicial) {
        float descParcial_A, descParcial_2;   
        Excepcion ex2 = new Excepcion();
        
        descParcial_A = (valorInicial * this.getItems()) - this.getDesc();
        try {
            descParcial_2 = ex2.exc2(descParcial_A);
        } catch (Excepcion ex) {
            Logger.getLogger(DescuentoFijo.class.getName()).log(Level.SEVERE, "Descuento no puede ser menor a 0", ex);
            descParcial_2 = 0;
        }
            return descParcial_2;
    }
           
}
