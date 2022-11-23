package com.csv.ContactList;

import com.csv.ContactList.model.Contact;
import com.csv.ContactList.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class ContactListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactListApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ContactRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1,11)
					.mapToObj(i -> {
						Contact c = new Contact();
						c.setName("Contact: " + i);
						c.setPhone("contact " + i + "@email.com");
						c.setEmail("(11) 11111-1111");
						return c;
			}).map(v -> repository.save(v)).forEach(System.out::println);
		};
	}


}
