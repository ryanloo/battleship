package entity;

public class shipCounter implements CounterInterface {
    private int count;
    
    public shipCounter(){
        this.count = 5;
    }
    
    public void reset(){
        this.count = 5;
    }
    
    public void increment(){
        count++;
    }
    
    public void decrement(){
        count--;
    }
    
    public int getCount(){
        return count;
    }
}
