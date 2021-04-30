package com.dani.monkeyd.app.appingen.models;

import javax.persistence.*;

@Entity
@Table
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idImage;
    private Long idUser;
    private String name;
    private String postComment;

    public Comments() {
        super();
    }

    public Comments(Long idComment, Long idUser, String name, String postComment) {
        this.idImage = idComment;
        this.idUser = idUser;
        this.name = name;
        this.postComment = postComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdImage() {
        return idImage;
    }

    public void setIdImage(Long idImage) {
        this.idImage = idImage;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostComment() {
        return postComment;
    }

    public void setPostComment(String postComment) {
        this.postComment = postComment;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", idComment=" + idImage +
                ", idUser=" + idUser +
                ", name='" + name + '\'' +
                ", postComment='" + postComment + '\'' +
                '}';
    }
}
