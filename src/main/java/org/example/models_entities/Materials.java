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
    private int idSizeMaterial;           // размер
    private BigDecimal priceMaterial; // цена материала

    public Materials() {
    }

    public Materials(String nameMaterial, int idSizeMaterial, BigDecimal priceMaterial) {
        this.nameMaterial = nameMaterial;
        this.idSizeMaterial = idSizeMaterial;
        this.priceMaterial = priceMaterial;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    public int getIdSizeMaterial() {
        return idSizeMaterial;
    }

    public void setSizeMaterial(int idSizeMaterial) {
        this.idSizeMaterial = idSizeMaterial;
    }

    public BigDecimal getPriceMaterial() {
        return priceMaterial;
    }

    public void setPriceMaterial(BigDecimal priceMaterial) {
        this.priceMaterial = priceMaterial;
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }
}
