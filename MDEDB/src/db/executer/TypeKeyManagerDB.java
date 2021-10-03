package db.executer;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import db.connection.NoConnectionException;

/**
 * A mirror of the contents of the type key table for a given Service
 */
public class TypeKeyManagerDB implements TypeKeyManagerInterface {
	private PersistenceDMLExecuter dmlExecuter; 
	private Map<String, Map<Integer, String>> typeKeys;  // A mapping typeKey->typeName for each key = serviceName
	private static final TypeKeyManagerInterface theInstance = new TypeKeyManagerDB();
	private TypeKeyManagerDB() {
		this.dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
		this.typeKeys = new HashMap<>();
	}
	protected static TypeKeyManagerInterface getTheInstance() {return theInstance;}
	public void initializeFor(String serviceName) {
		try {
			Optional<ResultSet> rs = this.dmlExecuter.selectAllEntriesOfTypeKeyTable(serviceName);
			if(rs.isEmpty()) return; // No type keys, if DB is not in operation
			while(rs.get().next()) this.put(serviceName, rs.get().getInt(1), rs.get().getString(2));
		}catch(SQLException | NoConnectionException se) {
			assert false : "Fatal Error: Could not initialize type keys";
		}
	}
	private void put(String serviceName, Integer key, String value) {
		if(!this.typeKeys.containsKey(serviceName)) this.typeKeys.put(serviceName, new HashMap<Integer, String>());
		this.typeKeys.get(serviceName).put(key, value);
	}
	public String getTypeName(String serviceName, Integer key) {
		assert this.typeKeys.containsKey(serviceName) : "Type Keys for service " + serviceName + " not loaded!";
		return this.typeKeys.get(serviceName).get(key);
	}
	public Integer getTypeKey(String serviceName, String typeName) throws PersistenceException{
		if(!this.typeKeys.containsKey(serviceName)) throw new PersistenceException("No type key mapping found for service " + serviceName);
		Map<Integer, String> keyNameMap = this.typeKeys.get(serviceName);
		for(Map.Entry<Integer,String> currentPair : keyNameMap.entrySet())
			if(currentPair.getValue().equals(typeName)) return currentPair.getKey();
		throw new PersistenceException("No typeKey found for type " + typeName);
	}
}
