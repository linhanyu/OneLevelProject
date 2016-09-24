package JavaBean;

import java.io.Serializable;

/**
 * Created by Henry on 16/9/24.
 */
public class UserData implements Serializable{
    public int id;
    public int type;
    public String name;
    public double money;

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }
}
