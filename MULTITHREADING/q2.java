    class newthread extends Thread{
    
       
        int mulfactor;
       

        newthread(String name,int priority,int mulfactor)
        {
            super(name);
            setPriority(priority);

            this.mulfactor=mulfactor;

            start();
        
        }

        public void run()
        {
            try{
                System.out.print(getName()+":  ");

                for (int i=1;i<=5;i++) {
                    System.out.print(mulfactor*i+"  ");
                    Thread.sleep(500);
                }

                System.out.println("---------priority:"+getPriority());
            
                System.out.println(getName()+" execution completed");
            
            } 
            catch (InterruptedException e)
            {
                System.out.println(e);
            }
        }

    }
    

    public class q2{
        public static void main(String[] args) {
            newthread t1=new newthread("Thread A",7,2);

            try{t1.join();} 
            catch (InterruptedException e) {System.out.println(e);}


            newthread t2=new newthread("Thread B",2,3);

            try{t2.join();} 
            catch (InterruptedException e) {System.out.println(e);}


            newthread t3=new newthread("Thread C",3,5);
        
            try{ t3.join();}
            catch (InterruptedException e) {System.out.println(e);}

            System.out.println("all 3 thread execution completed");
        
        }
    }