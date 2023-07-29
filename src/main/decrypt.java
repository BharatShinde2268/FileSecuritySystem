package main;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
class decrypt extends JFrame implements ActionListener
{
public JTextArea content=new JTextArea(500,500);;
JScrollPane sp=new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
JLabel title;
JLabel select;
JButton open,dec,save;
JTextField tf;    
FileDialog fd=new FileDialog(this,"open",0);
FileDialog fd1;
DataOutputStream dos;
FileInputStream fis;
FileOutputStream fos;
String decstr="null";
decrypt()
{
    setLayout(null); 
  setResizable(false);
 getContentPane().setBackground(Color.pink);
 JLabel ig=new JLabel(new ImageIcon(System.getProperty("user.dir")+"\\d1.jpg"));
 ig.setBounds(00,00,1000,700);
 setTitle("Decrypt");
 setDefaultCloseOperation(1);
 setVisible(true);
 setBounds(00,00,1000,700);
title=new JLabel("DECRYPTION");
title.setFont(new Font("ALGERIAN",Font.BOLD,65));
title.setForeground(Color.red);
title.setBounds(300,10,800,70);
select=new JLabel("SELECT FILE :-  ");
select.setFont(new Font("ALGERIAN",Font.BOLD,35));
select.setBounds(30,150,300,30);
select.setForeground(Color.orange); 
 open=new JButton("OPEN");
open.setFont(new Font("ALGERIAN",Font.BOLD,35));
open.setForeground(Color.magenta); 
open.setBounds(300,150,150,40); 
 tf=new JTextField(20); 
tf.setBounds(455,150,400,40);
tf.setFont(new Font(" ", Font.PLAIN, 30));
tf.setBackground(Color.lightGray);
tf.setForeground(Color.black); 
dec=new JButton("Decrypt");
dec.setFont(new Font("ALGERIAN",Font.BOLD,35));
dec.setBounds(300,230,200,40);
dec.setForeground(Color.magenta); 
content.setFont(new Font("Arial Rounded BT Bold",2,25));
content.setForeground(Color.black);
sp.setBounds(90,350,800,320);
JLabel l1=new JLabel("FILE CONTENT :-  ");
l1.setFont(new Font("ALGERIAN",Font.BOLD,35));
l1.setBounds(200,300,350,40);
l1.setForeground(Color.orange); 
save=new JButton("Save");
save.setFont(new Font("ALGERIAN",Font.BOLD,35));
save.setBounds(530,230,150,40);
save.setForeground(Color.magenta); 
   add(title);
   add(select);
   add(open);
   add(tf);
   add(dec);
   add(l1);
   add(sp);
   add(save);
   add(ig);
   open.addActionListener(this);
   dec.addActionListener(this);
   save.addActionListener(this);
   
}
public void actionPerformed(ActionEvent e)
	{
    String s="",t="",file="",pass="",savefile="";
  Object o=e.getSource();
  if(o==open)
  {
   fd.setVisible(true);
   tf.setText(fd.getDirectory()+fd.getFile());
   try{
    fis=new FileInputStream((file=tf.getText()));
    Scanner sc=new Scanner(fis);
    content.setText("");
    for(int i=0;(s=sc.nextLine())!=null;i++)
    {
        content.append(s+" ");
   
            content.append("\n");
    }   
   }catch(Exception eds){}
  }
  else if(o==dec)
  {
      if(t.equals(content.getText()))
          JOptionPane.showMessageDialog(this,"please select file","error",2);
      else
      {
         
          try{
          decstr=decrypt();
          }catch(Exception das){}
      }          
  }
  else if(o==save)
  {
     fd1=new FileDialog(this,"save",1);
          fd1.setVisible(true);
          savefile=fd1.getDirectory()+fd1.getFile();
          try{
       fos=new FileOutputStream(savefile);
       dos=new DataOutputStream(fos);
       dos.writeBytes(decstr);
       dos.close();
      fos.close();
      JOptionPane.showMessageDialog(this, "File saved !","saved",1);
      this.dispose();
          }catch(Exception ex){ }
  }
}
//action
public String decrypt()
{
   String s="",pass="",pass1="";
   int t=0,i=0;
   try{
   FileInputStream fis=new FileInputStream(tf.getText());
   
   Scanner sc=new Scanner(fis);
   pass=sc.next();
    pass1=JOptionPane.showInputDialog(this, "enter password :-","confirm password",1);
    if(pass1.equals(pass))
    {    
        JOptionPane.showMessageDialog(this, "Correct password !","correct",1);
        content.setText("");
   int n=sc.nextInt();
   n=n/222;
   char a[]=new char[n+1];
   for(i=0;i<n;i++)
   {
      t=sc.nextInt();
      t=t/100000;
      a[i]=(char)(t-1);
      s=s+a[i];
   }    
   fis.close();
   
   content.setText(s);
   return s;
    }
    
    else 
    {
      JOptionPane.showMessageDialog(this, "Incorrect password !","incorrect",0);
        return "null";
    }
    }catch(Exception ex){JOptionPane.showMessageDialog(this, "file opening error !","correct",1);}
   return "null";
}  

public static void main(String []as)
{
 decrypt v= new decrypt();
v.setTitle("decryption");
v.setResizable(false);
v.setBounds(00,00,1000,700);
v.setVisible(true);
}
}