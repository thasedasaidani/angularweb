package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ContactRestService {
	@Autowired
	private ContactRepository contactRepository;
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public List<Contact> getContact() {
	return contactRepository.findAll();
	}
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.GET)
	public Optional<Contact> getContact(@PathVariable("id") Long id) {
	    return contactRepository.findById(id);
	}
	//methode poste 
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public Contact save (@RequestBody Contact c ) {
	    return contactRepository.save(c);
	}
	//methode delete 
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable("id") Long id) {
	    contactRepository.deleteById(id);
	    return true;
	}

	
	
}

