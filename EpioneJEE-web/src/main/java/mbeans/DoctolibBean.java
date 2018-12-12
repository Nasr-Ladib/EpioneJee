package mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Lob;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

import model.*;

@ManagedBean
public class DoctolibBean {

	
	private String address;


	private String img;

	private String name;

	private String path;

	private String speciality;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	public String listDoctorsById(){


		
  		 return "AAAAAA";

	}
	
}
