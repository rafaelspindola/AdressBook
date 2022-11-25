package com.csv.ContactList.model;

import lombok.AllArgsConstructor; // creates a class constructor with all arguments/properties
import lombok.Data; // creates toString, equals, hashCode, getters and setters
import lombok.NoArgsConstructor; // creates an empty class constructor with all arguments

import javax.persistence.Entity;
import javax.persistence.GeneratedValue; // specification for generation strategies
import javax.persistence.GenerationType; // defines types of primary key generation strategies
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // interface that specifies that the class is an entity (represents a table in a database)

public class Contact {

    @Id //specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //initializes primary key from SQL

    // each entity instance corresponds to a row in a table
    private String Name;
    private String email;
    private String phone;
    private String state;
    private String linkedin;
    private String language;
}