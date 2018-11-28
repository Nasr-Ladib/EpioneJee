package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the appointments database table.
 * 
 */
@Embeddable
public class AppointmentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idDoctor;

	private int idPatient;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date date;

	public AppointmentPK() {
	}
	public int getIdDoctor() {
		return this.idDoctor;
	}
	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}
	public int getIdPatient() {
		return this.idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	public java.util.Date getDate() {
		return this.date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AppointmentPK)) {
			return false;
		}
		AppointmentPK castOther = (AppointmentPK)other;
		return 
			(this.idDoctor == castOther.idDoctor)
			&& (this.idPatient == castOther.idPatient)
			&& this.date.equals(castOther.date);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idDoctor;
		hash = hash * prime + this.idPatient;
		hash = hash * prime + this.date.hashCode();
		
		return hash;
	}
}