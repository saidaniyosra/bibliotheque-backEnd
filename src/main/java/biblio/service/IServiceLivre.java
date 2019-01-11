package biblio.service;

import java.util.List;
import java.util.Optional;

import biblio.domain.Livre;

public interface IServiceLivre 
{
	public List <Livre>findAll();
	public Optional<Livre> findById(int id);
	public void save(Livre L);
	public void delete (int id);
	public List <Livre> findByCat(int id);
	public Livre findByTitre (String titre);

}
