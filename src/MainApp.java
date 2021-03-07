import java.sql.SQLException;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InterfaceDBConnexion conn = DBConnection.getInstance();
		Etudiant etudiant0 =new Etudiant(2, "Guendouziiiii", "wassila", "guen@gmail.com","xxxx",1);
		InterfaceEtudiantRepository ETUDUNIVR = new EtudiantRepository(conn);
		InterfaceUniversiteRepository UnivRep = new UniversiteRepository(conn);
		EtudiantService serv = new EtudiantService(ETUDUNIVR ,UnivRep);
		try {
			serv.inscription(2, "Guendouziiiii", "wassila", "guen@gmail.com","xxxx", 1);
			serv.inscription(etudiant0, 1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
