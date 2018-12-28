package services;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import interfaces.DoctolibServiceRemote;
import model.Doctolibdoctor;

public class DoctolibService implements DoctolibServiceRemote {

	//*********************************** Lister Tous les Docteurs Suivant speciality , location , page ****************************************
	public List<Doctolibdoctor> listDoctors(String speciality, String location, String page ){

		Client client =ClientBuilder.newClient();
		WebTarget target =client.target("http://localhost:15248/api/doctolib?speciality=&location=&page=");
		//WebTarget link=target.queryParam("medecin-generaliste/callian/alexandre-belo");
		Response response =target.request().get();
		Doctolibdoctor[] result = response.readEntity(Doctolibdoctor[].class);
	//	Gson j = new Gson();
	//	ObjectMapper mapper = new ObjectMapper();
	//	List<Doctolibdoctor> doctors= new ArrayList();
	//	doctors=j.fromJson(result,new TypeToken<List<Doctolibdoctor>>(){}.getType());
		List<Doctolibdoctor> doctors = new ArrayList<>();
		for(int i=0; i<result.length;i++){
			doctors.add(result[i]);
		}
		return doctors ;
}

	//*********************************** Afficher  Docteurs Suivant speciality , location , page ****************************************
	public Doctolibdoctor showDoctor(String link ){

		Client client =ClientBuilder.newClient();
		WebTarget target =client.target("http://localhost:15248/api/doctolibdoctor?link="+link+"");
		//WebTarget link=target.queryParam("medecin-generaliste/callian/alexandre-belo");
		Response response =target.request().get();
		Doctolibdoctor result = response.readEntity(Doctolibdoctor.class);
//		Gson j = new Gson();
//		ObjectMapper mapper = new ObjectMapper();
//		Doctolibdoctor doctors= new Doctolibdoctor();
//		doctors=j.fromJson(result,new TypeToken<Doctolibdoctor>(){}.getType());
		
		return result ;
}
	
	
}
