package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the identityroles database table.
 * 
 */
@Entity
@Table(name="identityroles")
@NamedQuery(name="Identityrole.findAll", query="SELECT i FROM Identityrole i")
public class Identityrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Lob
	private String name;

	//bi-directional many-to-one association to Identityuserrole
	@OneToMany(mappedBy="identityrole")
	private List<Identityuserrole> identityuserroles;

	public Identityrole() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Identityuserrole> getIdentityuserroles() {
		return this.identityuserroles;
	}

	public void setIdentityuserroles(List<Identityuserrole> identityuserroles) {
		this.identityuserroles = identityuserroles;
	}

	public Identityuserrole addIdentityuserrole(Identityuserrole identityuserrole) {
		getIdentityuserroles().add(identityuserrole);
		identityuserrole.setIdentityrole(this);

		return identityuserrole;
	}

	public Identityuserrole removeIdentityuserrole(Identityuserrole identityuserrole) {
		getIdentityuserroles().remove(identityuserrole);
		identityuserrole.setIdentityrole(null);

		return identityuserrole;
	}

}