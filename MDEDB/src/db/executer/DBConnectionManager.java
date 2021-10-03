package db.executer;
/**
 * Connection to the database. 
 * This object runs through 3 states: 
 * 1. No connection data present 
 * -> Establish connection with data d1 -> openDBConnection(d1)
 * 2. Connection data to mySQL before database for this service is known
 * -> Create Database for the service if not already present, d2:=enhance d1 with database name = service name
 * 3. Connection d2 to database fully established 
 * 
 * Most of the operations are protected, i.e. not visible from the generated code - all DB actions run through interfaces PersistenceD_LExecuter
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import db.connection.DBConnectionData;
import db.connection.NoConnectionException;
public class DBConnectionManager {
	private Optional<DBConnectionData> connectionData;
	private Connection currentConnection;
	private Optional<ObjectSequencer> sequencer;
	private static DBConnectionManager instance = new DBConnectionManager();
	private DBConnectionManager() {
		this.connectionData = Optional.empty();
		this.sequencer = Optional.empty();
	}
/**
 * Creates the java.sql.Connection-object possibly only for the root of all databases (if no database name is provided)
 * Initializes the sequencer, if database name is provided
 */
	protected void openDBConnection(DBConnectionData connectionData) throws SQLException, ClassNotFoundException, NoConnectionException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connectionData = Optional.of(connectionData);
		currentConnection = DriverManager.getConnection(connectionData.getUrl() + "/" + connectionData.getDatabaseName(), connectionData.getUser(), connectionData.getPassword());
		if(connectionData.isDatabaseNamePresent()) this.initializeSequencing(connectionData.getDatabaseName());
	}
/**	
 * public for test purposes
 */
	public Connection get() throws NoConnectionException{
		if(this.connectionData.isPresent()) return this.currentConnection;
		else 								throw new NoConnectionException("No Database Connection Data provided!");
	}
	protected Integer getNextId() throws NoConnectionException, SQLException{
		if(this.sequencer.isPresent()) return this.sequencer.get().getNextValue();
		else 						   throw new NoConnectionException("Not connected to a database!");	
	}
	protected void close() throws SQLException {
		this.currentConnection.close();
	}
	public Optional<DBConnectionData> getConnectionData() {
		return this.connectionData;
	}
/**
 * Checks existence of service table and single entry - if not creates it
 * Creates the sequencer representation afterwards
 */
	private void initializeSequencing(String databaseName) throws NoConnectionException, SQLException {
		Statement s;
		try {
			s = currentConnection.createStatement();
			s.executeUpdate(new DDLStatementTextCreator().createServiceTable(databaseName)); //Exception, if already existing with one entry with id = 1 and sequencerValue
			s.executeUpdate(new DMLStatementTextCreator().createTheServiceTableEntry(databaseName));
		} catch (SQLException e) {// ok
		}
		this.sequencer = Optional.of(new ObjectSequencer(databaseName));
	}

	public static DBConnectionManager getTheInstance() {return instance;}
}
