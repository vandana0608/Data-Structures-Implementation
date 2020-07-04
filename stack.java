//Stack program implementation in JAVA
import java.io.*;
public class stack 
{
    int stack[],size,top;
    stack(int s)
    {
        stack = new int[s];
        size = s;
        top = -1;
    }
    public void push(int ele)
    {
        if(top==size-1)
        {
            System.out.println("Overflow");
            return;
        }
        top++;
        stack[top] = ele;
        System.out.printf("Successfully pushed %d \n", ele);
    }
    public void pop()
    {
        int e;
        if(top==-1)
        {
            System.out.println("Underflow");
            return;
        }
        e = stack[top];
        top--;
        System.out.printf("Successfully popped %d \n", e);
    }
    public void display()
    {
        if(top==-1)
        {
            System.out.println("Underflow, can't display");
            return;
        }
        for(int i=0;i<=top;i++)
            System.out.println(stack[i]);
    }
    public static void main(String args[]) throws IOException
    {
        int s,ch,ele;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of stack :");
        s = Integer.parseInt(br.readLine());
        stack obj = new stack(s);
        for(;;)
        {
            System.out.println("1.Push\n2.Pop\n3.Display\n4.Exit");
            System.out.println("Enter chocie :");
            ch = Integer.parseInt(br.readLine());
            switch(ch)
            {
                case 1: System.out.println("Enter element to be pushed :");
                        ele = Integer.parseInt(br.readLine());
                        obj.push(ele);
                        break;
                case 2: obj.pop();
                        break;
                case 3: obj.display();
                        break;
                case 4: System.exit(0);
            }
        }
    }
}
