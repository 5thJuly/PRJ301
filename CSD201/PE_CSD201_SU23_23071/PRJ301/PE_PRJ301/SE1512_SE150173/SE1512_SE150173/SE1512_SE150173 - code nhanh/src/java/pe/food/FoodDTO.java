/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.food;

/**
 *
 * @author Hoa Doan
 */
public class FoodDTO {
    private String id;
    private String name;
    private String desc;
    private float price;
    private int cookTime;
    private boolean status;

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

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public FoodDTO(String id, String name, String desc, float price, int cookTime, boolean status) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.cookTime = cookTime;
        this.status = status;
    }

    public FoodDTO() {
    }

    @Override
    public String toString() {
        return "FoodDTO{" + "id=" + id + ", name=" + name + ", desc=" + desc + ", price=" + price + ", cookTime=" + cookTime + ", status=" + status + '}';
    }
    
}
