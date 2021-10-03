package db.executer;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.connection.DBConnectionData;
import db.connection.NoConnectionException;
/**
 * Executes DDL Statements - Stateless!
 */
public class DBDDLExecuter implements PersistenceDDLExecuter {
	private DDLStatementTextCreator ddl;
	private DMLStatementTextCreator dml;
	private DBConnectionManager mgr;
	protected DBDDLExecuter() {
		super();
		this.mgr = DBConnectionManager.getTheInstance();
		this.ddl = new DDLStatementTextCreator();
		this.dml = new DMLStatementTextCreator();
	}
	@Override
	public void openDBConnection(DBConnectionData connectionData) throws ClassNotFoundException, SQLException, NoConnectionException {
		mgr.openDBConnection(connectionData);
	}
/**	
 * Extends the given connection to a concrete database with name <servicename>
 */
	@Override
	public void establishConnectionToDatabase(String servicename) throws ClassNotFoundException, SQLException, NoConnectionException {
		mgr.openDBConnection(this.extendWithServiceName(mgr.getConnectionData().get(), servicename));
	}
	@Override
	public void closeConnection() throws SQLException {
		this.mgr.close();
	}
	@Override
	public void createDatabase(String servicename) throws SQLException, NoConnectionException {
		stmt().executeUpdate(ddl.createDatabase(servicename));
	}
	@Override
	public void createClassTable(String servicename, String classname, String attributeList) throws SQLException, NoConnectionException {
		stmt().executeUpdate(ddl.createClassTable(servicename, classname, attributeList));
	}
	@Override
	public void createRelationTable(String associationName, String p1Type, String p2Type) throws SQLException, NoConnectionException {
		stmt().executeUpdate(ddl.createRelationTable(associationName, p1Type, p2Type));
	}
	@Override
	public void createTypeKeyTable(String servicename) throws SQLException, NoConnectionException {
		stmt().executeUpdate(ddl.createTypeKeyTable(servicename));
	}
	@Override
	public void createTypeKeyTableEntry(String servicename, String relName) throws SQLException, NoConnectionException {
		stmt().executeUpdate(dml.createTypeKeyTableEntry(servicename, mgr.getNextId(), relName));
	}
	@Override
	public boolean typeKeyTableExists(String servicename) throws SQLException, NoConnectionException {
		return stmt().executeQuery(dml.existsTypeKeysTableIn(servicename)).next();
	}
	public boolean tableExists(String tableName) throws SQLException, NoConnectionException {
		return stmt().executeQuery(dml.existsTable(tableName)).next();
	}
	public void dropDatabase(DBConnectionData connectionData) throws PersistenceException{
		DBConnectionData connectionDataToRoot = new DBConnectionData(connectionData.getUrl(), connectionData.getUser(), connectionData.getPassword());
		String databaseName = connectionData.getDatabaseName();
		try {
			this.openDBConnection(connectionDataToRoot); // Opens DB Connection to root of all databases
			if(databaseExists(databaseName)) stmt().executeUpdate(ddl.dropDatabase(databaseName));
			mgr.close();
		}catch(NoConnectionException | SQLException | ClassNotFoundException nce) {
			throw new PersistenceException(nce.getMessage() + ". No connection possible to database " + databaseName + ". URL = " + connectionDataToRoot.getUrl() + ". User = " + connectionDataToRoot.getUser());
		}
	}

// ====================== Auxiliaries ===============================	
	private DBConnectionData extendWithServiceName(DBConnectionData current, String serviceName) {
		return new DBConnectionData(current.getUrl(), serviceName, current.getUser(), current.getPassword());
	}
	private Statement stmt() throws SQLException, NoConnectionException {
		return mgr.get().createStatement();
	}
	private boolean databaseExists(String databaseName) throws SQLException, NoConnectionException {
		return stmt().executeQuery(ddl.dataBaseExists(databaseName)).next();
	}
}
