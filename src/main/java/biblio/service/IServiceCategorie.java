package biblio.service;

import java.util.List;
import java.util.Optional;

import biblio.domain.Categorie;


public interface IServiceCategorie {
	public List <Categorie>findAll();
	public Optional<Categorie> findById(int id);
	public void save(Categorie c);
	public void delete (Categorie c);
	
}
