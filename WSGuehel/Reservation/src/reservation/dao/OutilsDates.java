package reservation.dao;
import java.sql.Date;
import java.text.DateFormat;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
public class OutilsDates {

	public static Date jodaToSqlDate(DateTime joda){
		java.util.Date jDate = joda.toDate();
		return new Date(jDate.getTime());
	}

	public static Interval toJodaInterval(Date sqlDate, int days){
		//TODO 
		Interval interval = null;
		return interval;
	}

	public static boolean CompareInterval(Interval int1, Interval int2){
		if(int1 == null || int2 == null)return false;
		
		 boolean egalite =  int1.contains(int2.getEnd()) || int1.contains(int2.getStart()) ;
		return egalite;
	}

	public static int CompareEntreInterval(Interval int1, Interval int2){

		return (int) (int1.getStartMillis()- int2.getStartMillis())/6000;
	}

	public static Date stringToSqlDate(String arrivee) {

		//TODO: regex
		//if(arrivee.matches("")){

			if(true){
			Date dt =jodaToSqlDate(
					stringToJodaDate(arrivee)
					);
			return dt;
		}
		return null;
	}

	public static DateTime stringToJodaDate(String arrivee) {

		if(arrivee.matches("")){

			DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
			DateTime dt = formatter.parseDateTime(arrivee);
			return dt;
		}
		return null;
	}

	public static String stringFromDateTime(DateTime start) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		    String sqlTimeString = formatter.print(start);
		return sqlTimeString;
	}

}
