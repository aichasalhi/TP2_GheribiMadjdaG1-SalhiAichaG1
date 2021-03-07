import java.util.List;

import java.util.ArrayList;

public class Composite implements Ijournal{
	
	private List<Ijournal>journals = new ArrayList<Ijournal>();


	@Override
  public void outPut_Msg(String message) {


		for(Ijournal j : journals){
			j.outPut_Msg(message);
		}
	}

  public void add(Ijournal journal){
		journals.add(journal);
	}

  public void remove(Ijournal journal){
		journals.remove(journal);
	}

}
