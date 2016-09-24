package JavaBean;

import java.util.ArrayList;

/**
 * Created by Henry on 16/9/24.
 */
public class CreaterObjTuple extends ObjTuple{
    public CreaterObjTuple(){
        atomData = new ArrayList<Object>();

    }

    public void addUser(int type,String name){
        UserData userData = new UserData();
        userData.type = type;
        userData.name = name;
        atomData.add(userData);
    }



}
