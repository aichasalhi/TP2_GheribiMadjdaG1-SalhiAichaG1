
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EtudiantRepository  implements IEtudRep {
	
	private IDBConnexion BDD ;
	private static Statement stmt;
	
	public EtudiantRepository(InterfaceDBConnexion BDD){
		this.BDD = BDD;
		}	
		
	
<<<<<<< HEAD
		DBConnection BD= new DBConnection();
=======
	void add(Etudiant E) throws SQLException
	{

		DBConnection BD=DBConnection.getInstance();
>>>>>>> 71d539716fa6d574752e6e615c3bf7d662c0ecc5
		Connection connect=BD.getConn();
		
		@Override
		public void add(Etudiant E){
		try {

		stmt = BDD.getConn().createStatement();
		
		String sql = "INSERT into etudiant values (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() + "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		int rs = stmt.executeUpdate(sql);
		
		if (rs == 1){
				System.out.println("log : ajout dans la BD réussi de l'étudiant  du Matricule" + E.getMatricule());
			}else if (rs == 0){
				System.out.println("log : Echec de l'ajout dans la BD de l'étudiant  du Matricule" + E.getMatricule());
			}
		BDD.getConn().close();
	 
		}catch(SQLException e){
			e.printStackTrace();
			}
}
@Override
 public	boolean Exists(String email){
	try{

<<<<<<< HEAD
		stmt = BDD.getConn().createStatement();
=======
	boolean Exists(String email) throws SQLException	
	{
		DBConnection BD=DBConnection.getInstance();
		Connection connect=BD.getConn();
		
		Statement stmt = connect.createStatement();
>>>>>>> 71d539716fa6d574752e6e615c3bf7d662c0ecc5
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
	public boolean Exists(int mat) 	
	{
<<<<<<< HEAD
	  try {	
			stmt = BDD.getConn().createStatement();
			String sql = "select * from etudiant where matricule="+ mat;
			boolean rs = stmt.execute(sql);

			if (rs){
				System.out.println("logBD--- :etudiant avec ce matricule existe déja dans la BD  " + mat);
				BDD.getConn().close();
				return true;
				}
			System.out.println("logBD----: etudiant avec ce matricule n'existe pas " + mat);	
			BDD.getConn().close();

			}catch(SQLException e){
				e.printStackTrace();
=======
		DBConnection BD=DBConnection.getInstance();
		Connection connect=BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where matricule="+ mat;
		boolean rs = stmt.execute(sql);
		
		if (rs){
			System.out.println("logBD--- :etudiant avec ce matricule existe déja dans la BD  " + mat);
			connect.close();
			return true;
>>>>>>> 71d539716fa6d574752e6e615c3bf7d662c0ecc5
			}
			return false;
			
		
	  
	  
	
	}

}
