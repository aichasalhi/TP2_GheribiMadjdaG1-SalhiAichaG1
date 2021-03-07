import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class EtudiantService {
	
	
	 private IEtudRep EtudRep;
	 private IUnivRep UnivRep;
	
	 public EtudiantService(IEtudRep EtudRep ,IUnivRep UnivRep) {
			super();
			this.EtudRep = EtudRep;
			this.UnivRep = UnivRep;
	  }
	 
	 
	 
	boolean inscription (Etudiant etud , int ID_univ ) throws SQLException	
	{
	    Universite univ = UnivRep.GetById(ID_univ) ;
	    System.out.println("Log: début de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());
	    
	    
	   
	    
	    if(etud.getEmail() == null || etud.getEmail().length() == 0)
	    {
	    	return false;
	    }
	    
	    if (EtudRep.Exists(etud.getMatricule()))
	    {
	        return false;
	    }
	    
	    if (EtudRep.Exists(etud.getEmail()))
	    {
	        return false;
	    }
		
		
		
		 if (univ.getPack() == TypePackage.Standard)
	     {
	          stud.setNbLivreMensuel_Autorise(10);
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 stud.setNbLivreMensuel_Autorise(10*2);
	     }                           
	     
		 StudRep.add(stud);
		 System.out.println("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());
		 return true;
	    
		
	}
	
	
	

public ArrayList<Etudiant> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}

public ArrayList<Etudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}


	
}
