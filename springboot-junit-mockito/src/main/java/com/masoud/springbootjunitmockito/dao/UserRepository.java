package com.masoud.springbootjunitmockito.dao;

import com.masoud.springbootjunitmockito.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,Integer> {
List<User> findByAddress(String address);
}
