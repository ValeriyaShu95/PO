package org.example.models_entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Templates")

public class Templates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTemplate;

    private List<Long> idSize;
    private  List<Long> idMaterials;
    private String nameTemplate;

    public Templates() {
    }

    public Templates(Long idTemplate) {
        this.idTemplate = idTemplate;
    }

    public Templates(List<Long> idSize, List<Long> idMaterials, String nameTemplate) {
        this.idSize = idSize;
        this.idMaterials = idMaterials;
        this.nameTemplate = nameTemplate;
    }

//    public Templates(Long idTemplate, List<Long> idSize, List<Long> idMaterials, String nameTemplate) {
//        this.idTemplate = idTemplate;
//        this.idSize = idSize;
//        this.idMaterials = idMaterials;
//        this.nameTemplate = nameTemplate;
//    }

    public List<Long> getIdSize() {
        return idSize;
    }

    public void setIdSize(List<Long> idSize) {
        this.idSize = idSize;
    }

    public List<Long> getIdMaterials() {
        return idMaterials;
    }

    public void setIdMaterials(List<Long> idMaterials) {
        this.idMaterials = idMaterials;
    }

    public String getNameTemplate() {
        return nameTemplate;
    }

    public void setNameTemplate(String nameTemplate) {
        this.nameTemplate = nameTemplate;
    }

    public Long getIdTemplate() {
        return idTemplate;
    }

    public void setIdTemplate(Long idTemplate) {
        this.idTemplate = idTemplate;
    }
}
