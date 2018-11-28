package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customuserclaims database table.
 * 
 */
@Entity
@Table(name="customuserclaims")
@NamedQuery(name="Customuserclaim.findAll", query="SELECT c FROM Customuserclaim c")
public class Customuserclaim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String claimType;

	@Lob
	private String claimValue;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	public Customuserclaim() {
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}