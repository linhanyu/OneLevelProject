package Client;

import javax.swing.*;
import java.awt.*;
import java.net.Socket;

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
        Button run = new Button("运行");

        jFrame.add(create);
        jFrame.add(run);

        jFrame.setVisible(true);


    }
}

class CreaterFormDrawer{

}