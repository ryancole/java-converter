import java.io.*;
import com.aspose.cells.*;

// java -cp '.:lib/*:' Converter

public class Converter {

	public static void main(String[] args) throws Exception {
		
		// store parameters
		String input_file = args[0];
		
		System.out.println("Processing " + input_file);
		
		// open workbook
		Workbook workbook = new Workbook(args[0]);
		
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