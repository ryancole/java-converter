
package managers.file;


import java.io.*;
import com.aspose.cells.*;


public class ExcelManager {
	
	private ByteArrayInputStream m_file_data_native;
	
	public ExcelManager(ByteArrayInputStream file_data_native) throws Exception {
		
		this.m_file_data_native = file_data_native;
		
	}
	
	public byte[] GetPDF() throws Exception {
		
		// open workbook
		Workbook workbook = new Workbook(this.m_file_data_native);
		
		// set font path
		// workbook.getSaveOptions().setFontPath(new String[]{ "/usr/share/fonts/truetype/msttcorefonts" });
		
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
		
		return output.toByteArray();
	}
	
}