package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner{
    @Autowired
	private ContactRepository contactRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("hassani" , "mohamed", df.parse("17/09/2000") , "tasa122@gmail.com", 977655443 , "hasaan.jpg" ));
		contactRepository.save(new Contact("Saidani", "Meriem", df.parse("25/12/1998"), "meriem.saidani@gmail.com", 612345678L, "meriem.jpg"));
	    contactRepository.save(new Contact("Benkhelifa", "Yacine", df.parse("03/03/1995"), "yacine.bk@gmail.com", 623456789L, "yacine.jpg"));
	    contactRepository.save(new Contact("Zerrouki", "Amel", df.parse("10/07/1990"), "amel.z@hotmail.com", 634567890L, "amel.jpg"));
	    contactRepository.save(new Contact("Ait", "Nacer", df.parse("14/11/1988"), "nacer.ait@yahoo.fr", 645678901L, "nacer.jpg"));
	    contactRepository.save(new Contact("Bouzar", "Sara", df.parse("22/08/2002"), "sara.bouzar@gmail.com", 656789012L, "sara.jpg"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});

}}
