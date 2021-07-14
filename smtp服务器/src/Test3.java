import java.io.FileWriter;
import java.io.IOException;

public class Test3 {
    public void write(String str) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("E:\\网络攻防\\smtp.txt");
            fileWriter.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
