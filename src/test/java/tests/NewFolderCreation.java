package tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewFolderCreation {

	public static void main(String[] args) {
	
		//    D:\FLM2ndJuneWS\GoRestAPIFramework\reports
		
		System.out.println(System.getProperty("user.dir"));
		
		Date d=new Date();
		
		System.out.println(d);
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		date=date.replace(":", "-");
		System.out.println(date);

	}

}
