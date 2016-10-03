package Client;

import JavaBean.ObjTuple;
import JavaBean.SearchObjTuple;
import JavaBean.UpdateObjTuple;
import JavaBean.UserData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Henry on 16/10/1.
 */
public class CardOutAction implements ActionListener {
    Socket socket;
    JTextField textField;
    Map<String,JLabel> JLabels;
    JButton jButtonIn;
    JButton jButtonOut;
    CardOutAction(Socket socket,JTextField textField,Map<String,JLabel> JLabels,JButton jButtonIn,JButton jButtonOut){
        this.socket = socket;
        this.textField = textField;
        this.JLabels = JLabels;
        this.jButtonIn = jButtonIn;
        this.jButtonOut = jButtonOut;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textField.setEnabled(true);
        jButtonIn.setEnabled(true);
        jButtonOut.setEnabled(false);

        ObjTuple objTuple = new UpdateObjTuple();
        objTuple.addAtomData(Integer.parseInt(textField.getText()));
        String money = JLabels.get("Money").getText();
        objTuple.addAtomData(Double.parseDouble(money.substring(money.indexOf(':')+1)));

        for (String key : JLabels.keySet()){
            String str = JLabels.get(key).getText();
            JLabels.get(key).setText(str.substring(0,str.indexOf(':')));
        }

        try{
            ObjectOutputStream oo = new ObjectOutputStream(socket.getOutputStream());


            oo.writeObject(objTuple);

//            ObjectInputStream io = new ObjectInputStream(socket.getInputStream());
//            UserData usr = new UserData((ObjTuple) io.readObject());
//
//            Iterator<Object> it = usr.iterator();
//            for (String key : JLabels.keySet()){
//                Object data = usr.getData(key);
//                if (Double.class.isInstance(data)){
//                    JLabels.get(key).setText(key + ":" +  String.valueOf((Double)data));
//
//                }else if (String.class.isInstance(data)) {
//
//                    JLabels.get(key).setText(key + ":" + (String)data);
//                }else if (key.equals("Type")){
//                    JLabels.get(key).setText(key + ":"+ ((Integer)data==1 ? "学生": "管理"));
//                }
//            }


        }catch (Exception e1){
            e1.printStackTrace();
        }

    }
}
