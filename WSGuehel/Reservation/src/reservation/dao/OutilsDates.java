package reservation.dao;
import java.sql.Date;
import java.text.DateFormat;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
public class OutilsDates {
	public static final DateTimeFormatter FORMAT_DATE = DateTimeFormat.forPattern("yyyy-MM-dd");
	public static final String DATE_REGEX = "(\\d{4})-(\\d{2})-(\\d{2})";

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

	public static Date stringToSqlDate(String arrivee) throws Exception {
		if(valideDate(arrivee)){
		return Date.valueOf(arrivee);
		}
		else throw new Exception("le format de la date n'est pas valide");

		
	}

	public static DateTime stringToJodaDate(String arrivee) throws Exception {

		if(valideDate(arrivee)){

		
			DateTime dt = FORMAT_DATE.parseDateTime(arrivee);
			return dt;
		}else throw new Exception("le format de la date n'est pas valide");
	
	}

	public static String stringFromDateTime(DateTime start) {
		
		    String sqlTimeString = FORMAT_DATE.print(start);
		return sqlTimeString;
	}
	
	public static boolean valideDate(String date){
		boolean valide = false;
		if(date!=null)
			valide = date.matches(DATE_REGEX);
		return valide;
	}

}
