package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customuserlogins database table.
 * 
 */
@Entity
@Table(name="customuserlogins")
@NamedQuery(name="Customuserlogin.findAll", query="SELECT c FROM Customuserlogin c")
public class Customuserlogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String loginProvider;

	@Lob
	private String providerKey;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	public Customuserlogin() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}