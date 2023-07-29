package main;

// frist frame
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.*;
class FirstFrame extends JFrame implements ActionListener
{
TextField username;
TextField password;
JLabel unamel,title;
JLabel pwordl;
JButton submit;
JButton cancel;
Container c;
static FileInputStream fis;
static FileOutputStream fos;
static Scanner s;
static DataOutputStream dos;
static String user,pass;
FirstFrame()
{
setLayout(null);
setResizable(false);
getContentPane().setBackground(Color.pink);
JLabel ig=new JLabel(new ImageIcon(System.getProperty("user.dir")+"\\f1.jpg"));
title= new JLabel("FILE SECURITY SYSTEM");
title.setFont(new Font("ALGERIAN",Font.BOLD,65));
title.setForeground(Color.red);
title.setBounds(120,60,800,70);
unamel = new JLabel("USER NAME:-");
unamel.setForeground(Color.orange); 
unamel.setFont(new Font("ALGERIAN",Font.BOLD,35));
unamel.setBounds(200,200,300,40);
pwordl = new JLabel("PASSWORD:-");
pwordl.setForeground(Color.orange);

pwordl.setFont(new Font("ALGERIAN",Font.BOLD,35));
pwordl.setBounds(200,300,300,40);
username = new TextField(10);
password = new TextField(10);
password.setEchoChar('*');
add(username);
add(password);
username.setBounds(430,205,200,40);
username.setFont(new Font(" ", Font.PLAIN, 30));
username.setBackground(Color.lightGray);
password.setBounds(430,305,200,40);
password.setFont(new Font(" ", Font.PLAIN, 30));
password.setBackground(Color.lightGray);
submit = new JButton("Submit");
cancel = new JButton("Cancel");
submit.setForeground(Color.magenta);
submit.setBackground(Color.lightGray);  
cancel.setForeground(Color.magenta);
cancel.setBackground(Color.lightGray);
submit.setFont(new Font("ALGERIAN",Font.BOLD,35));
cancel.setFont(new Font("ALGERIAN",Font.BOLD,35));
submit.setBounds(260,450,200,40);
cancel.setBounds(500,450,200,40);
add(title);
add(unamel);
add(pwordl);
add(submit);
add(cancel);
add(ig);
ig.setBounds(00,00,1000,700);
username.addActionListener(this);
password.addActionListener(this);
cancel.addActionListener(this);
submit.addActionListener(this);

}
public void actionPerformed(ActionEvent actionevent)
{
String s = actionevent.getActionCommand();
String s1 = username.getText();
String s2 = password.getText();
if(s.equals("Submit"))
{
if(s1.equals(user) && s2.equals(pass))
{ 
setVisible(false);
MainFrame r = new MainFrame();
r.setTitle("FILE SECURITY SYSTEM");
r.setResizable(false);
r.setBounds(00,00,1000,700);
r.setVisible(true);

}
else 
{           
JOptionPane.showMessageDialog(this, "Unauthorised User", "Message", 3);
} 

}
else if(s.equals("Cancel"))
setVisible(false);
}
public static void main(String args[])
{
FirstFrame firstframe = new FirstFrame();
firstframe.setVisible(true);
firstframe.setResizable(false);
firstframe.setBounds(00,00,1000,700);
firstframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
try
{
fis=new FileInputStream("login.txt");
s=new Scanner(fis);
user=s.next();
pass=s.next();
}
catch(Exception e)
{
user=JOptionPane.showInputDialog(firstframe, "Set user name :-", "set name",3);
pass=JOptionPane.showInputDialog(firstframe, "Set password :-", "set password",3);
try
{
 fos=new FileOutputStream("login.txt");
 dos=new DataOutputStream(fos);
 dos.writeBytes(user+" ");
 dos.writeBytes(pass);
 dos.close();
 fos.close();
}catch(Exception ex){}
}
}
}