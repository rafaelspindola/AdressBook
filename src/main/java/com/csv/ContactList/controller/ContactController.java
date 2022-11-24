package com.csv.ContactList.controller;

import com.csv.ContactList.model.Contact;
import com.csv.ContactList.repository.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/contacts"})

public class ContactController {
    private ContactRepository repository;
    ContactController(ContactRepository contactRepository) {
        this.repository = contactRepository;
    }

    // retrieve all contacts (GET/contacts)
    // (select * from contact)
    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    // retrieve a single contact (GET/contacts/{id})
    // (select * from contact where id = ?)
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Contact> findById(@PathVariable long id) { //@PathVariable binds method paramater id with path variable \{id}
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // create new contact
    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return repository.save(contact);
    }

    // update contact (PUT/contacts)
    @PutMapping(value = "/{id}")
    public ResponseEntity<Contact> update(@PathVariable("id") long id,@RequestBody Contact contact) {
        return repository.findById(id).map(record -> {
            record.setName((contact.getName()));
            record.setEmail(contact.getEmail());
            record.setPhone(contact.getPhone());
            record.setLanguage(contact.getLanguage());
            Contact updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // remove contact (DELETE/contacts/{id})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
