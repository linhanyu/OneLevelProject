package Servlet;

import JavaBean.*;

import javax.jws.soap.SOAPBinding;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Henry on 16/9/24.
 */
abstract public class Runner implements Runnable{
    protected Data data;
    protected Socket socket;
    protected ObjTuple objTuple;
    abstract public void run();

    Runner(ObjTuple objTuple,Data data,Socket socket){
        this.objTuple = objTuple;
        this.data = data;
        this.socket = socket;
    }
}


class CreaterRunner extends Runner{



    CreaterRunner(ObjTuple objTuple,Data data,Socket socket){
        super(objTuple, data, socket);
    }

    @Override
    public void run() {
        for (Object data:
                objTuple) {
            UserData userdata = (UserData)data;

        }
    }
}

class SearchRunner extends Runner{

    SearchRunner(ObjTuple objTuple,Data data,Socket socket){
        super(objTuple, data, socket);

    }

    @Override
    public void run() {
        UserData usr = null;
        for (Object key:objTuple){
             usr = data.get((Integer)key);
        }
        try {
            ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
            o.writeObject(new ObjTuple(usr));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class UpdateRunner extends Runner{


    UpdateRunner(ObjTuple objTuple, Data data, Socket socket) {
        super(objTuple, data, socket);
    }

    @Override
    public void run() {
        Iterator<Object> iter = objTuple.iterator();
        Integer id = (Integer)iter.next();
        Double Money = (Double)iter.next();
        UserData usr = data.get(id);
        usr.setMoney(Money);
        data.put(id,usr);
    }
}