import java.io.*;
import com.aspose.cells.*;

public class Converter {

	public static void main(String[] args) throws Exception {
		
		// open workbook
		Workbook workbook = new Workbook("E:\\Documents\\Office\\Book1.xlsx");
		
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
	}

}