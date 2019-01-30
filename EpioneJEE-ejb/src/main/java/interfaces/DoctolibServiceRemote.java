package interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.Doctolibdoctor;
import model.User;

@Remote
public interface DoctolibServiceRemote {
	List<Doctolibdoctor> listDoctors(String speciality, String location, String page );
	Doctolibdoctor showDoctor(String link );
	String search(String search);
	List<Doctolibdoctor>  filterwithAvaibility(String speciality, String location,String time);
	List<Doctolibdoctor> listDoctorFiltred(String speciality, String location, String availabilities );
	List<Doctolibdoctor> listDoctorsFiltred(String speciality, String location, String availabilities );
	 User getUserByMail(String mail);
	 User getUserByEmail(String mail);
}
