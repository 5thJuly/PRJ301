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
    private String foodId;
    private String foodName;
    private String description;
    private double price;
    private int cookingTime;
    private boolean status;

    public FoodDTO() {
    }

    public FoodDTO(String foodId, String foodName, String description, double price, int cookingTime, boolean status) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.description = description;
        this.price = price;
        this.cookingTime = cookingTime;
        this.status = status;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int quantity) {
        this.cookingTime = cookingTime;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
