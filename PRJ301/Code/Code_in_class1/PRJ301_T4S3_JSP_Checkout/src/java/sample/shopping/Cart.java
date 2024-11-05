/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.shopping;

import java.util.HashMap;
import java.util.Map;


public class Cart {
    private Map<String, Cosmetics> cart;
    
    public Cart(){       
    }

    public Cart(Map<String, Cosmetics> cart) {
        this.cart = cart;
    }

    public Map<String, Cosmetics> getCart() {
        return cart;
    }

    public void setCart(Map<String, Cosmetics> cart) {
        this.cart = cart;
    }

    public boolean add(String id, Cosmetics cosmetics) {
        boolean check = false;
        try {
            if(this.cart == null){
                this.cart = new HashMap<>();
            }
            if(this.cart.containsKey(id)){
                int currentQuantity = this.cart.get(id).getQuantity();
                cosmetics.setQuantity(currentQuantity + cosmetics.getQuantity());
            }
            this.cart.put(id, cosmetics);
            check = true;
        }
        catch (Exception e){}
        return check;
    }

    public boolean remove(String id) {
        boolean check = false;
        try {
            if(this.cart != null){
                if(this.cart.containsKey(id)){
                    this.cart.remove(id);
                    check = true;
                }
            }
        }
        catch (Exception e){}
        return check;
    }
    
    public boolean edit(String id, Cosmetics cosmetics) {
        boolean check = false;
        try {
            if(this.cart != null){
                if(this.cart.containsKey(id)){
                    this.cart.replace(id, cosmetics);
                    check = true;
                }
            }
        }
        catch (Exception e){}
        return check;
    }
            
}
