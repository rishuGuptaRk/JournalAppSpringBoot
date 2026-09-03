package com.rishudev.journalApp.Controller;

import com.rishudev.journalApp.entity.JournalEntry;
import com.rishudev.journalApp.entity.users;
import com.rishudev.journalApp.service.UserService;
import com.rishudev.journalApp.service.journalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;
    //Get all users
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<users> all = userService.getAll();
        if (all!= null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping // create user
    public ResponseEntity<users> createEntry(@RequestBody users myEntry){
        try {
            userService.saveEntry(myEntry);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(myEntry, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{userName}")
    public ResponseEntity<users> getUserByUserName(@PathVariable String userName){
        users users = userService.findByUserName(userName);
        if (users != null){

            return  new ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{userName}")
    public ResponseEntity<?> deleteUserEntryByUserName(@PathVariable String userName){
        try {
//            ObjectId objectId = new ObjectId(myId);
            userService.deleteByUserName(userName);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PutMapping("/{user}")
    public ResponseEntity<?> updateUserById(@PathVariable String user, @RequestBody users newEntry){
        users old = userService.findByUserName(user);
        try {
            if (old!=null){
                old.setUserName(newEntry.getUserName() != null && !newEntry.getUserName().equals("") ? newEntry.getUserName() : old.getUserName());
                old.setPassword(newEntry.getPassword() != null && !newEntry.getPassword().equals("") ? newEntry.getPassword() : old.getPassword()) ;
                userService.saveEntry(old);
                return new ResponseEntity<>(old, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}