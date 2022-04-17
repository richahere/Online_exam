
package miniproject;
import javax.swing.*;
import java.awt.event.*;
public class Java extends JFrame implements ActionListener{
    JLabel l;
    JRadioButton opt[]=new JRadioButton[4];
    JButton b1,b2;
    ButtonGroup select;
    int count=0,current=0,i=1;
    public Java()
    {
        l=new JLabel();
        add(l);
        l.setBounds(30,40,450,20);
        select=new ButtonGroup();
        for(int i=0;i<4;i++)
        {
            opt[i]=new JRadioButton();
            add(opt[i]);
            select.add(opt[i]);//to make sure only one option is selected
        }
        b1=new JButton("NEXT");
        add(b1);
        b2=new JButton("Result");
        b2.setVisible(true);
        b2.setBounds(100,240,220,30);
        b1.setBounds(100,240,220,30);
        opt[0].setBounds(50,80,220,20);
        opt[1].setBounds(50,110,220,20);
        opt[2].setBounds(50,140,220,20);
        opt[3].setBounds(50,170,220,20);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setQuestion();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setSize(600,350);
        setTitle("JAVA EXAM");
    }
    public Boolean check()
    {
        if(current==0)
            return(opt[1].isSelected());//it will return whether correct option is selected or not
        if(current==1)
            return(opt[0].isSelected());
        if(current==2)
            return(opt[2].isSelected());
        if(current==3)
            return(opt[1].isSelected());
        if(current==4)
            return(opt[3].isSelected());
        return false;
    }
    public void setQuestion()
    {
        if(current==0)
        {
            l.setText("QUES 1:  JAVA IS A ");
            opt[0].setText("POP");opt[1].setText("OOPS");opt[2].setText("BOTH");opt[3].setText("NONE OF THESE");
        }
        if(current==1)
        {
            l.setText("QUES 2: WHICH OF THE FOLLOWING WILL RUN FIRST");
            opt[0].setText("STATIC BLOCK");opt[1].setText("PARAMATERIZED CONSTRUCTOR");opt[2].setText("DEFAULT CONSTRUCTOR");opt[3].setText("NONE");  
            
        }
        if(current==2)
        {
            l.setText("QUES 3: WHO IS KNOWN AS FATHER OF JAVA?");
            opt[0].setText("M.P. JAVA");opt[1].setText("CHARLES BABBAGE");opt[2].setText("JAMES GOSLING");opt[3].setText("BILAS PASCAL");
            
        }
        if(current==3)
        {
            l.setText("QUES 4: WHICH OF THE FOLLOWING ARE NOT JAVA KEYWORD?");
            opt[0].setText("DOUBLE");opt[1].setText("THEN");opt[2].setText("SWITCH");opt[3].setText("instanceOf");
        }
        if(current==4)
        {
            l.setText("QUES 5: 30/0 IS WHICH TYPE OF EXCEPTION?");
            opt[0].setText("NULLPOINTER EXCEPTION");opt[1].setText("OUTOFBOUNDEXCEPTION");opt[2].setText("CLASSNOTFOUND");opt[3].setText("ARITHMETICEXCEPTION");
        }
         
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1)
        {
            if(check())
            {
                count=count+1;//it will give us the marks obtained
            }
            current++;//to switch to next question
            setQuestion();
            if(current==4)//we have started current from 0
            {
                b1.setVisible(false);
                add(b2);   
            }   
        }
        else if(e.getSource()==b2)     
            {
                    JOptionPane.showMessageDialog(this,"Total Correct Answers:"+count);
                    System.exit(0);//terminates the program
            }
    }    
}
