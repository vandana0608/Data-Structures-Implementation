//Double ended Queue implementation in JAVA
import java.io.*;
public class doublequeue {
    int dequeue[],front,rear,size;
    doublequeue(int s)
    {
        dequeue = new int[s];
        size = s;
        front=0;
        rear=-1;
    }
    public void insert_rear(int ele)
    {
        if(rear==size-1)
        {
            System.out.println("Overflow");
            return;
        }
        rear++;
        dequeue[rear] = ele;
        System.out.printf("Successfully inserted %d \n",ele);
    }
    public void insert_front(int ele)
    {
        if(front==0 && rear==-1)    //Empty queue insertion
        {
            rear++;
            dequeue[rear] = ele;
            System.out.printf("Successfully inserted %d \n",ele);
            return;
        }
        if(front!=0)    //Insertion when items present
        {
            front--;
            dequeue[front] = ele;
            System.out.printf("Successfully inserted %d \n",ele);
            return;
        }
        System.out.println("Insertion not possible at front end");  //nsertion not possible at front end
    }
    public void remove_front()
    {
        int e;
        if(front>rear)
        {
            System.out.println("Underflow");
            return;
        }
        e = dequeue[front];
        front++;
        System.out.printf("Successfully deleted %d \n",e);
    }
    public void remove_rear()
    {
        int e;
        if(front>rear)
        {
            System.out.println("Underflow");
            return;
        }
        rear--;
        e = dequeue[rear];
        if(front>rear)  //Reset constraints to initial state of empty queue
        {
            front=0;
            rear = -1;
        }
        System.out.printf("Successfully deleted %d \n",e);
    }
    public void display()
    {
        if(front>rear)
        {
            System.out.println("Underflow, can't display");
            return;
        }
        for(int i=front;i<=rear;i++)
            System.out.println(dequeue[i]);
    }
    public static void main(String args[]) throws IOException
    {
        int s,ch,ele;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of dequeue :");
        s = Integer.parseInt(br.readLine());
        doublequeue obj = new doublequeue(s);
        for(;;)
        {
            System.out.println("1.Insert at front\n2.Insert at rear\n3.Delete at front\n4.Delete at rear\n5.Display\n6.Exit");
            System.out.println("Enter choice :");
            ch = Integer.parseInt(br.readLine());
            switch(ch)
            {
                case 1: System.out.println("Enter element to be inserted at front of queue :");
                        ele = Integer.parseInt(br.readLine());
                        obj.insert_front(ele);
                        break;
                case 2: System.out.println("Enter element to be inserted at rear of queue :");
                        ele = Integer.parseInt(br.readLine());
                        obj.insert_rear(ele);
                        break;
                case 3: obj.remove_front();
                        break;
                case 4: obj.remove_rear();
                        break;
                case 5: obj.display();
                        break;
                case 6: System.exit(0);
            }
        }
    }
}