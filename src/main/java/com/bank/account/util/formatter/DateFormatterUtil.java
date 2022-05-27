package com.bank.account.util.formatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
*
* @author Yogya Hewavidana
*
*/
public class DateFormatterUtil {

	public static String dateOnly(Date date) {
		// entity created date is a not null field. so no need to check null.but in rel application when using
		// as a commin method better check null
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(date);
	}

}
