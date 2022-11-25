package com.csv.ContactList.controller;

import com.csv.ContactList.model.Contact;
import com.csv.ContactList.repository.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // interface annotated with @Controller and @ResponseBody, indicates that a class is a controller
@RequestMapping({"/contacts"}) // annotation for mapping web requests onto methods, starting with /contacts
// test through (http://localhost:8080/contacts)

public class ContactController {
    private ContactRepository repository; //creates the repository object
    ContactController(ContactRepository contactRepository) {
        this.repository = contactRepository;
    }

    // retrieve all contacts (GET/contacts)
    // (select * from contact)
    @GetMapping //interface annotation for mapping HTTP GET requests onto specific methods
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
    @PostMapping //interface annotation for mapping HTTP POST requests onto specific methods
    public Contact create(@RequestBody Contact contact) {
        return repository.save(contact);
    }

    // update contact (PUT/contacts)
    @PutMapping(value = "/{id}") //interface annotation for mapping HTTP PUT requests onto specific methods
    public ResponseEntity<Contact> update(@PathVariable("id") long id,@RequestBody Contact contact) {
        return repository.findById(id).map(record -> {
            record.setName((contact.getName()));
            record.setEmail(contact.getEmail());
            record.setPhone(contact.getPhone());
            record.setLanguage(contact.getLanguage());
            record.setState(contact.getState());
            record.setLinkedin(contact.getLinkedin());
            Contact updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // remove contact (DELETE/contacts/{id})
    @DeleteMapping(path ={"/{id}"}) //interface annotation for mapping HTTP DELETE requests onto specific methods
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
