package org.example.models_entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity

@Table(name = "Cut")
public class Cut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCut;

    private BigDecimal cutPrice;
    private int amountCut;
    private int sizeFrom; // от А0 до А10
    private int sizeTo; // от А10 до А0

    public Cut() {
    }

    public Cut(BigDecimal cutPrice, int amountCut, int sizeFrom, int sizeTo) {
        this.cutPrice = cutPrice;
        this.amountCut = amountCut;
        this.sizeFrom = sizeFrom;
        this.sizeTo = sizeTo;
    }

    public BigDecimal getCutPrice() {
        return cutPrice;
    }

    public void setCutPrice(BigDecimal cutPrice) {
        this.cutPrice = cutPrice;
    }

    public int getAmountCut() {
        return amountCut;
    }

    public void setAmountCut(int amountCut) {
        this.amountCut = amountCut;
    }

    public int getSizeFrom() {
        return sizeFrom;
    }

    public void setSizeFrom(int sizeFrom) {
        this.sizeFrom = sizeFrom;
    }

    public int getSizeTo() {
        return sizeTo;
    }

    public void setSizeTo(int sizeTo) {
        this.sizeTo = sizeTo;
    }
}
