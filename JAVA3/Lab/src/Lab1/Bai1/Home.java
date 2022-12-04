/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1.Bai1;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Home extends JFrame{
    
    
     
    private JLabel lblHead;
    private JLabel lblStatus;
    private JPanel pnlControl;
    
    
    
    public Home() {
        
        setTitle("Ví dụ Java Swing");
        setSize(450,300);
        setLayout(new GridLayout(3,1));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        lblHead = new JLabel("Control in action: CheckBox", JLabel.CENTER);
        add(lblHead);
        
        lblStatus = new JLabel("Apple Checkbox: Checked" , JLabel.CENTER);
        
        
        
        pnlControl = new JPanel();
        pnlControl.setLayout(new FlowLayout());
        add(pnlControl);
        add(lblStatus);
        
        checkBox();
    }
    
    public void checkBox(){
        JCheckBox chkApple = new JCheckBox("Apple");
        JCheckBox chkMango = new JCheckBox("Mango");
        JCheckBox chkPeer = new JCheckBox("Peer");
        chkApple.setMnemonic(KeyEvent.VK_C);
        chkMango.setMnemonic(KeyEvent.VK_M);
        chkPeer.setMnemonic(KeyEvent.VK_P);
        
        chkApple.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lblStatus.setText("Apple Checkbox: " + (e.getStateChange()==1?"Checked":"UnChecked"));
            }
        });
        
        chkMango.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lblStatus.setText("Mango Checkbox: " + (e.getStateChange()==1?"Checked":"UnChecked"));
            }
        });
        chkPeer.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lblStatus.setText("Peer Checkbox: " + (e.getStateChange()==1?"Checked":"UnChecked"));
            }
        });
        
        
        
        pnlControl.add(chkApple);
        pnlControl.add(chkMango);
        pnlControl.add(chkPeer);
    }
    
    
    public static void main(String[] args) {
        new Home().setVisible(true);
    }
    
}
