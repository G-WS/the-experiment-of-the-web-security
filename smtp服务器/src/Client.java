import java.util.Timer;
import java.util.TimerTask;

public class Client {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                int i = 0;
                while (i < 10) {
                    i++;
                    Test test = new Test();
                    Test2 test2 = new Test2();
                    test2.getFiles("E://网络攻防//smtp服务器");
                    try {
                        test.send();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        timer.schedule(timerTask, 60);

       /* Test test = new Test();
        Test2 test2 = new Test2();
        test2.getFiles("E://网络攻防//smtp服务器");
        try {
            test.send();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
