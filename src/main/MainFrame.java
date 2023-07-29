package main;

// Source File Name:  frist frame

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class MainFrame extends JFrame implements ActionListener
{
JLabel title;
JButton sender;
JButton receiver;
JButton exit;


MainFrame()
{
setLayout(null);
setResizable(false);
getContentPane().setBackground(Color.pink);
JLabel ig=new JLabel(new ImageIcon(System.getProperty("user.dir")+"\\g8.jpg"));
 ig.setBounds(00,00,1000,700);
title= new JLabel("FILE SECURITY SYSTEM");
title.setFont(new Font("ALGERIAN",Font.BOLD,65)); 
title.setForeground(Color.red);
title.setBounds(150,60,800,70);
sender = new JButton("Sender");
sender.setForeground(Color.magenta);
sender.setFont(new Font("ALGERIAN",Font.BOLD,35)); 
receiver = new JButton("Receiver");
receiver.setForeground(Color.magenta);
receiver.setFont(new Font("ALGERIAN",Font.BOLD,35)); 
exit = new JButton("Exit");
exit.setForeground(Color.magenta);
exit.setFont(new Font("ALGERIAN",Font.BOLD,35));
sender.setBounds(300,150,300,50);
receiver.setBounds(300,350,300,50);
exit.setBounds(300,550,300,50);
add(title);
add(sender);
add(receiver);
add(exit);
add(ig);
sender.addActionListener(this);
receiver.addActionListener(this);
exit.addActionListener(this);
}

public void actionPerformed(ActionEvent actionevent)
{
String s = actionevent.getActionCommand();
if(s.equals("Sender"))
{	
encrypt v= new encrypt();
v.setTitle("encryption");
v.setResizable(false);
v.setBounds(00,00,1000,700);
v.setVisible(true);

   }
  else if(s.equals("Receiver"))
  {
   decrypt v  = new decrypt();
   v.setResizable(false);
   v.setBounds(00,00,1000,700);
   v.setVisible(true);
     
  }      else if(s.equals("Exit"))
    setVisible(false);
}

}