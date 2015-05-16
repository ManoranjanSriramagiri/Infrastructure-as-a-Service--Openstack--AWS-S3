package disasterRecovery;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
 
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;
 
public class GetMyFiles {
 
 static Properties props;
 
 public static void main(String[] args) {
 
  GetMyFiles getMyFiles = new GetMyFiles();
  
 
  String fileToDownload = "";
  getMyFiles.startFTP( fileToDownload);
    
 }
 
 public boolean startFTP( String fileToDownload){
 
  props = new Properties();
  StandardFileSystemManager manager = new StandardFileSystemManager();
 
  try {
   
    
   //Initializes the file manager
   manager.init();
    
   //Setup our SFTP configuration
   FileSystemOptions opts = new FileSystemOptions();
   //SftpFileSystemConfigBuilder s =new Sf;
   SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(opts, "no");
   SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, true);
   SftpFileSystemConfigBuilder.getInstance().setTimeout(opts, 10000);
    
   //Create the SFTP URI using the host name, userid, password,  remote path and file name
   String sftpUri = "sftp://" + "root" + ":" + "Passw0rd" +  "@" + "192.168.200.173:22"  ;
   
   // Create remote file object
   FileObject remoteFile = manager.resolveFile(sftpUri, opts);
  // remoteFile.
   // Copy local file to sftp server
  // localFile.copyFrom(remoteFile, Selectors.SELECT_SELF);
   System.out.println("File download successful");
 
  }
  catch (Exception ex) {
   ex.printStackTrace();
   return false;
  }
  finally {
   manager.close();
  }
 
  return true;
 }
 
}
