/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.shopping;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Cart {
    private Map<String, Comestic> cart;

    public Cart() {
    }

    public Cart(Map<String, Comestic> cart) {
        this.cart = cart;
    }
    public Map<String, Comestic> getCart() {
        return cart;
    }
    public void setCart(Map<String, Comestic> cart) {
        this.cart = cart;
    }
    
    


    public boolean add(String id, Comestic c) {
        boolean check = false;
        try {
            if(this.cart == null) {
                this.cart = new HashMap<>();
            }
            if(this.cart.containsKey(id)) {
                int currentQuantity = this.cart.get(id).getQuantity();
                c.setQuantity(currentQuantity + c.getQuantity());
            }
            this.cart.put(id,c);
            check = true;
        } catch (Exception e) {
            
        }
        return check;
    }
    
        
    public boolean remove(String id) {
        boolean check = false;
        
        try {
            if(this.cart != null) {
                if(this.cart.containsKey(id)) {
                    this.cart.remove(id);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }
    public boolean edit(String id, Comestic t) {
        boolean check = false;
        
        try {
            if(this.cart != null) {
                if(this.cart.containsKey(id)) {
                    this.cart.replace(id, t);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }
    
}
