package biblio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import biblio.domain.Categorie;

public interface ICategorieRepository extends JpaRepository <Categorie,Integer>{

}
