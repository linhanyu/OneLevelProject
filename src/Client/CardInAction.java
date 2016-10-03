package Client;

import JavaBean.ObjTuple;
import JavaBean.SearchObjTuple;
import JavaBean.UserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Henry on 16/9/30.
 */
public class CardInAction implements ActionListener{
    Socket socket;
    JTextField textField;
    Map<String,JLabel> JLabels;
    JButton jButtonIn;
    JButton jButtonOut;
    helper.MoneyKepper moneyKepper;
    CardInAction(Socket socket,JTextField textField,Map<String,JLabel> JLabels,JButton jButtonIn,JButton jButtonOut,helper.MoneyKepper moneyKepper){
        this.socket = socket;
        this.textField = textField;
        this.JLabels = JLabels;
        this.jButtonIn = jButtonIn;
        this.jButtonOut = jButtonOut;
        this.moneyKepper = moneyKepper;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textField.setEnabled(false);
        jButtonIn.setEnabled(false);
        jButtonOut.setEnabled(true);

        ObjTuple objTuple = new SearchObjTuple();
        objTuple.addAtomData(Integer.parseInt(textField.getText()));
        try{
            ObjectOutputStream oo = new ObjectOutputStream(socket.getOutputStream());


            oo.writeObject(objTuple);

            ObjectInputStream io = new ObjectInputStream(socket.getInputStream());
            UserData usr = new UserData((ObjTuple) io.readObject());

            Iterator<Object> it = usr.iterator();
            for (String key : JLabels.keySet()){
                Object data = usr.getData(key);
                if (Double.class.isInstance(data)){
                    String tmp = String.valueOf((Double)data);
                    JLabels.get(key).setText(key + ":" + tmp);
                    moneyKepper.s = tmp;
                }else if (String.class.isInstance(data)) {

                    JLabels.get(key).setText(key + ":" + (String)data);
                }else if (key.equals("Type")){
                    JLabels.get(key).setText(key + ":"+ ((Integer)data==1 ? "学生": "管理"));
                }
            }


        }catch (Exception e1){
            e1.printStackTrace();
        }

     }
}
