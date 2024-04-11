package com.example.TwitterBack.Model.DTO;

import com.example.TwitterBack.Model.Entity.Message;
import com.example.TwitterBack.Model.Entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MessageDTO {

    private Long id;
    private String message;
    private Long senderId;
    private Long receiverId;

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

    public Long getSenderId() {
        return senderId;
    }
    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }
    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

}
