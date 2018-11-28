package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the appointments database table.
 * 
 */
@Entity
@Table(name="appointments")
@NamedQuery(name="Appointment.findAll", query="SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AppointmentPK id;

	@Lob
	private String comment;

	@Lob
	private String motif;

	private int rate;

	private byte status;

	//bi-directional many-to-one association to Cursus
	@ManyToOne
	private Cursus cursus;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Doctor_Id")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Patient_Id")
	private User user2;

	public Appointment() {
	}

	public AppointmentPK getId() {
		return this.id;
	}

	public void setId(AppointmentPK id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getMotif() {
		return this.motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Cursus getCursus() {
		return this.cursus;
	}

	public void setCursus(Cursus cursus) {
		this.cursus = cursus;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}