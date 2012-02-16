
package managers.database;


import java.io.*;

import com.mongodb.*;
import com.mongodb.gridfs.*;

import org.bson.types.ObjectId;


public class MongoManager {

	private Mongo m_connection;
	private DB m_database;
	private GridFS m_collection;
	
	public MongoManager() throws Exception {
		
		this.m_connection = new Mongo("127.0.0.1");
		this.m_database = m_connection.getDB("litigance");
		this.m_collection = new GridFS(m_database, "fs");
		
	}
	
	public ByteArrayInputStream GetFile(String file_id) throws Exception {
		
		ByteArrayOutputStream write_stream = new ByteArrayOutputStream();
		
		// get the file from the database
		GridFSDBFile f = this.m_collection.findOne(new ObjectId(file_id));
		
		// write the file's data to a byte stream
		f.writeTo(write_stream);
		
		// conver the output stream to an input stream for reading
		ByteArrayInputStream read_stream = new ByteArrayInputStream(((ByteArrayOutputStream) write_stream).toByteArray());
		
		return read_stream;
		
	}

}