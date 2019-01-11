package biblio.rest;

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

import biblio.service.IServiceLivre;
import biblio.Repository.ILivreRepository;
import biblio.domain.Categorie;
import biblio.domain.Livre;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("livres")
public class LivreRestController {
	@Autowired
	private IServiceLivre service;
	@Autowired
	private ILivreRepository repo;
	
	public LivreRestController(IServiceLivre service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public List<Livre> tousLeslivres() {
		return service.findAll();
	}
	
	@RequestMapping(value = "/{idlivre}", method = RequestMethod.GET)
	public  ResponseEntity<Livre> findById(@PathVariable("idlivre") Integer id) {
		Optional<Livre> resultat =  service.findById(id);
		if (resultat.isPresent())
			return new ResponseEntity<>(resultat.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(path= "/add" )
	public  void create( @RequestBody Livre L){
		
		
			service.save(L);
		}
	
	@PutMapping
	public  ResponseEntity<Livre> update(@RequestBody Livre L){
		 
		 try {
				service.save(L);
				return new ResponseEntity<Livre>(L, HttpStatus.ACCEPTED);
			} catch (Exception e) {
				return new ResponseEntity<Livre>(HttpStatus.NOT_ACCEPTABLE);
			}
}
	
	@DeleteMapping(path= "/{id}" )
	public  ResponseEntity<Livre> deleteById(@PathVariable("id") int id) {
		Optional<Livre> resultat =  service.findById(id);
		if (resultat.isPresent()) {
			 service.delete(id);
			 return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
			
		else
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	

	@GetMapping(path= "/liste/{idCat}" )

	public  List <Livre> findByCat(@PathVariable("idCat") int idCat) {
		List <Livre> resultat =  service.findByCat(idCat);
		return resultat;
	}
	@GetMapping(path= "/titre/{titre}" )
	public Livre findByTitre(@PathVariable("titre") String titre) {
		Livre resultat =  service.findByTitre(titre);
		return resultat;
	}

}