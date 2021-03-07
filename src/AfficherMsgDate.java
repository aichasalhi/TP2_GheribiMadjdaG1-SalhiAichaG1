import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AfficherMsgDate implements Ijournal{
	
	@Override
	public void outPut_Msg(String message) {


		Date Actuel = new Date (0);

		DateFormat dateformat = new SimpleDateFormat("yyyy//MM/dd HH:mm:s");

		String date = dateformat.format(Actuel);

		System.out.println(message);

		System.out.println(date);



	}

}
