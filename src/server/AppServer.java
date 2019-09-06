package server;

import utility.ClientData;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServer implements Runnable {
    ServerSocket ss;
    Socket s;
    Thread t1;
    public AppServer(){
        try{
            ss = new ServerSocket(8880);
            t1 = new Thread(this);
            t1.start();
            System.out.println("Server Started.....");
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
    public void run(){
        while (true){
            try {
                s = ss.accept();
                Connect C = new Connect(s);
            }
            catch (Exception ex){

            }
        }
    }
    class Connect{
        Connect(Socket s){
            try{
                ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
                ClientData obj= new ClientData();
                System.out.println("Email :"+obj.email);
                System.out.println("Name :"+obj.name);
                System.out.println("Mobile :"+obj.mobile);
            }
            catch (Exception ex){

            }

        }
    }
}
