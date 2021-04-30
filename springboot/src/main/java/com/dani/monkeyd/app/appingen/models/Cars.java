package com.dani.monkeyd.app.appingen.models;

import javax.persistence.*;


@Entity
@Table
public class Cars {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String textHead;
    private String image;
    private Long idComment;

    public Cars() {
        super();
    }

    public Cars(String textHead, String image, Long idComment) {
        this.textHead = textHead;
        this.image = image;
        this.idComment = idComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextHead() {
        return textHead;
    }

    public void setTextHead(String textHead) {
        this.textHead = textHead;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", textHead='" + textHead + '\'' +
                ", image=" + image +
                ", idComment=" + idComment +
                '}';
    }
}
