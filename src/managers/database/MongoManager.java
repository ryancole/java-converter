
package managers.database;


import java.io.*;

import com.mongodb.*;
import com.mongodb.gridfs.*;

import org.bson.types.ObjectId;
import org.apache.commons.io.*;


public class MongoManager {

	private Mongo m_connection;
	private DB m_database;
	private GridFS m_collection;
	private String m_filename;
	
	public MongoManager() throws Exception {
		
		this.m_connection = new Mongo("127.0.0.1");
		this.m_database = m_connection.getDB("litigance");
		this.m_collection = new GridFS(m_database);
		
	}
	
	public byte[] GetFile(String file_id) throws Exception {
		
		// get the file from the database
		GridFSDBFile f = this.m_collection.findOne(new ObjectId(file_id));
		
		// stores the filename
		this.m_filename = f.getFilename();
		
		// return file contents
		return IOUtils.toByteArray(f.getInputStream());
		
	}

	public ObjectId PutFile(byte[] pdf_data) throws Exception {
		
		// get database write stream
		GridFSInputFile write_stream = this.m_collection.createFile(pdf_data);
		
		// set filename and save
		write_stream.setFilename(this.m_filename + ".pdf");
		write_stream.save();
		
		// return new objectid
		return new ObjectId(write_stream.getId().toString());

	}

}