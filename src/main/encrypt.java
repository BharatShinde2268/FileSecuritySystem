package main;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
class encrypt extends JFrame implements ActionListener
{
public JLabel title, select,l1;
public JButton open,enc; 
public JTextArea content=new JTextArea(500,500);;
JScrollPane sp=new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
public JTextField tf;
FileDialog fd=new FileDialog(this,"open",0);
DataOutputStream dos;
FileInputStream fis;
FileOutputStream fos;
encrypt()
{   
 setLayout(null); 
JLabel ig=new JLabel(new ImageIcon(System.getProperty("user.dir")+"\\e1.jpg"));
 ig.setBounds(00,00,1000,700);
 setTitle("encrypt");
 setDefaultCloseOperation(1);
 setVisible(true);
 setBounds(00,00,1000,700);
title=new JLabel("ENCRYPTION");
title.setFont(new Font("ALGERIAN",Font.BOLD,65));
title.setForeground(Color.red);
title.setBounds(300,10,800,70);
select=new JLabel("SELECT FILE :-  ");
select.setFont(new Font("ALGERIAN",Font.BOLD,35));
select.setForeground(Color.orange); 
select.setBounds(30,150,300,30);
open=new JButton("OPEN");
open.setFont(new Font("ALGERIAN",Font.BOLD,35));
open.setForeground(Color.magenta); 
open.setBounds(300,150,130,40); 
 tf=new JTextField(20); 
tf.setBounds(460,150,400,40);
tf.setFont(new Font(" ", Font.PLAIN, 35));
tf.setBackground(Color.lightGray);
 enc=new JButton("Encrypt");
enc.setFont(new Font("ALGERIAN",Font.BOLD,35));
enc.setForeground(Color.magenta); 
enc.setBounds(390,230,200,40);
content.setFont(new Font("Arial Rounded BT Bold",2,25));
content.setForeground(Color.black);
l1=new JLabel("FILE CONTENT :-  ");
l1.setFont(new Font("ALGERIAN",Font.BOLD,35));
l1.setBounds(200,300,350,40); 
l1.setForeground(Color.orange); 
 sp.setBounds(90,350,800,320);
  add(title);
   add(select);
   add(open);
   add(tf);
   add(enc);
   add(sp);
   add(l1);
   add(ig);
   open.addActionListener(this);
   enc.addActionListener(this);
    setResizable(false);
}

public void actionPerformed(ActionEvent e)
{
    String s="",t="",file="",pass="",pass1="";
  Object o=e.getSource();
  if(o==open)
  {
   fd.setVisible(true);
   tf.setText(fd.getDirectory()+fd.getFile());
   try
   	{
    fis=new FileInputStream((file=tf.getText()));
    Scanner sc=new Scanner(fis);
    content.setText("");
    for(int i=0;(s=sc.nextLine())!=null;i++)
    {
        content.append(s+" ");
   
            content.append("\n");
    }   
   }
   catch(Exception eds){}
  }
  else if(o==enc)
  {
      if(t.equals(content.getText()))
          JOptionPane.showMessageDialog(this,"please select file or enter data","error",2);
      else
      {
          pass=JOptionPane.showInputDialog(this, "enter password :-","set password",1);
        
          file=JOptionPane.showInputDialog(this, "enter file name to save encrypted data :-","save file",1);
          try{
          encrypt(content.getText(),pass,file+".txt");
          JOptionPane.showMessageDialog(this,"File saved","saved",1);
          this.dispose();
          }catch(Exception das){JOptionPane.showMessageDialog(this,file,"saved",1);}
      }          
  }
}
//action
 public void encrypt(String s,String pass,String file)throws FileNotFoundException,IOException
{
 JOptionPane.showMessageDialog(this,file,"saved",1);
   String s1="";
   FileOutputStream fos=new FileOutputStream(file);
   DataOutputStream dos=new DataOutputStream(fos);
   dos.writeBytes(pass+" "+(s.length()*222)+" ");
   for(int i=0;i<s.length();i++)
{
  s1=s1+("00000"+(s.codePointAt(i)+1)+"98745 ");
}
 dos.writeBytes(s1);
 dos.close();
 fos.close();
}
public static void main(String []asa)
{
   encrypt v= new encrypt();
v.setTitle("encryption");
v.setResizable(false);
v.setBounds(00,00,1000,700);
v.setVisible(true);
}
}