package Online_Examination;
import java.util.Timer;
import java.util.TimerTask;

public class CTimer {
    public static int timeLeft=5*60;
    public static void CountDownTimer(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                int minutes = timeLeft/60;
                int seconds = timeLeft%60;
                System.out.printf("Time left: %02d : %02d \n", minutes, seconds);

                if(timeLeft==0){
                    System.out.println("Time's up!");
                    timer.cancel();
                }
                timeLeft--;
            }
        };

        timer.scheduleAtFixedRate(task,0, 1000);
    }
}
