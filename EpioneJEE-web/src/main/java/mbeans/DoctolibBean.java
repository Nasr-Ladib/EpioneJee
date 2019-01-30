package mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.servlet.annotation.WebServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.sun.org.apache.bcel.internal.generic.RET;

import interfaces.DoctolibServiceRemote;
import model.*;
import services.DoctolibService;

@ManagedBean
public class DoctolibBean implements Serializable{

	@EJB
	DoctolibService doctolibservice;
	private String address;

	private MapModel simpleModel;

	private String img;

	private String name;

	private String path;

	private String speciality;
	
	private static Doctolibdoctor doctolib;
	
	private static User user;

    
	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		DoctolibBean.user = user;
	}

	public Doctolibdoctor getDoctolib() {
		return doctolib;
	}

	public void setDoctolib(Doctolibdoctor doctolib) {
		this.doctolib = doctolib;
	}

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

    public MapModel markers(String speciality, String location, String page) {
    	MapModel  simpleModel = new DefaultMapModel();
          for(Doctolibdoctor doc : doctolibservice.listDoctors(speciality, location, page)){
        	  LatLng coord1 = new LatLng(Double.parseDouble(doc.getLat()), Double.parseDouble(doc.getLng()));
        	  simpleModel.addOverlay(new Marker(coord1, doc.getAddress()));
          }
       return simpleModel;
    }
    public MapModel markersFilter(String speciality, String location, String availabilities) {
    	MapModel  simpleModel = new DefaultMapModel();
          for(Doctolibdoctor doc : doctolibservice.listDoctorFiltred(speciality, location, availabilities)){
        	  LatLng coord1 = new LatLng(Double.parseDouble(doc.getLat()), Double.parseDouble(doc.getLng()));
        	  simpleModel.addOverlay(new Marker(coord1, doc.getPath()));
          }
       return simpleModel;
    }
    public MapModel marker(String link) {
    	MapModel  simpleModel = new DefaultMapModel();
          Doctolibdoctor doc = doctolibservice.showDoctor(link);
        	  LatLng coord1 = new LatLng(Double.parseDouble(doc.getLat()), Double.parseDouble(doc.getLng()));
        	  simpleModel.addOverlay(new Marker(coord1, doc.getAddress()));
          
       return simpleModel;
    }
    public MapModel getSimpleModel() {
        return simpleModel;
    }

	public List<Doctolibdoctor> listDoctors(String speciality, String location, String page){

	return	doctolibservice.listDoctors(speciality, location, page);
		
	}

	public String search(String search){
		System.out.println(doctolibservice.search(search));
		return  doctolibservice.search(search);
	}
	
	public Doctolibdoctor showDoctors(String link){
		return	doctolibservice.showDoctor(link);
		}
	public List<Doctolibdoctor> listDoctorsFiltred(String speciality, String location, String availabilities){
		
			return doctolibservice.listDoctorsFiltred(speciality, location, availabilities);
		}
	public String login(){
		System.out.println(address);
		user=doctolibservice.getUserByMail(address);
		if(user.getAddress()==null){
			return "/DoctolibPages/login.jsf";
		}
		return "/DoctolibPages/list.jsf?faces-redirect=true";
	}
	
	public String logout(){
		user.setAddress(null);
		return "/DoctolibPages/login.jsf?faces-redirect=true";
		
	}
	
	public String lat(){
		System.out.println(user);
		return user.getBioghrapy();
	} 
	
	public String lng(){
		System.out.println(user);
		return user.getLastName();
	} 
}
