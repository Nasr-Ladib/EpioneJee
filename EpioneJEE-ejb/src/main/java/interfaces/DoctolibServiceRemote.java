package interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.Doctolibdoctor;

@Remote
public interface DoctolibServiceRemote {
	List<Doctolibdoctor> listDoctors(String speciality, String location, String page );
	Doctolibdoctor showDoctor(String link );
}
