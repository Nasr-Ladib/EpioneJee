package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customrole database table.
 * 
 */
@Entity
@NamedQuery(name="Customrole.findAll", query="SELECT c FROM Customrole c")
public class Customrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String name;

	//bi-directional many-to-one association to Customuserrole
	@OneToMany(mappedBy="customrole")
	private List<Customuserrole> customuserroles;

	public Customrole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Customuserrole> getCustomuserroles() {
		return this.customuserroles;
	}

	public void setCustomuserroles(List<Customuserrole> customuserroles) {
		this.customuserroles = customuserroles;
	}

	public Customuserrole addCustomuserrole(Customuserrole customuserrole) {
		getCustomuserroles().add(customuserrole);
		customuserrole.setCustomrole(this);

		return customuserrole;
	}

	public Customuserrole removeCustomuserrole(Customuserrole customuserrole) {
		getCustomuserroles().remove(customuserrole);
		customuserrole.setCustomrole(null);

		return customuserrole;
	}

}