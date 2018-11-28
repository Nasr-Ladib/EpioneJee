package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the messages database table.
 * 
 */
@Entity
@Table(name="messages")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int messageId;

	@Lob
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateMessage;

	//bi-directional many-to-one association to Chat
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="Chat_dateChat", referencedColumnName="dateChat"),
		@JoinColumn(name="Chat_DoctorId", referencedColumnName="DoctorId"),
		@JoinColumn(name="Chat_PatientId", referencedColumnName="PatientId")
		})
	private Chat chat;

	public Message() {
	}

	public int getMessageId() {
		return this.messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateMessage() {
		return this.dateMessage;
	}

	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}

	public Chat getChat() {
		return this.chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

}