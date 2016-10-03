package Client;

import SwingComponent.SubmitButtonAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.DoubleAccumulator;

/**
 * Created by Henry on 16/9/24.
 */
public class DrawInSwing {
    Socket socket;
    public DrawInSwing(Socket socket){
        this.socket = socket;
    }


    public void draw(){
        JFrame jFrame = new JFrame();

        jFrame.setLayout(new GridLayout(2,1));
        jFrame.setSize(300,300);
        jFrame.setTitle("校园一卡通系统");

        Button create = new Button("管理");
        create.addActionListener(new CreaterFormDrawer(socket));

        Button run = new Button("运行");
        run.addActionListener(new RunFormDrawer(socket));

        jFrame.add(create);
        jFrame.add(run);

        jFrame.setVisible(true);


    }
}



class CreaterFormDrawer implements ActionListener{
    Socket socket;

    @Override
    public void actionPerformed(ActionEvent e) {
        draw();
    }


    CreaterFormDrawer(Socket socket){
        this.socket = socket;
    }

    void draw(){
        JFrame jFrame = new JFrame();

        jFrame.setLayout(new GridLayout(2,1));
        jFrame.setSize(300,300);
        jFrame.setTitle("管理");



        jFrame.setVisible(true);
    }
}

class RunFormDrawer implements ActionListener{
    private Button Buttons[];
    Socket socket;
    RunFormDrawer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        draw();
    }

//    static class Listener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            new RunFormDrawer().draw();
//        }
//    }

    void draw(){
        JFrame jFrame = new JFrame();

        jFrame.setLayout(new GridLayout(3,1));
        jFrame.setSize(500,500);
        jFrame.setTitle("运行");

        helper.MoneyKepper moneyKepper = new helper.MoneyKepper();

        JPanel infPanel = new JPanel();
        //信息板
        infPanel.setLayout(new GridLayout(2,1));

        JPanel ResPanel = new JPanel(new GridLayout(1,3));
        Map<String,JLabel> Labels = helper.addLable(ResPanel,3,"Name","Type","Money");

        JTextField textid = new JTextField();

        JPanel InOutPanel = new JPanel();
        JButton cardIn = new JButton("插入");
        JButton cardOut = new JButton("拔出");

        cardOut.setEnabled(false);
        cardIn.addActionListener(new CardInAction(socket,textid,Labels,cardIn,cardOut,moneyKepper));
        cardOut.addActionListener(new CardOutAction(socket,textid,Labels,cardIn,cardOut));
        //信息,输入卡号,两个按钮

        InOutPanel.add(cardIn);
        InOutPanel.add(cardOut);

        infPanel.add(ResPanel);
        infPanel.add(textid);
        infPanel.add(InOutPanel);

        JPanel keyboardPanel = new JPanel();
        //计算器版
        JPanel boardPanel = new JPanel();

        keyboardPanel.setLayout(new GridLayout(2,1));
        boardPanel.setLayout(new GridLayout(4,3));

        JLabel calform = new JLabel("0",JLabel.RIGHT);
        calform.setText("0");

        helper.addNumericalButton(9,boardPanel,new helper.ButtonActionListenerBoard(),calform);
        JButton zero = new JButton("清零");
        zero.addActionListener(new zeroLisitener(calform));
        boardPanel.add(zero);
//        helper.addNumericalButton(1,boardPanel,new helper.ButtonActionListenerSub(),Labels.get("Money"),"消费");
        helper.addNumericalButton(1,boardPanel,new helper.ButtonActionListenerBoard(),calform,0,"0");
//        helper.addNumericalButton(1,boardPanel,new helper.ButtonActionListenerWithDraw(),Labels.get("Money"),Labels.get("Money").getText(),"撤回");
        JButton sub = new JButton("消费");
        sub.addActionListener(new SubDrawListener(Labels.get("Money"),calform));
        boardPanel.add(sub);

        JButton WithDraw = new JButton("撤回");
        WithDraw.addActionListener(new WithDrawListener(moneyKepper,Labels.get("Money")));
        boardPanel.add(WithDraw);
        keyboardPanel.add(calform);
        keyboardPanel.add(boardPanel);




//        keyboardPanel.setVisible(true);

        jFrame.add(infPanel);
        jFrame.add(keyboardPanel);
        jFrame.setVisible(true);
    }
}

class zeroLisitener implements ActionListener{
    JLabel l;
    zeroLisitener(JLabel l){
        this.l = l;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        l.setText("0.0");
    }
}

class caculatorButtonActionListener implements ActionListener{
    int w;
    JLabel inf;
    caculatorButtonActionListener(int w,JLabel inf){
        this.w = w;
        this.inf = inf;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double value = Double.parseDouble(inf.getText()) * 10+w;
        inf.setText(String.valueOf(value));
    }
}

class WithDrawListener implements ActionListener{
    helper.MoneyKepper w;
    JLabel inf;
    WithDrawListener(helper.MoneyKepper w,JLabel inf){
        this.w = w;
        this.inf = inf;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String tmp = inf.getText();
        inf.setText(tmp.substring(0,tmp.indexOf(':') + 1) + w.s);
    }
}

class SubDrawListener implements ActionListener{
    JLabel userinf;
    JLabel inf;
    SubDrawListener(JLabel Userinf,JLabel inf){
        userinf = Userinf;
        this.inf = inf;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double res;
        String text = userinf.getText();
        String subtext = text.substring(text.indexOf(':')+1);
        res = Double.valueOf(subtext)- Double.valueOf(inf.getText());

        if (res > 0){
//            userinf.setText(String.valueOf(res));
            userinf.setText(text.substring(0,text.indexOf(':')+1) + String.valueOf(res));
        }else{
            JOptionPane.showMessageDialog(new JPanel(), "穷逼", "余额不足",JOptionPane.WARNING_MESSAGE);


        }

        inf.setText("0.0");

    }
}


//
//class helper{
//
//}