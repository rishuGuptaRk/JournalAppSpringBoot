package com.rishudev.journalApp.Controller;
import com.rishudev.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import  java.util.Map;
import  java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> JournalEntries = new HashMap<>();
    @GetMapping // only this one point will work not other //get
    public List<JournalEntry> getAll(){
    return new ArrayList<>(JournalEntries.values());
    }
    @PostMapping //create/post entry
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        JournalEntries.put(myEntry.getId(), myEntry);
        return true;
    }
    @GetMapping("id/{myId}") //search
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return JournalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}") //delete
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
        return JournalEntries.remove(myId);
    }
    @PutMapping("id/{id}") //update
    public JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry myEntry){
        return JournalEntries.put(id, myEntry);
    }
}