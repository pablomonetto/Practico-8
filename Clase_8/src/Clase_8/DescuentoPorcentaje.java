package Clase_8;

public class DescuentoPorcentaje extends Descuento {
    @Override
    public float valorFinal (float valorInicial){
        return valorInicial - ((valorInicial * this.getDesc())/100);
    }  
}
