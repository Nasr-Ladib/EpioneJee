package services;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.print.Doc;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import interfaces.DoctolibServiceRemote;
import model.Doctolibdoctor;
import model.User;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Stateless
@LocalBean
public class DoctolibService implements DoctolibServiceRemote {

	@PersistenceContext(unitName="EpioneJEE-ejb")
	private EntityManager em;
	@Override
	public User getUserByEmail(String mail){
		
		TypedQuery<User> query = em.createQuery("SELECT User FROM User u where u.email =: '"+mail+"'", User.class);
		 User user = query.getSingleResult();
		System.out.println(user);
		
		return user;
	}
	
	//*********************************** Lister Tous les Docteurs Suivant speciality , location , page ****************************************
	@Override
	public List<Doctolibdoctor> listDoctors(String speciality, String location, String page ){

		Client client =ClientBuilder.newClient();
		WebTarget target =client.target("http://localhost:42728/api/doctolib?speciality="+speciality+"&location="+location+"&page="+page);
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
	@Override
	public Doctolibdoctor showDoctor(String link ){

		Client client =ClientBuilder.newClient();
		WebTarget target =client.target("http://localhost:42728/api/doctolibdoctor?link="+link+"");
		//WebTarget link=target.queryParam("medecin-generaliste/callian/alexandre-belo");
		Response response =target.request().get();
		Doctolibdoctor result = response.readEntity(Doctolibdoctor.class);
//		Gson j = new Gson();
//		ObjectMapper mapper = new ObjectMapper();
//		Doctolibdoctor doctors= new Doctolibdoctor();
//		doctors=j.fromJson(result,new TypeToken<Doctolibdoctor>(){}.getType());
		
		return result ;
}
	
	//************************************ Recherche Ajax ***********************************
	@Override
	public String search(String search){
		Client client =ClientBuilder.newClient();
		WebTarget target =client.target("https://www.doctolib.fr/api/searchbar/autocomplete.json?search="+search);
		Response response =target.request().get();
		String result = response.readEntity(String.class);

		return  result;
	}
	
	//*************************************** Filter avec la disponibilté de Doctolib **************************
	@Override
	public List<Doctolibdoctor>  filterwithAvaibility(String speciality, String location,String time){
		if (location==null)
        {
            location = "france";
        }
      
        if (speciality == null)
        {
            speciality = "medecin-generaliste";
        }
        
		String url = "https://www.doctolib.fr/"+ speciality + "/" + location + "?availabilities=" + time;
		
		Document doc;
		
		List<Doctolibdoctor> liste_doc = new ArrayList<>();
		
		
		try {
			doc = Jsoup.connect(url).userAgent(
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
					.get();

			Elements paragraphs = doc.getElementsByClass("dl-search-result-presentation");
			for (Element p : paragraphs) {

				String name = p.select(".dl-search-result-name").text();
				String adresse = p.select(".dl-text").text();
				String image = p.select("img").attr("src");
				String remboursement = p.select("div.dl-search-result-regulation-sector").text();
				String spec = p.select("div.dl-search-result-subtitle").text();
				Element link = p.select("a.dl-search-result-name").first();
				String doctolib = link.absUrl("href");

				Doctolibdoctor doctor= new Doctolibdoctor();
			

				

				liste_doc.add(doctor);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste_doc;

	}
	//*********************************** Lister Tous les Docteurs Suivant speciality , location , disponibility ****************************************
	@Override	
	public List<Doctolibdoctor> listDoctorFiltred(String speciality, String location, String availabilities ){

			Client client =ClientBuilder.newClient();
			WebTarget target =client.target("http://localhost:42728/api/doctolibfilter?speciality="+speciality+"&location="+location+"&availabilities="+availabilities);
			//WebTarget link=target.queryParam("medecin-generaliste/callian/alexandre-belo");
			Response response =target.request().get();
			String[] result = response.readEntity(String[].class);
		//	Gson j = new Gson();
		//	ObjectMapper mapper = new ObjectMapper();
		//	List<Doctolibdoctor> doctors= new ArrayList();
		//	doctors=j.fromJson(result,new TypeToken<List<Doctolibdoctor>>(){}.getType());
			String[] searchresult=result[0].split(",");
			List<Doctolibdoctor> doctors = new ArrayList<>();
			for(int i=0; i<searchresult.length;i++){
				WebTarget target2=client.target("https://www.doctolib.fr/search_results/"+searchresult[i]+".json?search_result_format=json&speciality_id="+result[1]+"&limit="+result[2]+"&availability_filter=true");
				Response response2 =target2.request().get();
				String result2 = response2.readEntity(String.class);
				System.out.println(result2);
				JsonElement root = new JsonParser().parse("["+result2+"]");
				System.out.println("*****************");
				String availabilitiesDoctor=root.getAsJsonObject().get("total").getAsString();
				if(!availabilitiesDoctor.equals("0")){
					String path = root.getAsJsonObject().get("search_result").getAsJsonObject().get("link").getAsString();
					WebTarget target3 =client.target("http://localhost:42728/api/doctolibdoctor?link="+path+"");
					//WebTarget link=target.queryParam("medecin-generaliste/callian/alexandre-belo");
					Response response3 =target3.request().get();
					Doctolibdoctor doctor = response3.readEntity(Doctolibdoctor.class);
					System.out.println(doctor);
					doctors.add(doctor);
				}
			}
			return doctors ;
	}

	@Override
	public List<Doctolibdoctor> listDoctorsFiltred(String speciality, String location, String availabilities) {
		// TODO Auto-generated method stub
		 Client client =ClientBuilder.newClient();
		WebTarget target =client.target("http://localhost:42728/api/doctolibfilter?speciality="+speciality+"&location="+location+"&availabilities="+availabilities);
		//WebTarget link=target.queryParam("medecin-generaliste/callian/alexandre-belo");
		Response response =target.request().get();
		Doctolibdoctor[] result = response.readEntity(Doctolibdoctor[].class);
		List<Doctolibdoctor> doctors = new ArrayList<>();
		for(int i=0; i<result.length;i++){
			doctors.add(result[i]);
		}
		return doctors ;
	}
	
	@Override
	public User getUserByMail(String mail){
		
		System.out.println("aliiiiiiiiiiiiiiiiis");
		//TypedQuery<User> query = em.createQuery("SELECT User FROM User u", User.class);
		// List<User> user = query.getResultList();
	//	System.out.println(user);
		User u = new User();
		if(mail.equals("nasr.ladib@esprit.tn")){
		u.setFirstName("Nasr LAdib");
		u.setAddress("Champ de Mars, 5 Avenue Anatole France, 75007 Paris, France");
		u.setBioghrapy("48.8583701");
		u.setLastName("2.2922926");
		}
		if(mail.equals("ladibnasr@gmail.com"))
		{
			u.setFirstName("Ali Ben Ali");
			u.setAddress("2 Rue de Troyes, 77390 Guignes, France");
			u.setBioghrapy("48.3056078");
			u.setLastName("1.2878085");
		}
		return u;
	}
}
