
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UniversiteRepository implements IUnivRep {
	
	private IDBConnection BDD ;
	private Statement stmt ;
	private Ijournal j ;
	

	
public UniversiteRepository(IDBConnection BDD, Ijournal j){
		this.BDD = BDD;
		this.j = j ;

	}	
	
@Override	
public Universite GetById(int universityId){
	
	
	try{
		stmt = BDD.getConn().createStatement();

		j.outPut_Msg("LogBD : début recherche de id université dans la base de donnée");
	
	String sql = "select * from universite where id_universite="+ universityId;
	ResultSet rs = stmt.executeQuery(sql);
	
	if(rs.next()){
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);
		
		j.outPut_Msg("LogBD : université récupérée");
		
		BDD.getConn().close();
		return u;
	}
	
	}catch(SQLException e){
		e.printStackTrace();
	}
	

	return null;
}


@Override
public int NbrLivreAutorise(int id_univ) {
	// TODO Auto-generated method stub
	Universite Univ =  GetById(id_univ);
	if (Univ.getPack() == TypePackage.Standard)
     {
         return 10;
     }
     else if (Univ.getPack() == TypePackage.Premium)
     {
    	 return 10*2;
    	 }     

	return 0;
}



}
