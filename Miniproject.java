
package miniproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Miniproject {
    public static void main(String[] args) {
        MyWork w=new MyWork();
}
}
class MyWork extends JFrame implements ActionListener 
{
    JLabel l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1;
    JButton b2;
    MyWork()
    {
        l1=new JLabel("Username");
        l2=new JLabel("Password");
        l1.setBounds(40,50,70,30);
        l2.setBounds(40,90,70,30);
        t1=new JTextField();
        t1.setBounds(130,50,130,30);
        p1=new JPasswordField();
        p1.setBounds(130,90,130,30);
        b1=new JButton("Login");
        b2=new JButton("Reset");
        b1.setBounds(85,150,100,30);
        b2.setBounds(85,180,100,30);//
        b2.addActionListener(this);//
        b1.addActionListener(this);
        add(l1);add(l2);add(t1);add(p1);add(b1);add(b2);//
        setLayout(null);
        setVisible(true);
        setSize(500,500);
        setTitle("Student Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        String uname=t1.getText();
        String pass=p1.getText();
       if(e.getSource()==b1)
       {
           if(uname.equals("hello")&&pass.equals("world"))
           {
            JOptionPane.showMessageDialog(this,"LOGIN SUCCESSFUL");      
            setVisible(false);
            MyOption o=new MyOption();
           }
           else
           {
               JOptionPane.showMessageDialog(this,"INVALID USERNAME OR PASSWORD");
           }
       }
       else if(e.getSource()==b2)
       {
           setVisible(false);
           MyWork obj=new MyWork();
    }
}
}
class MyOption extends JFrame implements ActionListener 
{
    JButton b1,b2;
    JLabel l1;
    MyOption()
    {
        l1=new JLabel("Choose the language in which you want to give test");
        l1.setBounds(20,40,300,30);
        b1=new JButton("C++");
        b1.setBounds(40,100,100,30);
        b2=new JButton("Java");
        b2.setBounds(40,160,100,30);//to set dimension .
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);add(l1);//to add components to frame
        setLayout(null);//to set the layout of frame
        setSize(500,500);//to set the size of frame
        setVisible(true);//to set the visibility of frame
        setTitle("WELOCME TO EXAM PORTAL");//to set title of frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//this will close thw window on clicking exit button
    }
    public void actionPerformed(ActionEvent e)//to override the funcation 
    {
        
        if(e.getSource()==b1)
        {
            setVisible(false);//frame will disappear
            MyCpp cpp=new MyCpp();
        }
        if(e.getSource()==b2)
        {
            setVisible(false);
            Java obj=new Java();
        }
    }
}


