package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the calendars database table.
 * 
 */
@Entity
@Table(name="calendars")
@NamedQuery(name="Calendar.findAll", query="SELECT c FROM Calendar c")
public class Calendar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int calendarId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCal;

	private byte dispo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="CalendarId")
	private User user;

	public Calendar() {
	}

	public int getCalendarId() {
		return this.calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	public Date getDateCal() {
		return this.dateCal;
	}

	public void setDateCal(Date dateCal) {
		this.dateCal = dateCal;
	}

	public byte getDispo() {
		return this.dispo;
	}

	public void setDispo(byte dispo) {
		this.dispo = dispo;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}