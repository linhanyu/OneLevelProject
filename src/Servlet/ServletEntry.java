package Servlet;


import JavaBean.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * Created by Henry on 16/9/24.
 */
public class ServletEntry {


    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(9002);
        File data = new File("./datas.dat");
        ObjectInputStream i = new ObjectInputStream(new FileInputStream(data));

        Data datas = (Data) i.readObject();
//        UserData t = new UserData();
//        t.setName("Father");
//        t.setMoney(100);
//        t.setType(0);
//        Data datas = new Data();
//        datas.put(t);
//        t = new UserData();
//        t.setName("Son");
//        t.setMoney(100);
//        t.setType(1);
//        Data datas = new Data();
//        datas.put(t);
//
         new objFlusher(datas,new ObjectOutputStream(new FileOutputStream(data))).start();

//        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(data));
//        o.writeObject(d);
//        o.flush();
//        o.close();

//        try{

            while (true){
            try {
                    Socket socket = serverSocket.accept();

                    SocketRunner socketRunner = new SocketRunner(socket,datas);
                    socketRunner.start();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
//        }
// finally {
//            try
//            {
////                ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(data));
////                o.writeObject(d);
////                o.flush();
////                o.close();
//            }catch (Exception e){
//                throw e;
//            }
//        }

    }
}

class objFlusher extends Thread{
    Data datas;
    ObjectOutputStream o;

    objFlusher(Data datas,ObjectOutputStream o) {
        this.datas = datas;
        this.o = o;
    }

    public void run(){
        try {
            while (!this.isInterrupted()){

                o.reset();
//                System.out.println(datas.get(1).getData("Name"));
//                System.out.println(datas.get(0).getData("Name"));
                o.writeObject(datas);
                o.flush();

                TimeUnit.SECONDS.sleep(5);


          }
            o.close();
            System.out.println("fuck");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


