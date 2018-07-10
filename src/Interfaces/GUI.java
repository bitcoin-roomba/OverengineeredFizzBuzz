package Interfaces;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import FizzBuzzCore.*;

import javax.swing.*;

public class GUI {
	
	private static String rulestring;
	private static LinkedList<Buzzword> buzzwords;

	public static void start() {
		JFrame mainframe = new JFrame("FizzBuzz++");
		mainframe.setSize(500, 300);
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
        
        JTextField start = new JTextField();
        start.setToolTipText("start of intervall");
        start.setText("1");
        
        JTextField end = new JTextField();
        end.setToolTipText("end of intervall");
        end.setText("100");
        
        JButton add = new JButton("Add Rule");
        JButton clear = new JButton("Clear Rules");
        JButton run = new JButton("Run");
        
        JTextArea ruleview = new JTextArea();
        ruleview.setEditable(false);
        JScrollPane rulepane = new JScrollPane(ruleview);
        
        
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.ipady = 20;
        mainpanel.add(instructions, c);
        c.gridwidth = 1;
        c.gridx = 2;
        mainpanel.add(start, c);
        c.gridx = 3;
        mainpanel.add(end, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        mainpanel.add(wordentry, c);
        c.gridx = 3;
        c.gridwidth = 1;
        mainpanel.add(numentry, c);
        c.gridy = 2;
        c.gridx = 0;
        mainpanel.add(add, c);
        c.gridx = 1;
        mainpanel.add(clear, c);
        c.gridx = 2;
        c.gridwidth = 2;
        mainpanel.add(run, c);
        c.gridy = 3;
        c.gridx = 0;
        c.gridheight = 2;
        c.gridwidth = 4;
        c.ipady = 100;
        mainpanel.add(rulepane, c);
        
        
        rulestring = new String("");
        buzzwords = new LinkedList<Buzzword>();
        
        add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Integer.parseInt(numentry.getText());
				}
				catch(NumberFormatException ex) {
					//invalid number
					return;
				}
				try {
					buzzwords.add(new Buzzword(Integer.parseInt(numentry.getText()), wordentry.getText()));
				}
				catch(IllegalArgumentException ex){
					//cannot add zero rule
					return;
				}
				rulestring = rulestring.concat(numentry.getText() + " | " + wordentry.getText() + "\n");
				ruleview.setText(rulestring);
				wordentry.setText("");
				numentry.setText("");
			}
        	
        });
        
        clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rulestring = new String("");
				buzzwords = new LinkedList<Buzzword>();
				ruleview.setText(rulestring);
				wordentry.setText("Fizz");
				numentry.setText("3");
			}
        	
        });
        
        run.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Integer.parseInt(start.getText());
					Integer.parseInt(end.getText());
				}
				catch(NumberFormatException nfe) {
					//invalid interval
					return;
				}
				if (Integer.parseInt(start.getText()) > Integer.parseInt(end.getText())) {
					//start > end
					return;
				}
				LinkedList<String> out = new FizzBuzz(Integer.parseInt(start.getText()), Integer.parseInt(end.getText()), buzzwords).getOutput();
				JFrame outputframe = new JFrame("Output");
				outputframe.setSize(400, 400);
				outputframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				JPanel outpane = new JPanel();
				outpane.setLayout(new BorderLayout());
				JTextArea output = new JTextArea("");
				output.setEditable(false);
				JScrollPane outscroll = new JScrollPane(output);
				outputframe.add(outpane);
				outpane.add(outscroll, BorderLayout.CENTER);
				
				outputframe.setVisible(true);
				
				for (String x : out) {
					output.setText(output.getText().concat(x).concat("\n"));
				}
			}
        	
        });
        
        mainframe.setVisible(true);
	}
}
