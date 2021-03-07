import java.sql.SQLException;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DBConnection conn = DBConnection.getInstance();
		Etudiant etudiant0 =new Etudiant(2, "Guendouziiiii", "wassila", "guen@gmail.com","xxxx",1);
		IEtudRep ETUDUNIVR = new EtudiantRepository(conn);
		IUnivRep UnivRep = new UniversiteRepository(conn);
		EtudiantService serv = new EtudiantService(ETUDUNIVR ,UnivRep);
		try {
			serv.inscription(2, "Guendouziiiii", "wassila", "guen@gmail.com","xxxx", 1,0,0);
			serv.inscription(etudiant0, 1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
