package biblio.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import biblio.domain.Livre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="categorie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {
	@Id
	private int idCat;
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String libele;
	
	//@OneToMany (mappedBy="categorie")
	//private List<Livre>livres;
	

}
