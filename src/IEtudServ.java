import java.util.ArrayList;
public interface IEtudServ {
	public boolean inscription (IEtud etud);

	public ArrayList<IEtud> GetEtudiantParUniversitye();

	public ArrayList<IEtud> GetEtudiatparLivreEmprunte();
	public  void ajouterbonus(IEtud Et);
}
