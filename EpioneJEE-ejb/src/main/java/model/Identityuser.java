package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the identityusers database table.
 * 
 */
@Entity
@Table(name="identityusers")
@NamedQuery(name="Identityuser.findAll", query="SELECT i FROM Identityuser i")
public class Identityuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private int accessFailedCount;

	@Lob
	private String email;

	private byte emailConfirmed;

	private byte lockoutEnabled;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lockoutEndDateUtc;

	@Lob
	private String passwordHash;

	@Lob
	private String phoneNumber;

	private byte phoneNumberConfirmed;

	@Lob
	private String securityStamp;

	private byte twoFactorEnabled;

	@Lob
	private String userName;

	//bi-directional many-to-one association to Identityuserclaim
	@OneToMany(mappedBy="identityuser")
	private List<Identityuserclaim> identityuserclaims;

	//bi-directional many-to-one association to Identityuserlogin
	@OneToMany(mappedBy="identityuser")
	private List<Identityuserlogin> identityuserlogins;

	//bi-directional many-to-one association to Identityuserrole
	@OneToMany(mappedBy="identityuser")
	private List<Identityuserrole> identityuserroles;

	public Identityuser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(byte emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public byte getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(byte lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public Date getLockoutEndDateUtc() {
		return this.lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Date lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public byte getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(byte phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	public String getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public byte getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(byte twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Identityuserclaim> getIdentityuserclaims() {
		return this.identityuserclaims;
	}

	public void setIdentityuserclaims(List<Identityuserclaim> identityuserclaims) {
		this.identityuserclaims = identityuserclaims;
	}

	public Identityuserclaim addIdentityuserclaim(Identityuserclaim identityuserclaim) {
		getIdentityuserclaims().add(identityuserclaim);
		identityuserclaim.setIdentityuser(this);

		return identityuserclaim;
	}

	public Identityuserclaim removeIdentityuserclaim(Identityuserclaim identityuserclaim) {
		getIdentityuserclaims().remove(identityuserclaim);
		identityuserclaim.setIdentityuser(null);

		return identityuserclaim;
	}

	public List<Identityuserlogin> getIdentityuserlogins() {
		return this.identityuserlogins;
	}

	public void setIdentityuserlogins(List<Identityuserlogin> identityuserlogins) {
		this.identityuserlogins = identityuserlogins;
	}

	public Identityuserlogin addIdentityuserlogin(Identityuserlogin identityuserlogin) {
		getIdentityuserlogins().add(identityuserlogin);
		identityuserlogin.setIdentityuser(this);

		return identityuserlogin;
	}

	public Identityuserlogin removeIdentityuserlogin(Identityuserlogin identityuserlogin) {
		getIdentityuserlogins().remove(identityuserlogin);
		identityuserlogin.setIdentityuser(null);

		return identityuserlogin;
	}

	public List<Identityuserrole> getIdentityuserroles() {
		return this.identityuserroles;
	}

	public void setIdentityuserroles(List<Identityuserrole> identityuserroles) {
		this.identityuserroles = identityuserroles;
	}

	public Identityuserrole addIdentityuserrole(Identityuserrole identityuserrole) {
		getIdentityuserroles().add(identityuserrole);
		identityuserrole.setIdentityuser(this);

		return identityuserrole;
	}

	public Identityuserrole removeIdentityuserrole(Identityuserrole identityuserrole) {
		getIdentityuserroles().remove(identityuserrole);
		identityuserrole.setIdentityuser(null);

		return identityuserrole;
	}

}