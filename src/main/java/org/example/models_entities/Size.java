package org.example.models_entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Size")

public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSize;

    private String type; // A0?
    private int size;
    private int widh;
    private int length;


    public Size() {
    }

    public Size(String type, int size, int widh, int length){
        this.type = type;
        this.size = size;
        this.widh = widh;
        this.length = length;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
