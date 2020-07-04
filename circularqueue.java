//Circular Queue implementation in JAVA
import java.io.*;
public class circularqueue {
    int queue[],size,front,rear,count;
    circularqueue(int s)
    {
        queue = new int[s];
        size=s;
        front=0;
        rear=-1;
        count=0;
    }
    public void insert(int e)
    {
        if(count==size)
        {
            System.out.println("Overflow");
            return;
        }
        rear = (rear+1)%size;
        queue[rear]=e;
        count++;
        System.out.printf("Successfully inserted %d \n",e);
    }
    public void remove()
    {
        int ele;
        if(count==0)
        {
            System.out.println("Underflow");
            return;
        }
        ele = queue[front];
        front = (front+1)%size;
        count--;
        System.out.printf("Successfully deleted %d \n",ele);
    }
    public void display()
    {
        if(count==0)
        {
            System.out.println("Underflow, can't display");
            return;
        }
        for(int i=1,f=front;i<=count;i++)
        {
            System.out.println(queue[f]);
            f = (f+1)%size;
        }
    }
    public static void main(String args[]) throws IOException
    {
        int s,ch,ele;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of circular queue :");
        s = Integer.parseInt(br.readLine());
        circularqueue obj = new circularqueue(s);
        for(;;)
        {
            System.out.println("1.Insert\n2.Delete\n3.Display\n4.Exit");
            System.out.println("Enter choice :");
            ch = Integer.parseInt(br.readLine());
            switch(ch)
            {
                case 1: System.out.println("Enter element to be inserted :");
                        ele = Integer.parseInt(br.readLine());
                        obj.insert(ele);
                        break;
                case 2: obj.remove();
                        break;
                case 3: obj.display();
                        break;
                case 4: System.exit(0);
            }
        }
    }
}