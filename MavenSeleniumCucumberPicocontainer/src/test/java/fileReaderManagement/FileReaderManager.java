package fileReaderManagement;

import configFileManagement.ConfigFileReader;

public class FileReaderManager {
	
	//-----------Singleton design pattern-------------
	//Private constructor to restrict instantiation of the class from other classes.
	//Private static variable of the same class that is the only instance of the class.
	//Public static method that returns the instance of the class, this is the global access point for outer world to get the instance of the singleton class.
	
	
		 //FileReaderManager class maintains a static reference to its own instance and returns that reference from the static getInstance() method.
		 private static FileReaderManager fileReaderManager = new FileReaderManager();
		 
		 
		 private static ConfigFileReader configFileReader;
		 
		 private FileReaderManager() {
			 
		 // FileReaderManager implements a private constructor so clients cannot instantiate FileReaderManager instances.
		 }
		 
		 public static FileReaderManager getInstance( ) {
		       return fileReaderManager;
		 }
		 
		 //getConfigReader() method returns the instance of the ConfigFileReader but this method is not static. 
		 //So that client has to use the getInstance() method to access other public methods of the FileReaderManager
		 //like FileReaderManager.getInstance().getConfigReader()
		 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
		 }
}
