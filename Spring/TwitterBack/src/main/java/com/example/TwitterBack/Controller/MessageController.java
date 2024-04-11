package com.example.TwitterBack.Controller;

import com.example.TwitterBack.Model.DTO.MessageDTO;
import com.example.TwitterBack.Model.Entity.Message;
import com.example.TwitterBack.Model.Entity.User;
import com.example.TwitterBack.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService service;

    @GetMapping
    // On récupère les messages sous forme de MessageDTO
    public List<MessageDTO> getAllMessages() {
        return this.service.getAllMessages();
    }

    @GetMapping("/{id}")
    public MessageDTO getMessageById(@PathVariable Long id) {
        return this.service.getMessageById(id);
    }

    @PostMapping
    public MessageDTO createMessage(@RequestBody MessageDTO data) {
        return this.service.createMessage(data);
    }

    @PutMapping("/{id}")
    public MessageDTO updateMessage(@RequestBody MessageDTO body, @PathVariable Long id) {
        return this.service.updateMessage(id, body);
    }

    @DeleteMapping("/{id}")
    public String removeMessage(@PathVariable Long id) {
        return this.service.removeMessage(id);
    }
}
