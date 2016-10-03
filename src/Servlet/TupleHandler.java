package Servlet;

import JavaBean.*;


import java.net.Socket;
import java.util.Map;

/**
 * Created by Henry on 16/9/24.
 */
public class TupleHandler {
    ObjTuple objTuple;

    public TupleHandler(ObjTuple objTuple){
        this.objTuple = objTuple;
    }

    public Runner procedure(Data datas, Socket socket){
        if (CreaterObjTuple.class.isInstance(objTuple)){
            return new CreaterRunner(objTuple,datas,socket);
        }else if (SearchObjTuple.class.isInstance(objTuple)){
            return new SearchRunner(objTuple,datas,socket);
        } else if (UpdateObjTuple.class.isInstance(objTuple)){
            return new UpdateRunner(objTuple,datas,socket);
        }
        return null;
    }
}
