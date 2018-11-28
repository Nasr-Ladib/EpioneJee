package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the motif database table.
 * 
 */
@Entity
@NamedQuery(name="Motif.findAll", query="SELECT m FROM Motif m")
public class Motif implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int motifId;

	private int idDoctor;

	@Lob
	private String motifs;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Doctor_Id")
	private User user;

	public Motif() {
	}

	public int getMotifId() {
		return this.motifId;
	}

	public void setMotifId(int motifId) {
		this.motifId = motifId;
	}

	public int getIdDoctor() {
		return this.idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getMotifs() {
		return this.motifs;
	}

	public void setMotifs(String motifs) {
		this.motifs = motifs;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}