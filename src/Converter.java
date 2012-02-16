
import java.io.*;

import managers.file.RoutingManager;
import managers.database.MongoManager;


public class Converter {

	public static void main(String[] args) throws Exception {
		
		if (args.length == 1) {
			
			// store the file id
			String file_id = args[0];
			
			if (file_id.length() > 0) {
				
				MongoManager m = new MongoManager();
				
				// get the requested file's binary data
				ByteArrayInputStream file_stream = m.GetFile(file_id);
				
				// feed the data to the document converter
				RoutingManager r = new RoutingManager(file_stream);
				
				ByteArrayOutputStream pdf_stream = r.GetPDF();
				
				System.out.println(pdf_stream);
				
			}
			
		}
		
	}

}