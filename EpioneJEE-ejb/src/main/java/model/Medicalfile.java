package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicalfiles database table.
 * 
 */
@Entity
@Table(name="medicalfiles")
@NamedQuery(name="Medicalfile.findAll", query="SELECT m FROM Medicalfile m")
public class Medicalfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int medicalFileId;

	//bi-directional many-to-one association to Cursus
	@OneToMany(mappedBy="medicalfile")
	private List<Cursus> cursuses;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="medicalfiles")
	private List<User> users;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="MedicalFileId")
	private User user;

	public Medicalfile() {
	}

	public int getMedicalFileId() {
		return this.medicalFileId;
	}

	public void setMedicalFileId(int medicalFileId) {
		this.medicalFileId = medicalFileId;
	}

	public List<Cursus> getCursuses() {
		return this.cursuses;
	}

	public void setCursuses(List<Cursus> cursuses) {
		this.cursuses = cursuses;
	}

	public Cursus addCursus(Cursus cursus) {
		getCursuses().add(cursus);
		cursus.setMedicalfile(this);

		return cursus;
	}

	public Cursus removeCursus(Cursus cursus) {
		getCursuses().remove(cursus);
		cursus.setMedicalfile(null);

		return cursus;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}