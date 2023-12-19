package endsem.singleton;


/**
 * FileManager class implements the Singleton design pattern. Since only
 * one instance should be present globally, this is an appropriate design pattern to use.
 */
public class FileManager {

	private int fileID;
	private String fileName;	
	private static FileManager fileManager = null;
	
	private FileManager() {
		fileID = 0;
		fileName = "noname";
	}
	
	public static FileManager getInstance() {
		if(fileManager == null)
			return new FileManager();
		else
			return fileManager;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null && getClass() == o.getClass()) {
			FileManager fm = (FileManager) o;
			return (fileID == fm.fileID && fileName.equals(fm.fileName));
		}
		else
			return false;
	}
}
