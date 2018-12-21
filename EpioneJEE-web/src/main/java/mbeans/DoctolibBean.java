package mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

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

	DoctolibServiceRemote doctolibservice= new DoctolibService();
	private String address;

	private MapModel simpleModel;

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

    public MapModel markers(String speciality, String location, String page) {
    	MapModel  simpleModel = new DefaultMapModel();
          for(Doctolibdoctor doc : doctolibservice.listDoctors(speciality, location, page)){
        	  LatLng coord1 = new LatLng(Double.parseDouble(doc.getLat()), Double.parseDouble(doc.getLng()));
        	  simpleModel.addOverlay(new Marker(coord1, doc.getAddress()));
          }
       return simpleModel;
    }
  
    public MapModel getSimpleModel() {
        return simpleModel;
    }

	public List<Doctolibdoctor> listDoctors(String speciality, String location, String page){

	return	doctolibservice.listDoctors(speciality, location, page);
		
	}
	
	public Doctolibdoctor showDoctors(String link){

		return	doctolibservice.showDoctor(link);
			
		}
	
}
