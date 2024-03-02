package HW3;

public class OurMain {
	static PriorityQueue<Task> priorityQueue= new PriorityQueue<>();
	static FileIO fileIO= new FileIO();
	static LinkedSortedList<Task> sortedList=(LinkedSortedList<Task>) fileIO.readOSDuties();
    public static void main(String[] args) {
    	      
         BurstStack<Task> stack= new BurstStack<>();
         BurstStack<Task> tempStack=new BurstStack<>();
    	
            System.out.println("All Tasks");
            
            for (int i=1;i<=sortedList.getLength();i++){
                System.out.println(sortedList.getEntry(i).getType()+","+sortedList.getEntry(i).getBurstTime()+","+sortedList.getEntry(i).getLocalDate()+","+sortedList.getEntry(i).getLocalTime());
            }
            System.out.println("---------------------------------");
            System.out.println();
        

       
            System.out.println("Burst Time Ordering");
            
            for (int i=1;i<=sortedList.getLength();i++){
                stack.push(sortedList.getEntry(i));
            }
            while(!stack.isEmpty()){
                Task x= stack.pop();
                tempStack.push(x);
                System.out.println(x.getType()+","+x.getBurstTime()+","+x.getLocalDate()+","+x.getLocalTime());
            }
            System.out.println();
        

        
            int num=0;
            System.out.println("Remaining tasks after 5 execution");
            
            while(!tempStack.isEmpty()){
                Task y= tempStack.pop();
                stack.push(y);
                num++;
                if (num>5){
                    System.out.println(y.getType()+","+y.getBurstTime()+","+y.getLocalDate()+","+y.getLocalTime());
                }
            }
            System.out.println();
            num=0;
            System.out.println("Remaining tasks after 10 execution");
            
            while(!stack.isEmpty()){
                Task z= stack.pop();
                tempStack.push(z);
                num++;
                if (num>10){
                    System.out.println(z.getType()+","+z.getBurstTime()+","+z.getLocalDate()+","+z.getLocalTime());
                }
            }
            System.out.println();
            num=0;
            System.out.println("Remaining tasks after 15 execution");
            
            while(!tempStack.isEmpty()){
                Task t= tempStack.pop();
                stack.push(t);
                num++;
                if (num>15){
                    System.out.println(t.getType()+","+t.getBurstTime()+","+t.getLocalDate()+","+t.getLocalTime());
                }
            }
            System.out.println("------------------------------------------");
            System.out.println();
        

       
            System.out.println("Priority Ordering Line");
            
            for (int i=1;i<=sortedList.getLength();i++){
                priorityQueue.add(sortedList.getEntry(i));
            }

            while (!priorityQueue.isEmpty()){
                Task a=priorityQueue.remove();
                System.out.println(a.getType()+","+a.getBurstTime()+","+a.getLocalDate()+","+a.getLocalTime());
            }
            System.out.println();

        

       
            int num1=0;
            addToPriority();
            System.out.println("Remaining tasks after 5 execution");
            
            while (!priorityQueue.isEmpty()){
                Task b=priorityQueue.remove();
                num1++;
                if (num1>5){
                    System.out.println(b.getType()+","+b.getBurstTime()+","+b.getLocalDate()+","+b.getLocalTime());
                }
            }
            System.out.println();
            num1=0;
            addToPriority();
            System.out.println("Remaining tasks after 10 execution");
          
            while (!priorityQueue.isEmpty()){
                Task c=priorityQueue.remove();
                num1++;
                if (num1>10){
                    System.out.println(c.getType()+","+c.getBurstTime()+","+c.getLocalDate()+","+c.getLocalTime());
                }
            }
            System.out.println();
            num1=0;
            addToPriority();
            System.out.println("Remaining tasks after 15 execution");
            
            while (!priorityQueue.isEmpty()){
                Task d=priorityQueue.remove();
                num1++;
                if (num1>15){
                    System.out.println(d.getType()+","+d.getBurstTime()+","+d.getLocalDate()+","+d.getLocalTime());
                }
            }
            System.out.println("*******************************************************");

        
    }

    	
            
    
    public static void addToPriority(){
        for (int i=1;i<=sortedList.getLength();i++){
            priorityQueue.add(sortedList.getEntry(i));
        }
    }
}
