package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the doctolibother database table.
 * 
 */
@Entity
@NamedQuery(name="Doctolibother.findAll", query="SELECT d FROM Doctolibother d")
public class Doctolibother implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doctolibId;

	//bi-directional many-to-one association to Doctolib
	@OneToMany(mappedBy="doctolibother1")
	private List<Doctolib> doctolibs;

	//bi-directional one-to-one association to Doctolib
	@OneToOne
	@JoinColumn(name="DoctolibId")
	private Doctolib doctolib;

	public Doctolibother() {
	}

	public int getDoctolibId() {
		return this.doctolibId;
	}

	public void setDoctolibId(int doctolibId) {
		this.doctolibId = doctolibId;
	}

	public List<Doctolib> getDoctolibs() {
		return this.doctolibs;
	}

	public void setDoctolibs(List<Doctolib> doctolibs) {
		this.doctolibs = doctolibs;
	}

	public Doctolib addDoctolib(Doctolib doctolib) {
		getDoctolibs().add(doctolib);
		doctolib.setDoctolibother1(this);

		return doctolib;
	}

	public Doctolib removeDoctolib(Doctolib doctolib) {
		getDoctolibs().remove(doctolib);
		doctolib.setDoctolibother1(null);

		return doctolib;
	}

	public Doctolib getDoctolib() {
		return this.doctolib;
	}

	public void setDoctolib(Doctolib doctolib) {
		this.doctolib = doctolib;
	}

}