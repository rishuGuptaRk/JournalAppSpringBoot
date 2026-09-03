package com.rishudev.journalApp.entity;

import com.mongodb.lang.NonNull;
import org.apache.catalina.LifecycleState;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class users {
    @Indexed(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @Id
    private ObjectId id;

    @DBRef
    private List<JournalEntry> journalEntries = new ArrayList<>();

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public List<JournalEntry> getJournalEntries(){
        return journalEntries;
    }
    public void setJournalEntries(List<JournalEntry> journalEntries){
        this.journalEntries = journalEntries;
    }
}
