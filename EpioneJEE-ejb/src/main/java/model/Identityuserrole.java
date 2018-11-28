package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the identityuserroles database table.
 * 
 */
@Entity
@Table(name="identityuserroles")
@NamedQuery(name="Identityuserrole.findAll", query="SELECT i FROM Identityuserrole i")
public class Identityuserrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IdentityuserrolePK id;

	//bi-directional many-to-one association to Identityrole
	@ManyToOne
	private Identityrole identityrole;

	//bi-directional many-to-one association to Identityuser
	@ManyToOne
	private Identityuser identityuser;

	public Identityuserrole() {
	}

	public IdentityuserrolePK getId() {
		return this.id;
	}

	public void setId(IdentityuserrolePK id) {
		this.id = id;
	}

	public Identityrole getIdentityrole() {
		return this.identityrole;
	}

	public void setIdentityrole(Identityrole identityrole) {
		this.identityrole = identityrole;
	}

	public Identityuser getIdentityuser() {
		return this.identityuser;
	}

	public void setIdentityuser(Identityuser identityuser) {
		this.identityuser = identityuser;
	}

}