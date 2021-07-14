import java.io.*;

public class Jincheng {
    private static final String PNAME = "taskmgr";


    public static void main(String[] args) throws IOException {

        System.out.println("包含关键字 " + PNAME + " 的进程有：");
        System.out.println();
        String path = System.getProperty("user.dir");
        //创建一个可执行文件，用于读取系统进程
        final File createFileName = new File(path + "\\mytempscript.vbe");
        if (createFileName.exists() ? createFileName.delete() : createFileName.createNewFile()) {
        }
        final PrintWriter pw = new PrintWriter(new FileWriter(createFileName, true), true);
        // 利用GetObject("WinMgmts:")获取系统信息
        pw.println("for each ps in getobject(\"winmgmts:\\\\.\\root\\cimv2:win32_process\").instances_");
        pw.println("wscript.echo ps.handle&vbtab&ps.name");
        pw.println("next");
        pw.close();
        //调用此可执行文件，并将此文件读取的内容写进到流
        final InputStream ii = Runtime.getRuntime().exec("cscript " + path + "\\mytempscript.vbe").getInputStream();
        final InputStreamReader ir = new InputStreamReader(ii);
        final BufferedReader br = new BufferedReader(ir);
        String str = null;
        String[] ss = null;
        //遍历所有进程  br: 6568chrome.exe
        while ((str = br.readLine()) != null) {
            if (str.indexOf(PNAME) > 0 && str.endsWith(".exe")) {
                ss = str.split("\\s");
                for (int i = 0; i < ss.length; i += 2) {
                    System.out.println("****************************");
                    System.out.println("进程名：" + ss[i + 1] + "\n进程ID：" + ss[i]);
                    if (ss[i+1]=="taskmgr.exe"||ss[i+1]=="explorer.exe"){
                        System.out.println("I'm still here");
                        break;
                    }
                }
            }
        }
        //再把此文件删了
        if (createFileName.exists()) {
            createFileName.delete();
        }
        System.out.println("****************************");
        ir.close();
        ii.close();
        br.close();
    }
}