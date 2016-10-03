package Servlet;

import JavaBean.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by Henry on 16/10/1.
 */
public class SocketRunner extends Thread{
    public Socket socket;
    public Data datas;
    SocketRunner(Socket socket,Data data){
        this.socket = socket;
        this.datas = data;
    }

    public void run() {
        try {
            while (!this.isInterrupted()){
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());


                TupleHandler tupleHandler = new TupleHandler((ObjTuple) objectInputStream.readObject());
                Runner runner = tupleHandler.procedure(datas,socket);

                new Thread(runner).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
