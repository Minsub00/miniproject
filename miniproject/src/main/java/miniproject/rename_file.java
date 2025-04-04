package miniproject;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository("rename_file")
public class rename_file {	
	public String rename(String filename) {
		int com = filename.lastIndexOf(".");
		String fnm = filename.substring(com);
		

		Date day = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String today = sf.format(day);
		
		int no = (int)Math.ceil(Math.random() * 1000);
		String makefile = today + no + fnm;
		
		return makefile;
	}
}
