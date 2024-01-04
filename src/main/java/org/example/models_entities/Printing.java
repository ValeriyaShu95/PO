package org.example.models_entities;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity

@Table(name = "Printing")

public class Printing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrinting;

    private BigDecimal printingPrice;
    private long idSize;

    public Printing() {
    }

    public Printing(BigDecimal printingPrice, long idSize) {
        this.printingPrice = printingPrice;
        this.idSize = idSize;
    }

    public BigDecimal getPrintingPrice() {
        return printingPrice;
    }

    public void setPrintingPrice(BigDecimal printingPrice) {
        this.printingPrice = printingPrice;
    }

    public long getIdSize() {
        return idSize;
    }

    public void setIdSize(long idSize) {
        this.idSize = idSize;
    }


    public Long getIdPrinting() {
        return idPrinting;
    }

    public void setIdPrinting(Long idPrinting) {
        this.idPrinting = idPrinting;
    }
}
