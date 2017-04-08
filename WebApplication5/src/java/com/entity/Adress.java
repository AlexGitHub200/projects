/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author alex
 */
@Entity
public class Adress {
    
    String street;
    
    @Id
    String typeOfAdress;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTypeOfAdress() {
        return typeOfAdress;
    }

    public void setTypeOfAdress(String typeOfAdress) {
        this.typeOfAdress = typeOfAdress;
    }
    
}
