import java.io.IOException;

public class Zhuce {
    public void changeStart(boolean isStartAtLogon,String str2,String str3) throws IOException {
        String regKey = "HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run";
        String myAppName = "mgtest";
        String exePath1 = "\\"+str2;
        String exePath2 = "\\"+str3;
        Runtime.getRuntime().exec("reg " + (isStartAtLogon ? "add " : "delete ") + regKey + " /v " + myAppName + (isStartAtLogon ? " /t reg_sz /d " + exePath1 : " /f"));
        Runtime.getRuntime().exec("reg " + (isStartAtLogon ? "add " : "delete ") + regKey + " /v " + myAppName + (isStartAtLogon ? " /t reg_sz /d " + exePath2 : " /f"));
        System.out.println("启动项设置成功");
    }


}
