/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author joab
 */
public class Carrito {
    private Item item;
    private int cantidad;

    public Carrito(){}
    
    public Carrito(Item item, int cantidad) {
        this.item = item;
        this.cantidad = cantidad;
    }

    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    
}
