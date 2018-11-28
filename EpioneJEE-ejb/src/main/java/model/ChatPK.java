package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the chats database table.
 * 
 */
@Embeddable
public class ChatPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int patientId;

	@Column(insertable=false, updatable=false)
	private int doctorId;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date dateChat;

	public ChatPK() {
	}
	public int getPatientId() {
		return this.patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return this.doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public java.util.Date getDateChat() {
		return this.dateChat;
	}
	public void setDateChat(java.util.Date dateChat) {
		this.dateChat = dateChat;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ChatPK)) {
			return false;
		}
		ChatPK castOther = (ChatPK)other;
		return 
			(this.patientId == castOther.patientId)
			&& (this.doctorId == castOther.doctorId)
			&& this.dateChat.equals(castOther.dateChat);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.patientId;
		hash = hash * prime + this.doctorId;
		hash = hash * prime + this.dateChat.hashCode();
		
		return hash;
	}
}