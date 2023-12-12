package org.example.models_entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity

@Table(name = "Materials")

public class Materials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMaterial;

    private String nameMaterial;    // бумага, картон и тд
    private int sizeMaterial;           // размер
    private BigDecimal priceMaterial; // цена материала

    public Materials() {
    }

    public Materials(String nameMaterial, int sizeMaterial, BigDecimal priceMaterial) {
        this.nameMaterial = nameMaterial;
        this.sizeMaterial = sizeMaterial;
        this.priceMaterial = priceMaterial;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    public int getSizeMaterial() {
        return sizeMaterial;
    }

    public void setSizeMaterial(int sizeMaterial) {
        this.sizeMaterial = sizeMaterial;
    }

    public BigDecimal getPriceMaterial() {
        return priceMaterial;
    }

    public void setPriceMaterial(BigDecimal priceMaterial) {
        this.priceMaterial = priceMaterial;
    }
}
