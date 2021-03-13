
import java.sql.SQLException;
import java.sql.Statement;

 abstract class EtudiantRepository  implements IEtudRep {
	
	private IDBConnection BDD ;
	private static Statement stmt;
	private Ijournal j;
	
	public EtudiantRepository(IDBConnection BDD, Ijournal j){
		this.BDD = BDD;
		this.j = j ;

		}	
		
	

		
		@Override
		public void add(Etudiant E){
		try {

		stmt = BDD.getConn().createStatement();
		
		String sql = "INSERT into etudiant values (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() + "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		int rs = stmt.executeUpdate(sql);
		
		if (rs == 1){
			j.outPut_Msg("log : ajout dans la BD réussi de l'étudiant  du Matricule" + E.getMatricule());
		}else if (rs == 0){
			j.outPut_Msg("log : Echec de l'ajout dans la BD de l'étudiant  du Matricule" + E.getMatricule());
			}
		BDD.getConn().close();
	 
		}catch(SQLException e){
			e.printStackTrace();
			}
}
@Override
 public	boolean Exists(String email){
	try{


		stmt = BDD.getConn().createStatement();
		String sql = "select * from etudiant where email='"+ email+"'";
		boolean rs = stmt.execute(sql);
		
		if (rs){
			System.out.println("logBD--- :email existe dans la BD  " + email);
			BDD.getConn().close();
			return true;
			}
		System.out.println("logBD--- : email n'existe pas " + email);	
		BDD.getConn().close();
	}catch(SQLException e){
		e.printStackTrace();
	}
		return false;
	}

			@Override
			public boolean Existe_Email_Matricule(int Matricule, String Email) {

				return this.Exists(Matricule) || this.Exists(Email) || Email.length() == 0 || Email == null; 

			}

	
	  
	  
	
	}




