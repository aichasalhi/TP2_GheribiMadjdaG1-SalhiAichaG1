
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UniversiteRepository implements IUnivRep {
	
	private IDBConnection BDD ;
	private Statement stmt ;
	
	
public UniversiteRepository(IDBConnection BDD){
		this.BDD = BDD;

	}	
	
@Override	
public Universite GetById(int universityId){
	
	
System.out.println("LogBD : d�but recherche de id universit� dans la base de donn�e");	
		
String sql = "select * from universite where id_universite="+ universityId;
ResultSet rs = stmt.executeQuery(sql);
    if(rs.next()){
    	TypePackage p=TypePackage.valueOf(rs.getString(3));
	   Universite u = new Universite (rs.getInt(1),rs.getString(2),p);

       System.out.println("LogBD : universit� r�cup�r�e");
       BDD.getConn().close();
       return u;
    }
		
	}catch(SQLException e){
	e.printStackTrace();
	}
      return null;
}
}
