package com.company.solidusEx1.domain;

import javax.persistence.*;

@Table(name = "MESSAGE")
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private Long id;

    @Column(name = "MESSAGE_TEXT")
    private String message;

    @Column(name = "HASH")
    private String hash256;

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHash256() {
        return hash256;
    }

    public void setHash256(String hash256) {
        this.hash256 = hash256;
    }
}
