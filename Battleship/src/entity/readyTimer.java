package entity;

import java.sql.Timestamp;  
import java.time.Instant; 

public class readyTimer implements TimerInterface {
    Timestamp instant;
    long startTime;
    long endTime;
    long currTime;
    long period;
    long interval;
    long count;
    boolean shown = false;

    public readyTimer() {
        period = 5000;
        interval = 1000;
        count = period/interval;
    } 
    
    public void setTimer(int secs,int intervalSecs){
        period = secs * 1000;
        interval = intervalSecs * 1000;
        count = period/interval;
    }
    
    public void startTimer(){
        boolean flag = true;
        instant = Timestamp.from(Instant.now());
        currTime = instant.getTime();
        startTime = currTime;
        endTime = currTime + period;
        while(flag)flag = runTimer(endTime,startTime);
        resetTimer();
    }
    
    private boolean runTimer(long endTime, long startTime){
        instant = Timestamp.from(Instant.now());
        currTime = instant.getTime();
        if ((currTime - startTime) % interval == 0 && !shown){
            System.out.println(count);
            count--;
            shown = true;
        }
        else if((currTime - startTime) % interval != 0) shown = false;
        if(currTime == endTime) return false;
        else return true;
    }
    
    public void resetTimer(){
        period = 5000;
        interval = 1000;
        count = period/interval;
        shown = false;
    }
    
}
