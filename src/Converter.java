
import java.io.*;
import java.util.*;

import managers.file.RoutingManager;
import managers.database.MongoManager;


public class Converter {

	public static void main(String[] args) throws Exception {
		
		Properties p = System.getProperties();
		Enumeration keys = p.keys();
		
		while (keys.hasMoreElements()) {
			String key = (String)keys.nextElement();
			String value = (String)p.get(key);
			System.out.println(key + ": " + value);
		}
		
		if (args.length == 1) {
			
			// store the file id
			String file_id = args[0];
			
			if (file_id.length() > 0) {
				
				MongoManager m = new MongoManager();
				
				// get the requested file's binary data
				byte[] file_data_native = m.GetFile(file_id);
				
				// feed the data to the document converter
				RoutingManager r = new RoutingManager(file_data_native);
				
				// get the pdf binary data
				byte[] file_data_pdf = r.GetPDF();
				
				// put the pdf data into the database
				m.PutFile(file_data_pdf);
				
			}
			
		}
		
	}

}