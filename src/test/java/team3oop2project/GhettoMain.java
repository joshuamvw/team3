package team3oop2project;

public class GhettoMain {

    public static void main( String[] args )
    {
    //Place the zip file in the folder team3oop2project of the project =>(team3\src\main\java\team3oop2project)
    //Zip file assumed to only contain code files (no plagiarism or other folders)

    //Enter the name of the file including the .zip
    UnzipFiles unzipFiles = new UnzipFiles("816029885_A1");
    unzipFiles.unZipIt();
    }
}
