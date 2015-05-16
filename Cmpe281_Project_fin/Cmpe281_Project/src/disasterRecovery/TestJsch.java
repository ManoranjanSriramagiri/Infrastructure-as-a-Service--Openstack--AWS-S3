package disasterRecovery;



import com.jcraft.jsch.*;

public class TestJsch {
public static void main(String args[]) {
    JSch jsch = new JSch();
    Session session = null;
    try {
    	java.util.Properties config = new java.util.Properties(); 
    	config.put("StrictHostKeyChecking", "no");
    	
        session = jsch.getSession("root", "192.168.200.173", 22);
        session.setConfig(config);
        //session.setConfig("StrictHostKeyChecking", "no");
        session.setPassword("Passw0rd");
        System.out.println("1");
        session.connect();
        System.out.println("2");

        Channel channel = session.openChannel("sftp");
        System.out.println("3");
        channel.connect();
        System.out.println("4");
        ChannelSftp sftpChannel = (ChannelSftp) channel;
        sftpChannel.get("remotefile.txt", "localfile.txt");
        sftpChannel.exit();
        session.disconnect();
    } catch (JSchException e) {
        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    } catch (SftpException e) {
        e.printStackTrace();
    }
    }
}