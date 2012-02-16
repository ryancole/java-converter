
package managers.file;


import java.io.*;
import com.aspose.cells.*;


public class ExcelManager {
	
	private ByteArrayInputStream m_file_stream;
	
	public ExcelManager(ByteArrayInputStream file_stream) throws Exception {
		
		this.m_file_stream = file_stream;
		
	}
	
	public ByteArrayOutputStream GetPDF() throws Exception {
		
		// open workbook
		Workbook workbook = new Workbook(this.m_file_stream);
		
		// get all of the worksheets
		WorksheetCollection worksheets = workbook.getWorksheets();
		
		// print all sheet names
		for (int x = 0; x < worksheets.getCount(); x++) {
			
			// get worksheet object
			Worksheet worksheet = worksheets.get(x);
			
			// print worksheet name
			System.out.println(worksheet.getName());
			
		}
		
		// save pdf to byte array stream
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		workbook.save(output, FileFormatType.PDF);
		
		return output;
	}
	
}