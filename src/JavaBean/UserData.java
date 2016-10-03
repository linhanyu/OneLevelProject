package JavaBean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Henry on 16/9/24.
 */
public class UserData implements Serializable,Iterable{
    public Map<String,Object> data;
    public static final String types[]= {
            "Id",
            "Type",
            "Name",
            "Money",
    };
    
    public UserData(){
        data = new HashMap<>();
    }

    public UserData(ObjTuple o){
        this();
        build(o);
    }
    public void setId(int id) {
        data.put(types[0],id);
    }

    public void setType(int type) {
        data.put(types[1],type);
    }


    public void setName(String name) {
        data.put(types[2],name);
    }

    public void setMoney(double money)
    {
        data.put(types[3],money);
    }

    public Integer getId() {
        return (Integer) data.get(types[0]);
    }

    public String getType() {
        return (String) data.get(types[1]);
    }

    public String getName() {
        return (String) data.get(types[2]);
    }

    public Double getMoney() {
        return (Double) data.get(types[3]);
    }

    public Object getData(String key) {
        return data.get(key);
    }


    public void build(ObjTuple o){
        Iterator<Object> iter = o.iterator();
        for(String key : types){
            if (!(iter.hasNext())) break;
            data.put(key,iter.next());
        }
    }


    @Override
    public Iterator iterator() {
        return new iter();
    }

    class iter implements Iterator<Object>{
        int count=0;
        @Override
        public boolean hasNext() {
            return count < types.length;
        }

        @Override
        public Object next() {
            return data.get(types[count++]);
        }
    }
}
