/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.food;

/**
 *
 * @author Admin
 */
public class FoodDTO {
    private String id;
    private String name;
    private String desc;
    private float price;
    private int cookingTime;
    private boolean status;

    public FoodDTO(String id, String name, String desc, float price, int cookingTime, boolean status) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.cookingTime = cookingTime;
        this.status = status;
    }

    public FoodDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
