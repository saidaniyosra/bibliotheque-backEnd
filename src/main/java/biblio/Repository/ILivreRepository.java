package biblio.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import biblio.domain.*;
import biblio.domain.Livre;
public interface ILivreRepository extends JpaRepository<Livre,Integer> {
	
	
	@Query("select l from Livre l where l.categorie.idCat = :cat")
	  public List<Livre> findByCat(@Param("cat") Integer id1);
	@Query("select l from Livre l where l.titre = :titre")
	  public Livre findByTitre(@Param("titre") String titre);
	
}
