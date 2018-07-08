package Interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedList;

import FizzBuzzCore.*;

import javax.swing.*;

public class GUI {
	
	private static String rulestring;
	private static LinkedList<Buzzword> buzzwords;

	public static void start() {
		JFrame mainframe = new JFrame("FizzBuzz++");
		mainframe.setSize(400, 300);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setResizable(false);
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new GridBagLayout());
        mainframe.add(mainpanel);
        JLabel instructions = new JLabel("Enter Text and Number, add rule. Clear to start over.");
        
        JTextField wordentry = new JTextField();
        wordentry.setToolTipText("Text goes here");
        wordentry.setText("Fizz");
        
        JTextField numentry = new JTextField();
        numentry.setToolTipText("Number goes here");
        numentry.setText("3");
        
        JButton add = new JButton("Add Rule");
        JButton clear = new JButton("Clear Rules");
        JButton run = new JButton("Run");
        
        JTextArea ruleview = new JTextArea();
        ruleview.setEditable(false);
        
        
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.ipady = 20;
        mainpanel.add(instructions, c);
        c.gridy = 1;
        c.gridwidth = 2;
        mainpanel.add(wordentry, c);
        c.gridx = 2;
        c.gridwidth = 1;
        mainpanel.add(numentry, c);
        c.gridy = 2;
        c.gridx = 0;
        mainpanel.add(add, c);
        c.gridx = 1;
        mainpanel.add(clear, c);
        c.gridx = 2;
        mainpanel.add(run, c);
        c.gridy = 3;
        c.gridx = 0;
        c.gridheight = 2;
        c.gridwidth = 3;
        mainpanel.add(ruleview, c);
        
        
        rulestring = new String("");
        buzzwords = new LinkedList<Buzzword>();
        
        mainframe.setVisible(true);
	}
}
