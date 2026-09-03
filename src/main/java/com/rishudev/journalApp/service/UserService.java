package com.rishudev.journalApp.service;

import com.rishudev.journalApp.entity.users;
import com.rishudev.journalApp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    public void saveEntry(users users){
        usersRepository.save(users);
    }

    public List<users> getAll(){
        return usersRepository.findAll();
    }

//    public Optional<users> findById(String userName){
//        return usersRepository.findById(id);
//    }
    public users findByUserName(String userName){
        return  usersRepository.findByUserName(userName).orElse(null);
    }
    public users deleteByUserName(String userName){
        return usersRepository.deleteByUserName(userName).orElse(null);
    }
//    public users deleteById(ObjectId id){
//        return usersRepository.deleteById(id);
//    }

}
