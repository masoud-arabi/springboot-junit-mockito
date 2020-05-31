package com.masoud.springbootjunitmockito.service;

import com.masoud.springbootjunitmockito.dao.UserRepository;
import com.masoud.springbootjunitmockito.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class UserService {

        @Autowired
        private UserRepository repository;


        public User addUser(User user) {
            return repository.save(user);
        }

        public List<User> getUsers() {
            List<User> users = repository.findAll();
            System.out.println("Getting data from DB : " + users);
            return users;
        }

        public List<User> getUserbyAddress(String address) {
            return repository.findByAddress(address);
        }

        public void deleteUser(User user) {
            repository.delete(user);
        }
}
