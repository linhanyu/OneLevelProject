package JavaBean;

import java.util.ArrayList;

/**
 * Created by Henry on 16/9/24.
 */
public class CreaterObjTuple extends ObjTuple{
    private int CreaterID;



    public void addUser(int type,String name,UserData Creater){
        UserData userData = new UserData();
        atomData.add(userData);
//        CreaterID = (Integer) Creater.getData("Id");
    }



}
