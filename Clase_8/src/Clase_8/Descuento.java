package Clase_8;

public abstract class Descuento {

    private float valor;
    private float tope;
    private int items;

    public abstract float valorFinal (float valorInicial);
    
    public float getDesc() {
        return valor;
    }

    public void setDesc(float valor) {
        this.valor = valor;
    }    

    public float getTope() {
        return tope;
    }

    public void setTope(float tope) {
        this.tope = tope;
    }

    public float getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }
    
    
    
}


