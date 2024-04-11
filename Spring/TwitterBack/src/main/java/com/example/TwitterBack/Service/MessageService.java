package com.example.TwitterBack.Service;

import com.example.TwitterBack.Model.DTO.MessageDTO;
import com.example.TwitterBack.Model.Entity.Message;
import com.example.TwitterBack.Model.Entity.User;
import com.example.TwitterBack.Model.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private MessageRepository repo;
    @Autowired
    private UserService userService;

    @Autowired
    public MessageService(MessageRepository repo) {
        this.repo = repo;
    }

    public List<MessageDTO> getAllMessages() {
        return this.repo.findAll().stream().map((val) -> this.convertToDTO(val)).toList();
    }

    public MessageDTO getMessageById(Long id) {
        var result = this.repo.findById(id).get();
        return this.convertToDTO(result);
    }

    public MessageDTO createMessage(MessageDTO data) {
        var result = repo.save(this.convertToMessage(data));
        return this.convertToDTO(result);
    }

    public MessageDTO updateMessage(Long id, MessageDTO data) {
        // Je récupère l'id du message que je convertis en messageDTO grâce à la fonction convertToDTO()
        MessageDTO msg = this.convertToDTO(repo.findById(id).get());
        // J'attribue les valeurs aux propriétés de MessageDTO
        msg.setMessage(data.getMessage());
        msg.setReceiverId(data.getReceiverId());
        msg.setSenderId(data.getSenderId());

        return this.createMessage(msg);
    }

    public String removeMessage(Long id) {
        this.repo.deleteById(id);
        return "L'utilisateur avec l'id " + id + " a bien été supprimé";
    }

    public MessageDTO convertToDTO(Message msg) {
        // Je crée un message de type DTO
        MessageDTO msgDTO = new MessageDTO();

        // J'attribue les valeurs aux propriétés de MessageDTO
        msgDTO.setMessage(msg.getMessage());
        msgDTO.setId(msg.getId());
        // On va chercher à l'intérieur du message le receiver et on récupère son id
        msgDTO.setReceiverId(msg.getReceiver().getId());
        // On va chercher à l'intérieur du message le sender et on récupère son id
        msgDTO.setSenderId(msg.getSender().getId());

        return msgDTO;
    }

    public Message convertToMessage(MessageDTO msgDto) {
        // J'instancie un objet de type Message auquel j'attribue les valeurs des propriétés de MessageDTO
        Message msg = new Message();
        msg.setMessage(msgDto.getMessage());
        msg.setId(msgDto.getId());

        // On récupère via le UserService l'id du user, en récupérant l'id du receiver et du sender
        // Rappel : .get() sert lorsqu'on a un Optional
        msg.setReceiver(userService.getUserById(msgDto.getReceiverId()).get());
        msg.setSender(userService.getUserById(msgDto.getSenderId()).get());

        return msg;
    }

    // Récupérer tous les messages envoyés et reçus par un utilisateur
    /* public List<MessageDTO> getAllMessagesFromOneUser(Long id, Message msg) {
        // Je récupère l'id du message que je convertis en messageDTO grâce à la fonction convertToDTO()
        MessageDTO msgDto = this.convertToDTO(repo.findById(id).get());

    }
    */

}
