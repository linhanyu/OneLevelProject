package Servlet;

import JavaBean.CreaterObjTuple;
import JavaBean.ObjTuple;
import com.sun.tools.internal.jxc.SchemaGenerator;

import java.util.Map;

/**
 * Created by Henry on 16/9/24.
 */
public class TupleHandler {
    ObjTuple objTuple;

    public TupleHandler(ObjTuple objTuple){
        this.objTuple = objTuple;
    }

    public Runner procedure(){
        if (CreaterObjTuple.class.isInstance(objTuple)){
            return new CreaterRunner(objTuple);
        }

        return null;
    }
}
