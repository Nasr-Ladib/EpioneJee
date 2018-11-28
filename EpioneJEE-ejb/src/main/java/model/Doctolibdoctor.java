package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the doctolibdoctor database table.
 * 
 */
@Entity
@NamedQuery(name="Doctolibdoctor.findAll", query="SELECT d FROM Doctolibdoctor d")
public class Doctolibdoctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doctolibId;

	@Lob
	private String adresseSocialSiege;

	@Lob
	private String formeJuridique;

	@Lob
	private String horaires;

	@Lob
	private String lat;

	@Lob
	private String lng;

	private byte memberAGA;

	@Lob
	private String nbreInscriptionOrdre;

	@Lob
	private String nbreRCS;

	@Lob
	private String nbreRPPS;

	@Lob
	private String presentationProfession;

	@Lob
	private String socialReason;

	@Lob
	private String statuts;

	//bi-directional one-to-one association to Doctolib
	@OneToOne
	@JoinColumn(name="DoctolibId")
	private Doctolib doctolib;

	public Doctolibdoctor() {
	}

	public int getDoctolibId() {
		return this.doctolibId;
	}

	public void setDoctolibId(int doctolibId) {
		this.doctolibId = doctolibId;
	}

	public String getAdresseSocialSiege() {
		return this.adresseSocialSiege;
	}

	public void setAdresseSocialSiege(String adresseSocialSiege) {
		this.adresseSocialSiege = adresseSocialSiege;
	}

	public String getFormeJuridique() {
		return this.formeJuridique;
	}

	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}

	public String getHoraires() {
		return this.horaires;
	}

	public void setHoraires(String horaires) {
		this.horaires = horaires;
	}

	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return this.lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public byte getMemberAGA() {
		return this.memberAGA;
	}

	public void setMemberAGA(byte memberAGA) {
		this.memberAGA = memberAGA;
	}

	public String getNbreInscriptionOrdre() {
		return this.nbreInscriptionOrdre;
	}

	public void setNbreInscriptionOrdre(String nbreInscriptionOrdre) {
		this.nbreInscriptionOrdre = nbreInscriptionOrdre;
	}

	public String getNbreRCS() {
		return this.nbreRCS;
	}

	public void setNbreRCS(String nbreRCS) {
		this.nbreRCS = nbreRCS;
	}

	public String getNbreRPPS() {
		return this.nbreRPPS;
	}

	public void setNbreRPPS(String nbreRPPS) {
		this.nbreRPPS = nbreRPPS;
	}

	public String getPresentationProfession() {
		return this.presentationProfession;
	}

	public void setPresentationProfession(String presentationProfession) {
		this.presentationProfession = presentationProfession;
	}

	public String getSocialReason() {
		return this.socialReason;
	}

	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}

	public String getStatuts() {
		return this.statuts;
	}

	public void setStatuts(String statuts) {
		this.statuts = statuts;
	}

	public Doctolib getDoctolib() {
		return this.doctolib;
	}

	public void setDoctolib(Doctolib doctolib) {
		this.doctolib = doctolib;
	}

}