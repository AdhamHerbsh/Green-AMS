/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.models;

/**
 *
 * @author Adham
 */
public class SampleItem extends Sample {
    private int item_id;
    private int quantity;

    public SampleItem() {
        super();
    }
      
    public SampleItem(int id, int quantity) {
        super();
        this.item_id = id;
        this.quantity = quantity;
    }
    
    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
