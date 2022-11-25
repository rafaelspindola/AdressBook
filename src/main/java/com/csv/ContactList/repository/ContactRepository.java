package com.csv.ContactList.repository;

import com.csv.ContactList.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // indicates that a class is a repository (a mechanism for encapsulating storage, retrieval and search behavior which emulates a collection of objects)

// how to access methods and manipulate contact table, in other words, accessing CRUD operations
public interface ContactRepository
        extends JpaRepository<Contact, Long> { }

