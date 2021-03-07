import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class EtudiantService implements IEtudServ  {
	
	
	 private IEtudRep EtudRep;
	 private IUnivRep UnivRep;
	
	 public EtudiantService(IEtudRep EtudRep ,IUnivRep UnivRep) {
			super();
			this.EtudRep = EtudRep;
			this.UnivRep = UnivRep;
		
	  }
	 
	 public  void ajouterbonus(InterfaceEtudiant Et) {

		    InterfaceUniversity univ = UnivRep.GetById(Et.getId_universite());

			if(univ.getPack() == TypePackage.Standard) {

				Et.bonus(5);
			}

			else {
					if(univ.getPack()== TypePackage.Premium) {
						Et.bonus(10);

					}
		 }
	 
	boolean inscription (Etudiant etud , int ID_univ ) throws SQLException	
	{
	    Universite univ = UnivRep.GetById(ID_univ) ;
	    System.out.println("Log: début de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());
	    
	    
	  
	    
	    if(EtudRep.Existe_Email_Matricule(etud.getMatricule(), etud.getEmail())){
  			return false;
  		} 
		
	    int nbrlivreAutorisé = UnivRep.NbrLivreAutorise(ID_univ);
		   etud.setNbLivreMensuel_Autorise(nbrlivreAutorisé);
		
		 StudRep.add(stud);
		 System.out.println("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());
		 return true;
	    
		
	}
	
	
	

public ArrayList<IEtud> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}

public ArrayList<IEtud> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}
@Override
public boolean inscription (IEtud etud) {
	// TODO Auto-generated method stub
	return false;
}


	
}
