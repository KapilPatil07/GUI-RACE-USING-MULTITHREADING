/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sai
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;


public class GuiRace {
    JFrame frame=new JFrame();
    JProgressBar jp1=new JProgressBar();
    JProgressBar jp2=new JProgressBar();
    
    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable(){
            public void run()
            {
                try
                {
                    GuiRace window=new GuiRace();
                    window.frame.setVisible(true);
                    
                    
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public GuiRace()
    {
        initialize();
    }
    
    public void initialize()
    {
        frame=new JFrame();
        frame.setBounds(100, 100, 598, 430);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        jp1.setStringPainted(true);
        jp1.setForeground(Color.RED);
        jp1.setBounds(16, 249, 259, 14);
        frame.getContentPane().add(jp1);
        
        jp2.setStringPainted(true);
        jp2.setForeground(Color.BLUE);
        jp2.setBounds(313, 249, 259, 14);
        frame.getContentPane().add(jp2);
        
        JButton jb1=new JButton("");
        jb1.setIcon(new ImageIcon(GuiRace.class.getResource("/images/india-hd-background-2048x1536 (1).jpg")));
        jb1.setBounds(16,11,259,194);
        frame.getContentPane().add(jb1);
        
        
        JButton jb2=new JButton("");
        jb2.setIcon(new ImageIcon(GuiRace.class.getResource("/images/india-hd-background-2048x1536 (1).jpg")));
        jb2.setBounds(313,11,259,194);
        frame.getContentPane().add(jb2);
        
        JButton st=new JButton("START");
        st.setFont(new Font("Tahoma",Font.PLAIN,18));
        st.addActionListener(new StartRace());
        
        st.setBounds(213, 287,155, 78);
        frame.getContentPane().add(st);
   }
    
    class StartRace implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0)
        {
            knight kit=new knight();
            kit.start();
            
            Bat runBat=new Bat();
            Thread myBat=new Thread(runBat);
            myBat.start();
        }
    }
    
    
    class Bat implements Runnable
    {
        public void run()
        {
            for(int i=0;i<101;i++)
            {
                jp2.setValue(i);
                jp2.repaint();
                jp2.setString(Integer.toString(i)+ "%");
                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException err)
                {
                    err.printStackTrace();
                }
            }
        }
    }

    
     class knight extends Thread
    {
        public void run()
        {
            for(int i=0;i<101;i++)
            {
                jp1.setValue(i);
                jp1.repaint();
                jp1.setString(Integer.toString(i)+ "%");
                try
                {
                    Thread.sleep(50);
                }
                catch(InterruptedException err)
                {
                    err.printStackTrace();
                }
            }
        }
    }
    }
