package main;

import java.util.Random;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import com.universeprojects.miniup.server.ODPDBAccess;

public class Main {
	private final static LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	public static void setUp() {helper.setUp();}
	public static void tearDown() {helper.tearDown();}
	public static void log(Object obj) {System.out.println(obj);}
	public Main () {}
	public static void main(String[] args) {
		setUp();
		ODPDBAccess db = new ODPDBAccess();
		
		Key key = KeyFactory.createKey("Character", 5395075199664128l);
		String strVal = key.toString();
		log(strVal);
		int match = strVal.indexOf("(");
		Key newVal = db.createKey(strVal.substring(0, match), Long.parseLong(strVal.substring(match+1,strVal.lastIndexOf(")"))));
		log(newVal.toString());
		
		tearDown();
	}
}
