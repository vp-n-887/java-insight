class newthread implements Runnable{
    Thread t;
   
    int mulfactor;

    newthread(String name,int priority,int mulfactor)
    {
        this.mulfactor=mulfactor;
        
        t=new  Thread(this);
        t.setName(name);
        t.setPriority(priority);
        t.start();
       
    }

    public void run()
    {
        try{
            System.out.print(Thread.currentThread().getName() + ":  ");

            for (int i=1; i<=5;i++) {
                System.out.print(mulfactor*i+"  ");
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
 

public class Q1{
    public static void main(String[] args) {
        newthread t1=new newthread("Thread A",7,2);

        try{t1.t.join();} 
        catch (InterruptedException e) {System.out.println(e);}


        newthread t2=new newthread("Thread B",2,3);

        try{t2.t.join();} 
        catch (InterruptedException e) {System.out.println(e);}


        newthread t3=new newthread("Thread C",3,5);
       
        try{ t3.t.join();}
         catch (InterruptedException e) {System.out.println(e);}


        System.out.println("Thread A alive: " + t1.t.isAlive()); 
        System.out.println("Thread B alive: " + t2.t.isAlive());
        System.out.println("Thread C alive: " + t3.t.isAlive()); 
    }
}