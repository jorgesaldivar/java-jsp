package data;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joab
 */
public class Item {
    private String name,description;
    private int idItem, quantity, price, category;

    public Item() {
    }

    public Item(String name, String description, int idItem, int quantity, int price, int category) {
        this.name = name;
        this.description = description;
        this.idItem = idItem;
        this.quantity = quantity;
        this.price = price;
        this.category=category;
    }

    public int getcategory() {
        return category;
    }

    public void setcategory(int category) {
        this.category = category;
    }
    
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
