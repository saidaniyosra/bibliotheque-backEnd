package biblio.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import biblio.domain.Categorie;
import biblio.jwtauthentication.model.Role;
import biblio.jwtauthentication.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="livre")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livre {
	@Id
private int idlivre;
	@GeneratedValue(strategy=GenerationType.AUTO)
private String titre;
private String description;
private Date dateEdition;
private String auteur;
private String image;
private boolean estDisponible;
@ManyToOne
private Categorie categorie;

@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "user_livre", 
	joinColumns = @JoinColumn(name = "idlivre"), 
	inverseJoinColumns = @JoinColumn(name = "user_id"))
private Set<User> users = new HashSet<>();




}
