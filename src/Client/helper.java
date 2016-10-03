package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Henry on 16/9/30.
 */
public class helper {
    static abstract class ButtonActionListenerProcedurer{
        protected Object weight;


        void setWeight(Object w){
            weight = w;
        }

        abstract public ActionListener Procedure(JLabel inf);

    }

    static class ButtonActionListenerBoard extends ButtonActionListenerProcedurer{

        @Override
        public ActionListener Procedure(JLabel inf) {
            return new caculatorButtonActionListener(Integer.class.cast(weight),inf);
        }
    }


    static class ButtonActionListenerSub extends ButtonActionListenerProcedurer{

        @Override
        public ActionListener Procedure(JLabel inf) {
            return null;
        }
    }
//    static class ButtonActionListenerWithDraw extends ButtonActionListenerProcedurer{
//
//        @Override
//        public ActionListener Procedure(JLabel inf) {
//            return new WithDrawListener<Double>(Double.valueOf((Integer)weight),inf);
//        }
//    }

    static Button[] addNumericalButton(int num, JPanel jp, ButtonActionListenerProcedurer a, JLabel inf){
        Button Buttons[] = new Button[num];
        for (int i=0;i<num;i++){

            Buttons[i] = new Button();
            a.setWeight(i+1);
            Buttons[i].setLabel(String.valueOf(i+1));
            Buttons[i].addActionListener(a.Procedure(inf));
            jp.add(Buttons[i]);
        }

        return Buttons;
    }

    static Button[] addNumericalButton(int num,JPanel jp,ButtonActionListenerProcedurer a,JLabel inf,Object val,String text){
        Button Buttons[] = new Button[num];
        for (int i=0;i<num;i++){

            Buttons[i] = new Button();
            a.setWeight(val);
            Buttons[i].setLabel(text);
            Buttons[i].addActionListener(a.Procedure(inf));
            jp.add(Buttons[i]);
        }

        return Buttons;
    }

    static Button[] addNumericalButton(int num,JPanel jp,ButtonActionListenerProcedurer a,JLabel inf,String text){
        Button Buttons[] = new Button[num];
        for (int i=0;i<num;i++){

            Buttons[i] = new Button();
            a.setWeight(i+1);
            Buttons[i].setLabel(text);
            Buttons[i].addActionListener(a.Procedure(inf));
            jp.add(Buttons[i]);
        }

        return Buttons;
    }

    static Map<String,JLabel> addLable(JPanel p, int num, String... text){
        Map<String,JLabel> ps = new TreeMap<>();
        for (int i = 0; i < num; i++) {
            JLabel tmp = new JLabel();
            tmp.setText(text[i]);
            ps.put(text[i],tmp);
            p.add(tmp);
        }

        return ps;
    }

    static class MoneyKepper{
        String s;
    }
}
