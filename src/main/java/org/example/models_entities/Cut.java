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
    private long sizeFrom; // от А0 до А10
    private long sizeTo; // от А10 до А0

    public Cut() {
    }

    public Cut(BigDecimal cutPrice, int amountCut, long sizeFrom, long sizeTo) {
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

    public long getSizeFrom() {
        return sizeFrom;
    }

    public void setSizeFrom(long sizeFrom) {
        this.sizeFrom = sizeFrom;
    }

    public long getSizeTo() {
        return sizeTo;
    }

    public void setSizeTo(long sizeTo) {
        this.sizeTo = sizeTo;
    }

    public Long getIdCut() {
        return idCut;
    }

    public void setIdCut(Long idCut) {
        this.idCut = idCut;
    }
}
