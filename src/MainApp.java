import java.sql.SQLException;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DBConnection conn = DBConnection.getInstance();
		Composite comp = new Composite();
		Etudiant etudiant0 =new Etudiant(2, "Guendouziiiii", "wassila", "guen@gmail.com","xxxx",1);
		
		IEtudRep ETUDUNIVR = new EtudiantRepository(conn, comp);
		IUnivRep UnivRep = new UniversiteRepository(conn, comp);
		EtudiantService serv = new EtudiantService(ETUDUNIVR ,UnivRep, comp);
		try {
			serv.inscription(etudiant0, 1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
