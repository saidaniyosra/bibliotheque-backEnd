package biblio.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblio.Repository.ILivreRepository;
import biblio.domain.Livre;
@Service
public class ServiceLivre implements IServiceLivre {

	@Autowired
	private ILivreRepository repo;
	@Override
	public List<Livre> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Optional<Livre> findById(int id) {
		
		return repo.findById(id);
	}

	@Override
	public void save(Livre L) {
		repo.save(L);
		
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<Livre> findByCat(int id) {
		// TODO Auto-generated method stub
		return repo.findByCat(id);
	}

	public Livre findByTitre(String titre) {
		return repo.findByTitre(titre);
	}

}
