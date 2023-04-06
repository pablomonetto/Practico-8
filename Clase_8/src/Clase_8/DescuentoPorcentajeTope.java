package Clase_8;

public class DescuentoPorcentajeTope extends Descuento {

    @Override
    public float valorFinal(float valorInicial) {
        float desc = (valorInicial * getDesc())/100;
        if(desc < getTope()) return valorInicial - desc;
        else    return valorInicial - getTope();
    }
    
}
