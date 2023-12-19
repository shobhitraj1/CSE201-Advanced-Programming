package IIITD.Question_1;

import java.util.Objects;

/*
I have used Singleton Design Pattern to implement this File Manager as it requires only one file manager in the system.
As in Singleton design pattern, the constructor of the class is private so the user/client can't call it to create an object of this class, but instead
uses another method provided called getInstance() which returns an object of the class to the user/client. The getInstance() method ensures that only one
instance/object of the class is created, as it first checks if the instance is created (null or not), if not then creates a new object by calling the
constructor of the class, else returns the already existing instance.
This ensures that there will be only one file manager in the system.

//Assumption -> During exam, I asked out instructor, lets say if we try to make 3 FileManager with
FileManager fm1 = new FileManager(1,"Ram");
FileManager fm2 = new FileManager(2,"Shyam");
FileManager fm3 = new FileManager(2,"Shyam");
even then fm1 & fm2 will be same and fm2 will have the attributes of fm1 as it was first created?
Or fm2 & fm3 will be same as they have same attributes?
The instructor said the first case is true that even the "Shyam" fm2 will have fileName "Ram" that is of fm1. ( i.e. Only one fileManager in the
entire system, no matter what's their attributes)
That's why I have used Singleton, else if we have to ensure that there is only one instance with same state (like in fm2 & fm3), then
I will use Flyweight Design Pattern - which uses a Hashmap in the getInstance() method to ensure this condition.
 */
public class FileManager {
    private final int fileID;
    private final String fileName;
    private static FileManager fileManager = null;

    private FileManager(int fileID, String fileName) {
        this.fileID = fileID;
        this.fileName = fileName;
    }

    //implementation of Singleton design pattern
    public static FileManager getInstance(int fileID, String fileName) {
        if (fileManager == null) fileManager = new FileManager(fileID, fileName);
        return fileManager;
    }

    public int getFileID() {
        return fileID;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && this.getClass() == obj.getClass()) {
            FileManager myObj = (FileManager) obj;
            return this.fileID == myObj.fileID && Objects.equals(this.fileName, myObj.fileName);
        }
        return false;
    }

    @Override
    public String toString() {
        return "FileManager{" + "fileID=" + fileID +", fileName='" + fileName + '\'' +'}';
    }
}
