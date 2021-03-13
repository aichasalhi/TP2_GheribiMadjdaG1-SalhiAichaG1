import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public abstract class EtudiantService implements IEtudServ  {
	
	
	 private IEtudRep EtudRep;
	 private IUnivRep UnivRep;
	 private Ijournal j ;
	 
	 public EtudiantService(IEtudRep EtudRep ,IUnivRep UnivRep, Ijournal j) {
			super();
			this.EtudRep = EtudRep;
			this.UnivRep = UnivRep;
			this.j = j;
	  }
	 
	 public  void ajouterbonus(IEtud Et) {

		    IUniv univ = UnivRep.GetById(Et.getId_universite());

		    Package p = new Standard(null);
			Et.bonus(p.getNbrLivreBonus());
		
			}

		 
	 
	boolean inscription (Etudiant etud , int ID_univ ) throws SQLException	
	{
	    Universite univ = UnivRep.GetById(ID_univ) ;
	    j.outPut_Msg("Log: début de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());
	    
	    
	    if(EtudRep.Existe_Email_Matricule(etud.getMatricule(), etud.getEmail())){
  			return false;
  		} 
		
	    int nbrlivreAutorisé = UnivRep.NbrLivreAutorise(ID_univ);
		   etud.setNbLivreMensuel_Autorise(nbrlivreAutorisé);
		
		   EtudRep.add(etud);
			 j.outPut_Msg("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+etud.getMatricule());
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
