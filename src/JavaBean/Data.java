package JavaBean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Henry on 16/9/30.
 */
public class Data implements Serializable {
    private Map<Integer, UserData> datas;
    private int counter;

    public Data(){
        datas = new HashMap<>();
        counter = 0;
    }

    public Data(Map<Integer,UserData> d){
        datas = d;
    }

    public UserData get(Integer i){
        return datas.get(i);
    }

    public void put(Integer i,UserData usr){
        datas.put(i,usr);
    }

    public Integer put(UserData usr){
        datas.put(counter++,usr);
        return counter;
    }
}
