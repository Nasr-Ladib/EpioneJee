package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the doctolib database table.
 * 
 */
@Entity
@NamedQuery(name="Doctolib.findAll", query="SELECT d FROM Doctolib d")
public class Doctolib implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doctolibId;

	@Lob
	private String address;

	@Lob
	private String city;

	@Lob
	private String img;

	@Lob
	private String name;

	@Lob
	private String path;

	@Lob
	private String speciality;

	//bi-directional many-to-one association to Doctolibother
	@ManyToOne
	@JoinColumn(name="DoctolibOther_DoctolibId")
	private Doctolibother doctolibother1;

	//bi-directional one-to-one association to Doctolibdoctor
	@OneToOne(mappedBy="doctolib")
	private Doctolibdoctor doctolibdoctor;

	//bi-directional one-to-one association to Doctolibother
	@OneToOne(mappedBy="doctolib")
	private Doctolibother doctolibother2;

	public Doctolib() {
	}

	public int getDoctolibId() {
		return this.doctolibId;
	}

	public void setDoctolibId(int doctolibId) {
		this.doctolibId = doctolibId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Doctolibother getDoctolibother1() {
		return this.doctolibother1;
	}

	public void setDoctolibother1(Doctolibother doctolibother1) {
		this.doctolibother1 = doctolibother1;
	}

	public Doctolibdoctor getDoctolibdoctor() {
		return this.doctolibdoctor;
	}

	public void setDoctolibdoctor(Doctolibdoctor doctolibdoctor) {
		this.doctolibdoctor = doctolibdoctor;
	}

	public Doctolibother getDoctolibother2() {
		return this.doctolibother2;
	}

	public void setDoctolibother2(Doctolibother doctolibother2) {
		this.doctolibother2 = doctolibother2;
	}

}