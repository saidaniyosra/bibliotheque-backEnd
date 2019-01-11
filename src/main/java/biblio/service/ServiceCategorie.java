package biblio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblio.Repository.ICategorieRepository;
import biblio.domain.Categorie;
@Service
public class ServiceCategorie implements IServiceCategorie{
@Autowired
	private ICategorieRepository repo;
	@Override
	public List<Categorie> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Optional<Categorie> findById(int id) {
		
		return repo.findById(id);
	}

	@Override
	public void save(Categorie c) {
		repo.save(c);
		
	}

	@Override
	public void delete(Categorie c) {
		repo.delete(c);
		
	}

}
