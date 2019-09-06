package client;

import utility.ClientData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CleintFrom extends JFrame {
    JLabel L1,L2,L3;
    JTextField t1,t2,t3;
    JButton b1;
    JPanel p1;

    public CleintFrom(){
        setVisible(true);
        setSize(300,200);
        setTitle("Client Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1 = new JPanel();
        L1 = new JLabel("Email");
        L2 = new JLabel("Name");
        L3 = new JLabel("Mobile");
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        b1 = new JButton("Submit");
        p1.add(L1);
        p1.add(t1);
        p1.add(L2);
        p1.add(t2);
        p1.add(L3);
        p1.add(t3);
        p1.add(b1);
        getContentPane().add(p1);

        p1.setBorder(BorderFactory.createTitledBorder("Client From"));
        b1.addActionListener(e->b1Click(e));

    }
    public void b1Click(ActionEvent e){
        try{
            Socket s = new Socket("localhost",8880);
            ObjectOutputStream ois = new ObjectOutputStream(s.getOutputStream());
            ClientData obj = new ClientData();
            obj.email = t1.getText();
            obj.name = t1.getText();
            obj.mobile = t1.getText();
            ois.writeObject(obj);
            ois.close();
            s.close();
            JOptionPane.showMessageDialog(null,"Data Sent");
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new CleintFrom();
    }
}
