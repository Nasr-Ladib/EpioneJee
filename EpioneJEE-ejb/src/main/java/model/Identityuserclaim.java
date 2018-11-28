package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the identityuserclaims database table.
 * 
 */
@Entity
@Table(name="identityuserclaims")
@NamedQuery(name="Identityuserclaim.findAll", query="SELECT i FROM Identityuserclaim i")
public class Identityuserclaim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String claimType;

	@Lob
	private String claimValue;

	@Lob
	private String userId;

	//bi-directional many-to-one association to Identityuser
	@ManyToOne
	private Identityuser identityuser;

	public Identityuserclaim() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClaimType() {
		return this.claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getClaimValue() {
		return this.claimValue;
	}

	public void setClaimValue(String claimValue) {
		this.claimValue = claimValue;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Identityuser getIdentityuser() {
		return this.identityuser;
	}

	public void setIdentityuser(Identityuser identityuser) {
		this.identityuser = identityuser;
	}

}