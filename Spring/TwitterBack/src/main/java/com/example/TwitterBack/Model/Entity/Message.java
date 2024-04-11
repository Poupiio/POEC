package com.example.TwitterBack.Model.Entity;

import jakarta.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String message;

    // Un utilisateur peut envoyer plusieurs messages
    @ManyToOne
    @JoinColumn(name="sender_id")
    private User sender;

    // Plusieurs messages peuvent correspondre à un seul utilisateur
    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User receiver;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

}
