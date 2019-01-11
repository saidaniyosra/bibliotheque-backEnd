package biblio.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biblio.domain.Categorie;
import biblio.service.IServiceCategorie;
@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("categories")
public class CategorieRestController {

	@Autowired
	private IServiceCategorie service;
	@GetMapping
	public List<Categorie> tousLesCategories() {
		return service.findAll();
	}
	@GetMapping(path= "/{id}" )
	public  ResponseEntity<Categorie> findById(@PathVariable("id") int id) {
		Optional<Categorie> resultat =  service.findById(id);
		if (resultat.isPresent())
			return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public  ResponseEntity<Categorie> create( @RequestBody Categorie c){
		
		if (!service.findById(c.getIdCat()).isPresent())
		{
			service.save(c);
			return new ResponseEntity<Categorie>(c, HttpStatus.CREATED);
		} else
			return new ResponseEntity<Categorie>(HttpStatus.NOT_ACCEPTABLE);
	
	}	
	
	@PutMapping
	public  ResponseEntity<Categorie> update(@RequestBody Categorie c){
		 
		 try {
				service.save(c);
				return new ResponseEntity<Categorie>(c, HttpStatus.ACCEPTED);
			} catch (Exception e) {
				return new ResponseEntity<Categorie>(HttpStatus.NOT_ACCEPTABLE);
			}
}
	
	@DeleteMapping(path= "/{id}" )
	public  ResponseEntity<Categorie> deleteById(@PathVariable("id") int id) {
		Optional<Categorie> resultat =  service.findById(id);
		if (resultat.isPresent()) {
			 service.delete(resultat.get());
			 return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
			
		else
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
}
