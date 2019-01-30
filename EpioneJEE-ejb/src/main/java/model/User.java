package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int accessFailedCount;

	@Lob
	private String address;

	@Lob
	private String bioghrapy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;

	private int cnam;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private int doctolib;

	@Lob
	private String email;


	private byte emailConfirmed;

	@Lob
	private String firstName;

	@Lob
	private String img;

	@Lob
	private String lastName;

	private int latitude;

	private byte lockoutEnabled;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lockoutEndDateUtc;

	@Lob
	private String login;

	private int longitude;

	@Lob
	private String motif;

	private int officeNumber;

	@Lob
	private String password;

	@Lob
	private String phoneNumber;

	private byte phoneNumberConfirmed;

	@Lob
	private String role;

	private int rpps;

	@Lob
	private String securityStamp;

	private int speciality;

	@Lob
	private String specialityDocotor;

	private int status;

	private float tarif;

	private byte twoFactorEnabled;

	private String type;

	@Lob
	private String webSite;

	//bi-directional one-to-one association to Account
	@OneToOne(mappedBy="user")
	private Account account;

	//bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy="user1")
	private List<Appointment> appointments1;

	//bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy="user2")
	private List<Appointment> appointments2;

	//bi-directional one-to-one association to Calendar
	@OneToOne(mappedBy="user")
	private Calendar calendar;

	//bi-directional many-to-one association to Chat
	@OneToMany(mappedBy="user1")
	private List<Chat> chats1;

	//bi-directional many-to-one association to Chat
	@OneToMany(mappedBy="user2")
	private List<Chat> chats2;

	//bi-directional many-to-one association to Customuserclaim
	@OneToMany(mappedBy="user")
	private List<Customuserclaim> customuserclaims;

	//bi-directional many-to-one association to Customuserlogin
	@OneToMany(mappedBy="user")
	private List<Customuserlogin> customuserlogins;

	//bi-directional many-to-one association to Customuserrole
	@OneToMany(mappedBy="user")
	private List<Customuserrole> customuserroles;

	//bi-directional many-to-many association to Medicalfile
	@ManyToMany
	@JoinTable(
		name="doctor_medicalfile"
		, joinColumns={
			@JoinColumn(name="DoctorId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="MedicalFileId")
			}
		)
	private List<Medicalfile> medicalfiles;

	//bi-directional one-to-one association to Medicalfile
	@OneToOne(mappedBy="user")
	private Medicalfile medicalfile;

	//bi-directional many-to-one association to Motif
	@OneToMany(mappedBy="user")
	private List<Motif> motifs;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Doctor_Id")
	private User user1;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="user1")
	private List<User> users1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Doctor_Id1")
	private User user2;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="user2")
	private List<User> users2;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Patient_Id")
	private User user3;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="user3")
	private List<User> users3;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Patient_Id1")
	private User user4;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="user4")
	private List<User> users4;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBioghrapy() {
		return this.bioghrapy;
	}

	public void setBioghrapy(String bioghrapy) {
		this.bioghrapy = bioghrapy;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getCnam() {
		return this.cnam;
	}

	public void setCnam(int cnam) {
		this.cnam = cnam;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getDoctolib() {
		return this.doctolib;
	}

	public void setDoctolib(int doctolib) {
		this.doctolib = doctolib;
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

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
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

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getLongitude() {
		return this.longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public String getMotif() {
		return this.motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public int getOfficeNumber() {
		return this.officeNumber;
	}

	public void setOfficeNumber(int officeNumber) {
		this.officeNumber = officeNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getRpps() {
		return this.rpps;
	}

	public void setRpps(int rpps) {
		this.rpps = rpps;
	}

	public String getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public int getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(int speciality) {
		this.speciality = speciality;
	}

	public String getSpecialityDocotor() {
		return this.specialityDocotor;
	}

	public void setSpecialityDocotor(String specialityDocotor) {
		this.specialityDocotor = specialityDocotor;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public float getTarif() {
		return this.tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}

	public byte getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(byte twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Appointment> getAppointments1() {
		return this.appointments1;
	}

	public void setAppointments1(List<Appointment> appointments1) {
		this.appointments1 = appointments1;
	}

	public Appointment addAppointments1(Appointment appointments1) {
		getAppointments1().add(appointments1);
		appointments1.setUser1(this);

		return appointments1;
	}

	public Appointment removeAppointments1(Appointment appointments1) {
		getAppointments1().remove(appointments1);
		appointments1.setUser1(null);

		return appointments1;
	}

	public List<Appointment> getAppointments2() {
		return this.appointments2;
	}

	public void setAppointments2(List<Appointment> appointments2) {
		this.appointments2 = appointments2;
	}

	public Appointment addAppointments2(Appointment appointments2) {
		getAppointments2().add(appointments2);
		appointments2.setUser2(this);

		return appointments2;
	}

	public Appointment removeAppointments2(Appointment appointments2) {
		getAppointments2().remove(appointments2);
		appointments2.setUser2(null);

		return appointments2;
	}

	public Calendar getCalendar() {
		return this.calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public List<Chat> getChats1() {
		return this.chats1;
	}

	public void setChats1(List<Chat> chats1) {
		this.chats1 = chats1;
	}

	public Chat addChats1(Chat chats1) {
		getChats1().add(chats1);
		chats1.setUser1(this);

		return chats1;
	}

	public Chat removeChats1(Chat chats1) {
		getChats1().remove(chats1);
		chats1.setUser1(null);

		return chats1;
	}

	public List<Chat> getChats2() {
		return this.chats2;
	}

	public void setChats2(List<Chat> chats2) {
		this.chats2 = chats2;
	}

	public Chat addChats2(Chat chats2) {
		getChats2().add(chats2);
		chats2.setUser2(this);

		return chats2;
	}

	public Chat removeChats2(Chat chats2) {
		getChats2().remove(chats2);
		chats2.setUser2(null);

		return chats2;
	}

	public List<Customuserclaim> getCustomuserclaims() {
		return this.customuserclaims;
	}

	public void setCustomuserclaims(List<Customuserclaim> customuserclaims) {
		this.customuserclaims = customuserclaims;
	}

	public Customuserclaim addCustomuserclaim(Customuserclaim customuserclaim) {
		getCustomuserclaims().add(customuserclaim);
		customuserclaim.setUser(this);

		return customuserclaim;
	}

	public Customuserclaim removeCustomuserclaim(Customuserclaim customuserclaim) {
		getCustomuserclaims().remove(customuserclaim);
		customuserclaim.setUser(null);

		return customuserclaim;
	}

	public List<Customuserlogin> getCustomuserlogins() {
		return this.customuserlogins;
	}

	public void setCustomuserlogins(List<Customuserlogin> customuserlogins) {
		this.customuserlogins = customuserlogins;
	}

	public Customuserlogin addCustomuserlogin(Customuserlogin customuserlogin) {
		getCustomuserlogins().add(customuserlogin);
		customuserlogin.setUser(this);

		return customuserlogin;
	}

	public Customuserlogin removeCustomuserlogin(Customuserlogin customuserlogin) {
		getCustomuserlogins().remove(customuserlogin);
		customuserlogin.setUser(null);

		return customuserlogin;
	}

	public List<Customuserrole> getCustomuserroles() {
		return this.customuserroles;
	}

	public void setCustomuserroles(List<Customuserrole> customuserroles) {
		this.customuserroles = customuserroles;
	}

	public Customuserrole addCustomuserrole(Customuserrole customuserrole) {
		getCustomuserroles().add(customuserrole);
		customuserrole.setUser(this);

		return customuserrole;
	}

	public Customuserrole removeCustomuserrole(Customuserrole customuserrole) {
		getCustomuserroles().remove(customuserrole);
		customuserrole.setUser(null);

		return customuserrole;
	}

	public List<Medicalfile> getMedicalfiles() {
		return this.medicalfiles;
	}

	public void setMedicalfiles(List<Medicalfile> medicalfiles) {
		this.medicalfiles = medicalfiles;
	}

	public Medicalfile getMedicalfile() {
		return this.medicalfile;
	}

	public void setMedicalfile(Medicalfile medicalfile) {
		this.medicalfile = medicalfile;
	}

	public List<Motif> getMotifs() {
		return this.motifs;
	}

	public void setMotifs(List<Motif> motifs) {
		this.motifs = motifs;
	}

	public Motif addMotif(Motif motif) {
		getMotifs().add(motif);
		motif.setUser(this);

		return motif;
	}

	public Motif removeMotif(Motif motif) {
		getMotifs().remove(motif);
		motif.setUser(null);

		return motif;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public List<User> getUsers1() {
		return this.users1;
	}

	public void setUsers1(List<User> users1) {
		this.users1 = users1;
	}

	public User addUsers1(User users1) {
		getUsers1().add(users1);
		users1.setUser1(this);

		return users1;
	}

	public User removeUsers1(User users1) {
		getUsers1().remove(users1);
		users1.setUser1(null);

		return users1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public List<User> getUsers2() {
		return this.users2;
	}

	public void setUsers2(List<User> users2) {
		this.users2 = users2;
	}

	public User addUsers2(User users2) {
		getUsers2().add(users2);
		users2.setUser2(this);

		return users2;
	}

	public User removeUsers2(User users2) {
		getUsers2().remove(users2);
		users2.setUser2(null);

		return users2;
	}

	public User getUser3() {
		return this.user3;
	}

	public void setUser3(User user3) {
		this.user3 = user3;
	}

	public List<User> getUsers3() {
		return this.users3;
	}

	public void setUsers3(List<User> users3) {
		this.users3 = users3;
	}

	public User addUsers3(User users3) {
		getUsers3().add(users3);
		users3.setUser3(this);

		return users3;
	}

	public User removeUsers3(User users3) {
		getUsers3().remove(users3);
		users3.setUser3(null);

		return users3;
	}

	public User getUser4() {
		return this.user4;
	}

	public void setUser4(User user4) {
		this.user4 = user4;
	}

	public List<User> getUsers4() {
		return this.users4;
	}

	public void setUsers4(List<User> users4) {
		this.users4 = users4;
	}

	public User addUsers4(User users4) {
		getUsers4().add(users4);
		users4.setUser4(this);

		return users4;
	}

	public User removeUsers4(User users4) {
		getUsers4().remove(users4);
		users4.setUser4(null);

		return users4;
	}

	@Override
	public String toString() {
		return "User [address=" + address + ", email=" + email + ", firstName=" + firstName + "]";
	}
}