/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.utils;

/**
 *
 * @author Admin
 */
public class ClothesDTO {
    private String id;
    private String name;
    private String description;
    private Float price;
    private String size;
    private boolean status;

    public ClothesDTO() {
    }

    public ClothesDTO(String id, String name, String description, Float price, String size, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
    
}
