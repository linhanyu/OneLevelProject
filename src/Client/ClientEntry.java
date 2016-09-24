package Client;

import JavaBean.CreaterObjTuple;

import javax.swing.*;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Henry on 16/9/24.
 */
public class ClientEntry {
    public static String IP = "127.0.0.1";
    public static Socket socket;

    public static void main(String[] args) {
        try{
//            throw new Exception();
            socket = new Socket(IP,9002);

            new DrawInSwing(socket).draw();

//            CreaterObjTuple createrObjTuple = new CreaterObjTuple();
//            createrObjTuple.addUser(1,"狗");
//            createrObjTuple.addUser(1,"哇");
//            createrObjTuple.addUser(1,"肌");
//


        }catch (Exception e){
            JOptionPane.showMessageDialog(new JPanel(), "启动失败", "我是你爸爸",JOptionPane.WARNING_MESSAGE);
        }
    }
}
