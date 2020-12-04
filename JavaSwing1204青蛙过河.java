import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class App {
    JPanel myPanel=new JPanel();
    JLabel labelbj=new JLabel();
    JLabel frog1 = new JLabel();
    JLabel creanconter = new JLabel();
    JLabel frog2 = new JLabel();
    JLabel frog3 = new JLabel();
    JTextArea textArea = new JTextArea();

    int wholi = 1; //过河的青蛙
    int x1=400,y1=300,x2=250,y2=100,x3=700,y3=0;
    int scroe = 0;
    Object[] options = {"重新开始","确定"};

    //构造方法
    public App() {
        myPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                textArea.append(String.valueOf(e.getKeyChar()));
                if (e.getKeyCode() !=KeyEvent.VK_ENTER){
                    switch (wholi){
                        case 1 :
                            if(textArea.getText().equals("hello")&& frog1.getX() == 50&&frog1.getY()==430){
                                frog1.setBounds(x1,y1,128,128);
                                textArea.setText("");
                            }
                            if(textArea.getText().equals("world")&& frog1.getX() == x1 &&frog1.getY()==y1){
                                frog1.setBounds(x2,y2,128,128);
                                textArea.setText("");
                            }
                            if(textArea.getText().equals("hi")&& frog1.getX() == x2&&frog1.getY()==y2){
                                frog1.setBounds(x3,y3,128,128);
                                textArea.setText("");
                                wholi++;
                            }
                            break;
                        case 2 :
                          if(textArea.getText().equals("hello")&& frog2.getX() == 180&&frog2.getY()==430){
                                frog2.setBounds(x1,y1,128,128);
                                textArea.setText("");
                            }
                            if(textArea.getText().equals("world")&& frog2.getX() == x1 &&frog2.getY()==y1){
                                frog2.setBounds(x2,y2,128,128);
                                textArea.setText("");
                            }
                            if(textArea.getText().equals("hi")&& frog2.getX() == x2&&frog2.getY()==y2){
                                frog2.setBounds(500,y3,128,128);
                                textArea.setText("");
                                wholi++;
                            }
                            break;
                        case 3 :
                          if(textArea.getText().equals("hello")&& frog3.getX() == 300&&frog3.getY()==430){
                                frog3.setBounds(x1,y1,128,128);
                                textArea.setText("");
                            }
                            if(textArea.getText().equals("world")&& frog3.getX() == x1 &&frog3.getY()==y1){
                                frog3.setBounds(x2,y2,128,128);
                                textArea.setText("");
                            }
                            if(textArea.getText().equals("hi")&& frog3.getX() == x2&&frog3.getY()==y2){
                                frog3.setBounds(900,y3,128,128);
                                textArea.setText("");
                                wholi++;
                                if(wholi == 4){
                                    //OptionDialog　--　组合其它三个对话框类型。 自定义提示框标题，内容，按钮个数，按钮内容
                                    int response = JOptionPane.showOptionDialog(myPanel,"你真棒！三只青蛙已经全部过河","通过提示",JOptionPane.YES_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                                    if (response == 0){
                                        wholi = 1;
                                        frog1.setBounds(50,430,128,128);
                                        frog2.setBounds(180,430,128,128);
                                        frog3.setBounds(300,430,128,128);
                                    }else {
                                        return;
                                    }
                                }
                            }
                            break;
                        default:
                            return;
                    }
                }else {
                    textArea.setText("");
                }
            }
        });
    }
    //显示窗体方法
    void go(){
        textArea.setText("");
        creanconter.setText("输错请按 回车键清空 ");
        java.net.URL imgbj = App.class.getResource("/img/background.png");
        java.net.URL imgfrog1 = App.class.getResource("/img/frog.png");
        java.net.URL imgfrog2 = App.class.getResource("/img/frogtwo.png");
        java.net.URL imgfrog3 = App.class.getResource("/img/frogthree.png");
        frog1.setIcon(new ImageIcon(imgfrog1));
        frog2.setIcon(new ImageIcon(imgfrog2));
        frog3.setIcon(new ImageIcon(imgfrog3));
        labelbj.setIcon(new ImageIcon(imgbj));
        textArea.setBounds(780,550,200,40);
        frog1.setBounds(50,430,128,128);
        frog2.setBounds(180,430,128,128);
        frog3.setBounds(300,430,128,128);
        labelbj.setBounds(0,0,1024,600);
        creanconter.setBounds(780,500,200,50);
        myPanel.add(creanconter);
        myPanel.add(frog1);
        myPanel.add(frog2);
        myPanel.add(frog3);
        myPanel.add(textArea);
        myPanel.add(labelbj);
        myPanel.setLayout(null);
        textArea.setFocusable(false);//设置输入框光标不可选中，
        JFrame frame = new JFrame("青蛙找妈妈");
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myPanel.setFocusable(true);
        frame.setBounds(100,100,1040,640);
        //frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new App().go();
    }
}
