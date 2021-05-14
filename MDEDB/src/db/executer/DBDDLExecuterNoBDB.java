package db.executer;

import java.sql.SQLException;

import db.connection.DBConnectionData;
import db.connection.NoConnectionException;
/**
 * In "No DB" mode these operations do nothing
 */
public class DBDDLExecuterNoBDB implements PersistenceDDLExecuter {
	protected DBDDLExecuterNoBDB() {}
	
	public void openDBConnection(DBConnectionData connectionData){}
	public void establishConnectionToDatabase(String servicename){}
	public void closeConnection() throws SQLException {}
	public void createDatabase(String servicename){}
	public void createClassTable(String servicename, String classname, String attributeList){}
	public void createRelationTable(String associationName, String p1Type, String p2Type){}
	public void createTypeKeyTable(String servicename){}
	public void createTypeKeyTableEntry(String servicename, String relName){}
	public boolean typeKeyTableExists(String servicename) throws SQLException, NoConnectionException {return false;}
	public boolean tableExists(String tableName) throws SQLException, NoConnectionException {return false;}
	public void dropDatabase(DBConnectionData connectionData) {}
}
