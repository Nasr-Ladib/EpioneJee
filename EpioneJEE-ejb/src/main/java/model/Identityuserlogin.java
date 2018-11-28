package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the identityuserlogins database table.
 * 
 */
@Entity
@Table(name="identityuserlogins")
@NamedQuery(name="Identityuserlogin.findAll", query="SELECT i FROM Identityuserlogin i")
public class Identityuserlogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String userId;

	@Lob
	private String loginProvider;

	@Lob
	private String providerKey;

	//bi-directional many-to-one association to Identityuser
	@ManyToOne
	private Identityuser identityuser;

	public Identityuserlogin() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginProvider() {
		return this.loginProvider;
	}

	public void setLoginProvider(String loginProvider) {
		this.loginProvider = loginProvider;
	}

	public String getProviderKey() {
		return this.providerKey;
	}

	public void setProviderKey(String providerKey) {
		this.providerKey = providerKey;
	}

	public Identityuser getIdentityuser() {
		return this.identityuser;
	}

	public void setIdentityuser(Identityuser identityuser) {
		this.identityuser = identityuser;
	}

}