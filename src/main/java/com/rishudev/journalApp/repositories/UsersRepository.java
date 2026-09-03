package com.rishudev.journalApp.repositories;

import com.rishudev.journalApp.entity.JournalEntry;
import com.rishudev.journalApp.entity.users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsersRepository extends MongoRepository<users, ObjectId> {
        Optional<users> findByUserName(String userName);
        Optional<users> deleteByUserName(String userName);
}
