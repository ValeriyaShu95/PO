package org.example.models_entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Size")

public class Size {
    @Id
    private Long idSize;

    private String type; // A0?

    private int widh;
    private int length;


    public Size() {
    }

    public Size(String type, long idSize, int widh, int length){
        this.type = type;
        this.idSize = idSize;
        this.widh = widh;
        this.length = length;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getIdSize() {
        return idSize;
    }

    public void setIdSize(Long idSize) {
        this.idSize = idSize;
    }

    public int getWidh() {
        return widh;
    }

    public void setWidh(int widh) {
        this.widh = widh;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
