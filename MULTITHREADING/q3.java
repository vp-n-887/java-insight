class newthread implements Runnable{
    Thread t;
    
    boolean odd;

    newthread(String name,int priority,boolean odd)
    {
        this.odd=odd;

        t=new Thread(this);
        t.setName(name);
        t.setPriority(priority);
        t.start();
       
    }

    public void run()
    {
        try{
            System.out.print(Thread.currentThread().getName() + ":  ");

            int start,end;
            if(this.odd==true){start=1;end=9;System.out.print("odd: ");}
            else{start=2;end=10;System.out.print("even: ");}

            for (int i=start; i<=end;i=i+2) {
                System.out.print(i+"  ");
                 Thread.sleep(500);
            }

            System.out.println("---------priority: "+Thread.currentThread().getPriority());
        
           
        } 
        catch (InterruptedException e)
        {
            System.out.println(e);
        }
    }

}
 

public class q3{
    public static void main(String[] args) {
        newthread t1=new newthread("Thread A",7,true);

        try{t1.t.join();} 
        catch (InterruptedException e) {System.out.println(e);}


        newthread t2=new newthread("Thread B",2,false);

        try{t2.t.join();} 
        catch (InterruptedException e) {System.out.println(e);}

    }
}