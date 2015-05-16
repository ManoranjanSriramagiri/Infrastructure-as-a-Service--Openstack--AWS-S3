package disasterRecovery;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
 

public class RunScript {
 
   public static void main(String[] args) throws IOException {
             
       File folder = new File("H:\\test");
       File[] listOfFiles = folder.listFiles();
           
           File file = new File("H:\\test\\"+listOfFiles[0].getName());

           // File (or directory) with new name
           File file2 = new File("H:\\test\\"+"tt.raw");
           if(file2.exists()) throw new java.io.IOException("file exists");

           // Rename file (or directory)
           boolean success = file.renameTo(file2);
           if (!success) {
               // File was not successfully renamed
           }
 
   }
 
}
