package Servlet;


import JavaBean.ObjTuple;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Henry on 16/9/24.
 */
public class ServletEntry {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9002);

        while (true){
            try {
                Socket socket = serverSocket.accept();

                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());


                TupleHandler tupleHandler = new TupleHandler((ObjTuple) objectInputStream.readObject());
                Runner runner = tupleHandler.procedure();

                new Thread(runner).start();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                serverSocket.close();
            }
        }

    }
}
