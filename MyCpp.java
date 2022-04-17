
package miniproject;
import javax.swing.*;
import java.awt.event.*;
class MyCpp extends JFrame implements ActionListener{
JLabel l1;
JRadioButton rb[]=new JRadioButton[4];
JButton b1=new JButton("Next");
JButton b2;
ButtonGroup bg;  //to make sure only one option is selected
int count=0;
int cur=0;
MyCpp()
{
    int bound=120;  //used in the for loop to set bounds of radio buttons
    setTitle("Online Test of C++");
    bg=new ButtonGroup();
    l1=new JLabel();
    for(int i=0;i<4;i++)
    {
        rb[i]=new JRadioButton();
        add(rb[i]);
        bg.add(rb[i]);
    }
    l1.setBounds(30,40,600,20);
    for(int i=0;i<4;i++)
    {
        rb[i].setBounds(30,bound,100,30);
        bound=bound+40;
    }
    add(b1);add(l1);
    b1.addActionListener(this);
    b1.setBounds(150,300,100,30);
    setQuestion(cur);  //set question number 0
    setLayout(null);
    setVisible(true);
    setSize(600,400);
    setTitle("C++ EXAM");
    setDefaultCloseOperation(EXIT_ON_CLOSE); //closes the frame on pressing x
}
void setQuestion(int cur)
{
    if(cur ==0)
    {
        l1.setText("QUES 1: Which of the following is the address of operator?");
        rb[0].setText("*");rb[1].setText("&");rb[2].setText("!");rb[3].setText("#");
    }
    if(cur==1)
    {
        l1.setText("QUES 2: OBJECT CREATED USING NEW OPERATOR IS STORED IN WHICH MEMORY?");
        rb[0].setText("STACK"); rb[1].setText("CACHE");rb[2].setText("HEAP");rb[3].setText("None of the above");
    }
    if(cur==2)
    {
        l1.setText("QUES 3: Which of the following represents 2nd element of an array?");
        rb[0].setText("arr[1]");rb[1].setText("arr[5]");rb[2].setText("arr[3]");rb[3].setText("arr[2]");
    }
    if(cur==3)
    {
        l1.setText("QUES 4: Which of the following members are directly accessible outside class?");
        rb[0].setText("Public");rb[1].setText("Private");rb[2].setText("Protected");rb[3].setText("None");
    }
    if(cur==4)
    {
        l1.setText("QUES 5: Which of the follwing is not a kind of inheritance?");
        rb[0].setText("Multiple");rb[1].setText("Multilevel");rb[2].setText("Single");rb[3].setText("Distributed");
    }
}
    @Override
    public void actionPerformed(ActionEvent e) //When we click on next, the answer is checked
    {
        if(e.getSource()==b1)
        {
        if(correctAns(cur))
            count++;  //count is incremented if answer is correct
        cur++;  //to move to next question
        setQuestion(cur); //
        }
        else if(e.getSource()==b2)
        {
            JOptionPane.showMessageDialog(this,"Total Correct Answers:"+count); 
            System.exit(0);
        }
    }
    boolean correctAns(int cur)
    {
        if(cur==0)
            return(rb[1].isSelected());
        else if(cur==1)
            return(rb[2].isSelected());
        else if(cur==2)
            return(rb[0].isSelected());
        else if(cur==3)
            return(rb[0].isSelected());
        else 
        {
            b1.setVisible(false); 
            b2=new JButton("Result");
            add(b2);
            b2.setBounds(150,300,100,30);
            b2.addActionListener(this);
            return(rb[3].isSelected());    
        }
    }
}