package com.example.mamazonAPI.Service;

import com.example.mamazonAPI.Model.DTO.LoginDTO;
import com.example.mamazonAPI.Model.DTO.UserDTO;
import com.example.mamazonAPI.Model.Entity.User;
import com.example.mamazonAPI.Model.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    // Conversion d'un user en userDTO
    public UserDTO convertToDTO(User user) {
        // Je crée un message de type DTO
        UserDTO userDTO = new UserDTO();

        // J'attribue les valeurs aux propriétés de UserDTO (donc toutes sauf password)
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAge(user.getAge());
        userDTO.setPanier(user.getPanier());

        return userDTO;
    }

    // Conversion d'un userDto en user
    public User convertToUser(UserDTO userDto) {
        // J'instancie un objet de type User auquel j'attribue les valeurs des propriétés de MessageDTO
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(user.getPassword());
        user.setAge(userDto.getAge());
        user.setPanier(userDto.getPanier());

        return user;
    }

    // Je retourne une liste d'utilisateur de type UserDTO
    // 1. Je récupère tous les users
    // 2. Je convertis la liste récupérée en stream
    // 3. Je transforme chaque élément de la liste (chaque user) en le convertissant en UserDTO
    // 4. Je convertis ce résultat en liste
    public List<UserDTO> getAllUsers() {
        return this.repo.findAll().stream().map((user) -> this.convertToDTO(user)).toList();
    }

    public UserDTO getUserById(Long id) {
        // Je stocke dans une variable l'id récupéré d'un user classique
        var result = this.repo.findById(id).get();
        // Je le retourne en le convertissant en userDTO
        return this.convertToDTO(result);
    }

    public UserDTO createUser(UserDTO data) {
        // Je sauvegarde le user converti en user classique
        var result = repo.save(this.convertToUser(data));
        // Puis je le return en le convertissant en UserDTO
        return this.convertToDTO(result);
    }

    public UserDTO updateUser(Long id, UserDTO data) {
        // Je récupère l'id du user que je convertis en userDTO grâce à la fonction convertToDTO()
        UserDTO user = this.convertToDTO(repo.findById(id).get());
        // J'attribue les valeurs aux propriétés de UserDTO
        user.setName(data.getName());
        user.setEmail(data.getEmail());
        user.setAge(data.getAge());
        user.setPanier(data.getPanier());

        return this.createUser(user);
    }

    public void deleteUser(Long id) {
        this.repo.deleteById(id);
    }

    // Retrouver un user pour la connexion
    /* public User findUser(User data) throws Exception {
        return this.getAllUsers()
                .stream()
                .filter(user -> user.getEmail().equals(data.getEmail()) && user.getPassword().equals(data.getPassword()))
                .findFirst()
                .orElseThrow(() -> new Exception("Mauvais utilisateur ou mauvais mot de passe"));
    }
    */
}
