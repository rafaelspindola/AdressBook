package model;

import lombok.AllArgsConstructor; // creates a class constructor with all arguments/properties
import lombok.Data; // creates toString, equals, hashCode, getters and setters
import lombok.NoArgsConstructor; // creates an empty class constructor with all arguments

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //primary key from SQL

    private String Name;
    private String email;
    private String phone;
//    private String state;
//    private String linkedin;
//    private String language;
}
