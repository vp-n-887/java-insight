class Q{
    int n=0;
   final int max=2;

    synchronized int get()
    {
        while(n==0)
        {
            try{wait();} 
            catch (InterruptedException e) {System.out.println(e); }
            n--;
        }

        System.out.println("Consumer: consumed 1 unit of fuel.. fuel level "+n);
        notify();
        return n;
    }


    synchronized void put(int n)
    {
        while(n==max)
        {
            try{wait();}
            catch(InterruptedException e){System.out.println(e);}
            n--;
        }

        this.n=n;
        System.out.println("producer:  added 1 unit of fuel... fuel level "+n);
        notify();
    }

}

class producer implements Runnable{
    Q q;
    Thread t;
    
    producer(Q q)
    {
        this.q=q;
        t=new Thread(this);
        t.setName("Producer");
        t.start();
    }

    public void run()
    {
        int j=0;
       for(int i=0;i<5;i++) { 
            q.put(j++);
        }
    }
}

class consumer implements Runnable{
    Q q;
    Thread t;

  consumer(Q q) {
    this.q=q;
    t=new Thread(this);
    t.setName("Consumer");
    t.start();
    }

     public void run()
    {
        for(int i=0;i<5;i++) { 
            q.get();
        }
    }
    
}

public class q4{
    public static void main(String[] args) {
        Q q = new Q();

        new producer(q);
        new consumer(q);
    }
}