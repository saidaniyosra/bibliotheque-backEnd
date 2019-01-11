package biblio.jwtauthentication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import biblio.domain.Livre;
import biblio.jwtauthentication.model.User;
import biblio.jwtauthentication.repository.UserRepository;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("users")
public class Usercontroller {
	@Autowired
	private UserRepository repo;
	
	
	@GetMapping
	public List<User> tousLeslivres() {
		return repo.findAll();
	}

	@PostMapping(path= "/add" )
	public  void create( @RequestBody User U){
		repo.save(U);
		}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public  ResponseEntity<User> findById(@PathVariable("id") Long id) {
		Optional<User> resultat =  repo.findById(id);
		if (resultat.isPresent())
			return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	@PutMapping
	public  ResponseEntity<User> update(@RequestBody User U){
		 
		 try {
				repo.save(U);
				return new ResponseEntity<User>(U, HttpStatus.ACCEPTED);
			} catch (Exception e) {
				return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
			}
}
	
	
	@DeleteMapping(path= "/{id}" )
	public  ResponseEntity<User> deleteById(@PathVariable("id") long id) {
		Optional<User> resultat =  repo.findById(id);
		if (resultat.isPresent()) {
			 repo.deleteById(id);
			 return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
			
		else
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
}