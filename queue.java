//Queue implementation in JAVA
import java.io.*;
public class queue {
    int queue[],size,front,rear;
    queue(int s)
    {
        queue = new int[s];
        size=s;
        front=0;
        rear=-1;
    }
    public void insert(int ele)
    {
        if(rear==size-1)
        {
            System.out.println("Overflow");
            return;
        }
        rear++;
        queue[rear] = ele;
        System.out.printf("Successfully inserted %d \n",ele);
    }
    public void remove()
    {
        int e;
        if(front>rear)
        {
            System.out.println("Underflow");
            return;
        }
        e = queue[front];
        front++;
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
            System.out.println(queue[i]);
    }
    public static void main(String args[]) throws IOException
    {
        int s,ch,ele;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of queue :");
        s = Integer.parseInt(br.readLine());
        queue obj = new queue(s);
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