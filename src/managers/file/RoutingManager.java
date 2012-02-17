
package managers.file;


import java.io.*;
import com.aspose.cells.*;
import managers.file.ExcelManager;


public class RoutingManager {

	private byte[] m_file_data_native;
	
	public RoutingManager(byte[] file_data_native) {
		
		this.m_file_data_native = file_data_native;
		
	}
	
	public byte[] GetPDF() throws Exception {
		
		return Route();
		
	}
	
	private byte[] Route() throws Exception {
		
		// move the file data into an input stream
		ByteArrayInputStream file_stream = new ByteArrayInputStream(this.m_file_data_native);
		
		// proof of concept with excel only
		ExcelManager x = new ExcelManager(file_stream);
		return x.GetPDF();
		
	}

}