package com.masoud.springbootjunitmockito.service;

import com.masoud.springbootjunitmockito.dao.UserRepository;
import com.masoud.springbootjunitmockito.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;

    @Test
    public void getUsers() {
       when(repository.findAll()).thenReturn(Stream
               .of(new User(1,"masoud",32,"sainthyacinth,qc")
               ,new User(2,"masoud",31,"sainthyacinth,qc"))
               .collect(Collectors.toList()));
       assertEquals(2,service.getUsers().size());
    }
    @Test
    public void findByAddress() {
        String address ="sainthyacinth";
        when(repository.findByAddress(address)).thenReturn(Stream
                .of(new User(1,"masoud",32,"sainthyacinth,qc"))
                .collect(Collectors.toList()));
        assertEquals(1,service.getUserbyAddress(address).size());
    }

    @Test
    public void saveUser() {
         User user =new User(1,"masoud",32,"sainthyacinth,qc");
        when(repository.save(user)).thenReturn(user);
        assertEquals(user,service.addUser(user));
    }
    @Test
    public void deleteUser() {
        User user =new User(1,"masoud",32,"sainthyacinth,qc");
        service.deleteUser(user);
        verify(repository,times(1)).delete(user);

    }

}