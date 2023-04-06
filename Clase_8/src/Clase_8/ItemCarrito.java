package Clase_8;

public class ItemCarrito {
    
    private int orden;
    private int cantidad;
    private int item;

    public ItemCarrito(int orden, int item, int cantidad) {
        this.orden = orden;
        this.item = item;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public void MostrarCarrito() {
        System.out.println( "Codigo de producto: " + getItem() + " - Cantidad: : " + getCantidad());
    }
}