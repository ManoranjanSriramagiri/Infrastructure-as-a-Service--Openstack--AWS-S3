package disasterRecovery;

import java.io.File;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

public class SftpExample {

        public static void main(String[] args) {
                String hostName = "192.168.200.173";
                String username = "root";
                String password = "Passw0rd";
                String localFilePath = "C:/text.txt";
                String remoteFilePath = "//var//lib//glance//images//manu.txt";

                
                download(hostName, username, password, localFilePath, remoteFilePath);
              
        }
        // Method to upload a file in Remote server
        
        public static void download(String hostName, String username,
                        String password, String localFilePath, String remoteFilePath) {

                StandardFileSystemManager manager = new StandardFileSystemManager();

                try {
                        manager.init();

                        String downloadFilePath = localFilePath.substring(0,
                        localFilePath.lastIndexOf("."))
                        + "_downlaod_from_sftp"
                        + localFilePath.substring(localFilePath.lastIndexOf("."),
                        localFilePath.length());

                        // Create local file object
                        FileObject localFile = manager.resolveFile(downloadFilePath);

                        // Create remote file object
                        FileObject remoteFile = manager.resolveFile(
                                        createConnectionString(hostName, username, password,
                                                remoteFilePath), createDefaultOptions());

                        // Copy local file to sftp server
                        localFile.copyFrom(remoteFile, Selectors.SELECT_SELF);

                        System.out.println("File download success");
                } catch (Exception e) {
                        throw new RuntimeException(e);
                } finally {
                        manager.close();
                }
        }
        
       
        public static String createConnectionString(String hostName,
        String username, String password, String remoteFilePath) {
        return "sftp://"+username +":"+ password + "@" + hostName + remoteFilePath;
        }
        //  Method to setup default SFTP config:
        public static FileSystemOptions createDefaultOptions()
                        throws FileSystemException {
                        FileSystemOptions opts = new FileSystemOptions();

                // SSH Key checking
                SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(
                                opts, "no");

                // Root directory set to user home
                SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, true);

                // Timeout is count by Milliseconds
                SftpFileSystemConfigBuilder.getInstance().setTimeout(opts, 10000);

                return opts;
        }

}