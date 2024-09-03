import java.lang.*;

class chat{
    private boolean flag = false;
    int count  = 0;

    public synchronized void questions(String q){
        if(flag){
            try{
                wait();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"- " + q);
        flag = true;
        count  = 0;
        notifyAll();
    }

    public synchronized void answers(String a){
        if(!flag){
            try{
                wait();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() +"- "+a);
        count++;
        if(count == 3){
        flag = false;
        notifyAll();
        }
    }
}

class T1 implements Runnable{

    chat m1;
    T1(chat m){
        this.m1 = m;
    }
    String [] queStrings = {"How are you? ", "In which class are you in ?" };

    @Override
    public void run() {
        // TODO Auto-generated method stub
       for (int i = 0; i < queStrings.length; i++) {
            m1.questions(queStrings[i]);
       }   
    }
}

class T2 implements Runnable{
    chat m1;
    T2(chat m){
        this.m1 = m;
    }
    String [] ansStrings = {"Iam fine !!", "Iam in java class." };

    @Override
    public void run() {
        // TODO Auto-generated method stub
       for (int i = 0; i < ansStrings.length; i++) {
            m1.answers(ansStrings[i]);
            try{
                wait();
            }
            catch(Exception e){
                // e.printStackTrace();
                System.out.print("");
            }
       }   
    }
}

public class Chat_3{
     public static void main(String[] args) {
        chat m = new chat();
        T1 ques = new T1(m);
        T2 ans = new T2(m);
        Thread t1 = new Thread(ques,"question");
        Thread t2 = new Thread(ans,"anwser1");
        Thread t3 = new Thread(ans,"anwser2");
        Thread t4 = new Thread(ans,"anwser3");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
     }

} 