package Roughwork;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class DateFunction {

	public static void main(String[] args) {
	
		GregorianCalendar gc = (GregorianCalendar)GregorianCalendar.getInstance();
		System.out.println(gc.get(GregorianCalendar.MONTH)+1);
		System.out.println(gc.get(GregorianCalendar.DAY_OF_MONTH));
		System.out.println(gc.get(GregorianCalendar.DATE));	
	}

}
