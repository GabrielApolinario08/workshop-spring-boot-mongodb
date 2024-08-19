package com.coursejava.spring_mongo.services;

import com.coursejava.spring_mongo.domain.User;
import com.coursejava.spring_mongo.dto.UserDTO;
import com.coursejava.spring_mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<User> findAll() {
        return repository.findAll();
    }
    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
