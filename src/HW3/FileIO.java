package HW3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class FileIO {

    private LinkedSortedList<Task> sortedList;

    public SortedListInterface<Task> readOSDuties(){
        sortedList= new LinkedSortedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("tasks.txt"))){
            String line;
            String[] lineArray;
            String[] editLine;
            while ((line = bufferedReader.readLine()) != null){
                lineArray=line.trim().split(",");
                String taskType=lineArray[0];
                int burstTime=Integer.parseInt(lineArray[1]);
                editLine=lineArray[2].split("/");
                LocalDate localDate=LocalDate.parse(editLine[2]+"-"+editLine[1]+"-"+editLine[0]);
                LocalTime localTime=LocalTime.parse(lineArray[3]);
                Task task= new Task(taskType,burstTime,localDate,localTime);
                sortedList.add(task);
            }
        }catch (IOException e){
            System.out.println(e);
        }
        return sortedList;
    }
}
