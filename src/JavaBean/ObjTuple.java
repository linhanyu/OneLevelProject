package JavaBean;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Henry on 16/9/24.
 */


public class ObjTuple implements Iterable,Serializable{
    protected List<Object> atomData;
    public ObjTuple(){
        atomData = new ArrayList<>();

    }
    public ObjTuple(UserData usr){
        this();
//        atomData = new ArrayList<>();
        for (Object o : usr){
            atomData.add(o);
        }
    }



    public List<Object> getAtomData() {
        return atomData;
    }

    public void setAtomData(List<Object> atomData) {
        this.atomData = atomData;
    }

    public void addAtomData(Object oj) {
       atomData.add(oj);
    }
    class iter implements Iterator{
        Iterator<Object> it;
        public iter(){
            it = atomData.iterator();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        public Object next(){
            return it.next();
        }
    }
    @Override
    public Iterator iterator() {
        return new iter();
    }
}


