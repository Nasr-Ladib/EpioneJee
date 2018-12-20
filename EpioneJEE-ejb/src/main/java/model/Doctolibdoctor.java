package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the doctolibdoctor database table.
 * 
 */
@Entity
@NamedQuery(name="Doctolibdoctor.findAll", query="SELECT d FROM Doctolibdoctor d")
public class Doctolibdoctor extends Doctolib implements Serializable  {
	private static final long serialVersionUID = 1L;



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
	@Lob
	private String skills;

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
	




	public Doctolibdoctor() {
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

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
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

	

}