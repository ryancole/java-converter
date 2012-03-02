
package managers.database;


import java.io.*;

import com.mongodb.*;
import com.mongodb.gridfs.*;

import org.bson.types.ObjectId;
import org.apache.commons.io.*;


public class MongoManager {

	private Mongo m_connection;
	private GridFS m_collection;
	private GridFSDBFile m_file;
	
	public MongoManager() throws Exception {
		
		m_connection = new Mongo("127.0.0.1");
		m_collection = new GridFS(m_connection.getDB("litigance"), "documents");
		
	}
	
	public byte[] GetFile(String file_id) throws Exception {
		
		// get the file from the database
		m_file = m_collection.findOne(new ObjectId(file_id));
		
		// return file contents
		return IOUtils.toByteArray(m_file.getInputStream());
		
	}

	public ObjectId PutFile(byte[] pdf_data) throws Exception {
		
		// get database write stream
		GridFSInputFile write_stream = m_collection.createFile(pdf_data);
		
		// set document proprties and save
		write_stream.setFilename(m_file.getFilename() + ".pdf");
		write_stream.setContentType("application/pdf");
		write_stream.save();
		
		ObjectId pdf_id = new ObjectId(write_stream.getId().toString());
		
		// update native file record to include this new pdf id
		DBObject metadata = m_file.getMetaData();
		metadata.put("pdf", pdf_id);
		
		// save the meta data with the file record
		m_file.put("metadata", metadata);
		m_file.save();
		
		return pdf_id;

	}

}