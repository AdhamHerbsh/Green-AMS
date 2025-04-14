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
public class OrderItem extends Order {
    
    private int id;
    private int order_id;
    private int sample_item_id;
    private int order_number;

    public OrderItem() {
    
    }

    public OrderItem(int id, int order_id, int sample_item_id, int order_number) {
        this.id = id;
        this.order_id = order_id;
        this.sample_item_id = sample_item_id;
        this.order_number = order_number;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getSample_item_id() {
        return sample_item_id;
    }

    public void setSample_item_id(int sample_item_id) {
        this.sample_item_id = sample_item_id;
    }
}
