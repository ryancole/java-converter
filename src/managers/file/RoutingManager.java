
package managers.file;


import java.io.*;
import com.aspose.cells.*;
import managers.file.ExcelManager;


public class RoutingManager {

	private ByteArrayInputStream m_file_stream;
	
	public RoutingManager(ByteArrayInputStream file_stream) {
		
		this.m_file_stream = file_stream;
		
	}
	
	public ByteArrayOutputStream GetPDF() throws Exception {
		
		return Route();
		
	}
	
	private ByteArrayOutputStream Route() throws Exception {
		
		// proof of concept with excel only
		ExcelManager x = new ExcelManager(this.m_file_stream);
		
		ByteArrayOutputStream pdf_stream = x.GetPDF();
		
		return pdf_stream;
		
	}

}