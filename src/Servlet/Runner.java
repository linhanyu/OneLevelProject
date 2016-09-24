package Servlet;

import JavaBean.*;

import java.util.List;

/**
 * Created by Henry on 16/9/24.
 */
abstract public class Runner implements Runnable{

    abstract public void run();
}


class CreaterRunner extends Runner{
    private ObjTuple objTuple;


    CreaterRunner(ObjTuple objTuple){
        this.objTuple = objTuple;
    }

    @Override
    public void run() {
        for (Object data:
                objTuple.getAtomData()) {
            UserData userdata = (UserData)data;
            System.out.println(userdata.name);

        }
    }
}