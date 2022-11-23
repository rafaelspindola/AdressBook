package repository;

import model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

// how to access methods and manipulate contact table, in other words, accessing CRUD operations
public interface ContactRepository
    extends JpaRepository<Contact, Long> { }

