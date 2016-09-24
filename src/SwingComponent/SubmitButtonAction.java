package SwingComponent;

import JavaBean.ObjTuple;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Henry on 16/9/24.
 */
public class SubmitButtonAction implements ActionListener {
    ObjTuple objTuple;
    ObjectOutputStream objectOutputStream;

    SubmitButtonAction(ObjTuple objTuple,ObjectOutputStream objectOutputStream){
        this.objTuple = objTuple;
        this.objectOutputStream = objectOutputStream;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            objectOutputStream.writeObject(objTuple);
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }
}
