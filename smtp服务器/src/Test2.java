import java.io.File;
import java.util.Scanner;

public class Test2 {
    public void getFiles(String path) {
        File file = new File(path);
        Test3 test3 = new Test3();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    test3.write("目录：" + files[i].getPath());
                    getFiles(files[i].getPath());
                } else {
                    test3.write("文件：" + files[i].getPath());
                }
            }
        } else {
            test3.write("文件：" + file.getPath());
        }
    }
    /*public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入文件路径");
        String str = in.nextLine();
        Test2 test2 = new Test2();
        test2.getFiles(str);
    }*/
}
