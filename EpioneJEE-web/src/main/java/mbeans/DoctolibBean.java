package mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Lob;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

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
	
	public Doctolibdoctor listDoctorsById(){

			Client client =ClientBuilder.newClient();
			WebTarget target =client.target("http://localhost:15248/api/DotolibAPI?link=medecin-generaliste/callian/alexandre-belo");
			//WebTarget link=target.queryParam("medecin-generaliste/callian/alexandre-belo");
			Response response =target.request().get();
			Doctolibdoctor result = response.readEntity(Doctolibdoctor.class);
			return result ;

	}
	
}
