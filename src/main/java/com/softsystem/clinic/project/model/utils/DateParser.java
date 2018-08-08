package com.softsystem.clinic.project.model.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
	
	public static Timestamp StringToDate(String s) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(s);

		return new java.sql.Timestamp((date).getTime());
	}

}
