
package managers.file;


import java.io.*;
import com.aspose.cells.*;


public class ExcelManager {
	
	private License m_license;
	private ByteArrayInputStream m_file_data_native;
	
	public ExcelManager(ByteArrayInputStream file_data_native) throws Exception {
		
		// store input file data
		this.m_file_data_native = file_data_native;
		
		// set aspose license
		FileInputStream license_stream = new FileInputStream("Aspose.Total.Java.lic");
		m_license = new License();
		m_license.setLicense(license_stream);
		
	}
	
	public byte[] GetPDF() throws Exception {
		
		// open workbook
		Workbook workbook = new Workbook(this.m_file_data_native);
		
		// set font path
		CellsHelper.setFontDir("/usr/share/fonts/truetype/msttcorefonts");
		
		// get all of the worksheets
		WorksheetCollection worksheets = workbook.getWorksheets();
		
		// print all sheet names
		for (int x = 0; x < worksheets.getCount(); x++) {
			
			// get worksheet object
			Worksheet worksheet = worksheets.get(x);
			
			// make this worksheet visible
			worksheet.setVisible(true);
			
			// auto fit columns
			worksheet.autoFitColumns();
			
			// page setup options
			PageSetup pagesetup = worksheet.getPageSetup();
			
			pagesetup.setFitToPagesWide(1);
			
		}
		
		// save pdf to byte array stream
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		workbook.save(output, FileFormatType.PDF);
		
		return output.toByteArray();
	}
	
}