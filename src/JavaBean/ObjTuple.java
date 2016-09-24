package JavaBean;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Henry on 16/9/24.
 */


public class ObjTuple implements Serializable{
    protected List<Object> atomData;

    public List<Object> getAtomData() {
        return atomData;
    }

    public void setAtomData(List<Object> atomData) {
        this.atomData = atomData;
    }

}


