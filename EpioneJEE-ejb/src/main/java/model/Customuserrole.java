package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customuserroles database table.
 * 
 */
@Entity
@Table(name="customuserroles")
@NamedQuery(name="Customuserrole.findAll", query="SELECT c FROM Customuserrole c")
public class Customuserrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int roleId;

	//bi-directional many-to-one association to Customrole
	@ManyToOne
	private Customrole customrole;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	public Customuserrole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Customrole getCustomrole() {
		return this.customrole;
	}

	public void setCustomrole(Customrole customrole) {
		this.customrole = customrole;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}