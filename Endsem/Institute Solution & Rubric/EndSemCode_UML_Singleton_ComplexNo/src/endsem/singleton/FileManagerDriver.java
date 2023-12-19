package endsem.singleton;

public class FileManagerDriver {

	public static void main(String[] args) {
		FileManager fileManager1 = FileManager.getInstance();
		FileManager fileManager2 = FileManager.getInstance();		
		System.out.println("Is fileManager1 equal to fileManager2? " 
								+ fileManager1.equals(fileManager2));
	}
}
