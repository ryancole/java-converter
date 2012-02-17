
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
	
	public MongoManager() throws Exception {
		
		this.m_connection = new Mongo("127.0.0.1");
		this.m_database = m_connection.getDB("litigance");
		this.m_collection = new GridFS(m_database);
		
	}
	
	public byte[] GetFile(String file_id) throws Exception {
		
		// get the file from the database
		GridFSDBFile f = this.m_collection.findOne(new ObjectId(file_id));
		return IOUtils.toByteArray(f.getInputStream());
		
	}

	public void PutFile(byte[] pdf_data) throws Exception {
		
		// GridFSInputFile write_stream = this.m_collection.createFile(pdf_data);
		// write_stream.setFilenae("what.pdf");
		// write_stream.save();
		
		System.out.println(pdf_data);

	}

}