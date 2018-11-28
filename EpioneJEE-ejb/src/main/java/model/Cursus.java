package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cursus database table.
 * 
 */
@Entity
@NamedQuery(name="Cursus.findAll", query="SELECT c FROM Cursus c")
public class Cursus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cursusId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCursus;

	@Lob
	private String description;

	@Lob
	private String report;

	private byte status;

	@Lob
	private String treatment;

	//bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy="cursus")
	private List<Appointment> appointments;

	//bi-directional many-to-one association to Medicalfile
	@ManyToOne
	private Medicalfile medicalfile;

	public Cursus() {
	}

	public int getCursusId() {
		return this.cursusId;
	}

	public void setCursusId(int cursusId) {
		this.cursusId = cursusId;
	}

	public Date getDateCursus() {
		return this.dateCursus;
	}

	public void setDateCursus(Date dateCursus) {
		this.dateCursus = dateCursus;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReport() {
		return this.report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getTreatment() {
		return this.treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setCursus(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setCursus(null);

		return appointment;
	}

	public Medicalfile getMedicalfile() {
		return this.medicalfile;
	}

	public void setMedicalfile(Medicalfile medicalfile) {
		this.medicalfile = medicalfile;
	}

}