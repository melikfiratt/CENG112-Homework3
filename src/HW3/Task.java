package HW3;

import java.time.LocalDate;
import java.time.LocalTime;

public class Task implements  Comparable<Task> {

    private String type;
    private int burstTime;
    private LocalDate localDate;
    private LocalTime localTime;
    private int priority;

    public Task(String type, int burstTime, LocalDate date, LocalTime time) {
        this.type = type;
        this.burstTime = burstTime;
        this.localDate = date;
        this.localTime = time;
        this.priority=0;

    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int PriorityCompareTo(Task other){
        if (type.equals("security management")){
            setPriority(6);
        } else if (type.equals("process management")) {
            setPriority(5);
        } else if (type.equals("memory management")) {
            setPriority(4);
        } else if (type.equals("user management")) {
            setPriority(3);
        } else if (type.equals("device management")) {
            setPriority(2);
        }else{
            setPriority(1);
        }

        if (getPriority()==other.getPriority()){
            return localTime.compareTo(other.getLocalTime());
        } else if (priority>other.getPriority()) {
            return -1;
        }else{
            return 1;
        }
    }
    
    
    @Override
   
    
    public int compareTo(Task other) {
        return localTime.compareTo(other.getLocalTime());
    }

    
    
    public int StackCompareTo(Task other){
        if (burstTime==other.getBurstTime()){
            return localTime.compareTo(other.getLocalTime());
        }else if(burstTime>other.getBurstTime()){
            return 1;
        }else{
            return -1;
        }
    }

   
}

