package Maze;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Panel{
	
	public JFrame frame;
	public JButton open;
	public JButton action;
	public JButton save;
	public JButton exit;
	public JTextArea textA;
	Main main;
	
	
	
	public Panel(){
		frame = new JFrame("Лабиринт: поиск кратчайшего пути");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PathActionListener actionListener = new PathActionListener(this); 
		GridBagLayout gbl = new GridBagLayout();
		frame.getContentPane().setLayout(gbl);
		
		
		GridBagConstraints  gb1 = new GridBagConstraints();
		gb1.gridx = 0;
		gb1.gridy = 0;
		gb1.gridheight = 4;
		gb1.gridwidth = 2;
		
		textA =  new JTextArea(12,15);
		textA.setText("Выбирите файл");
                textA.setLineWrap(true); 
                textA.setWrapStyleWord(true);
		gbl.setConstraints(textA, gb1);
		frame.getContentPane().add(textA);
		
		GridBagConstraints  gb2 = new GridBagConstraints();
		gb2.gridx = 2;
		gb2.gridy = 0;
		
		gb2.fill = gb1.HORIZONTAL;
		
		//окрыть файл
		open = new JButton("Открыть файл");
                
		gbl.setConstraints(open, gb2);
		frame.getContentPane().add(open);
		open.addActionListener(actionListener);
		open.setPreferredSize(new Dimension(170,50));
		GridBagConstraints  gb3 = new GridBagConstraints();
		gb3.gridx = 2;
		gb3.gridy = 1;
		gb3.fill = gb3.HORIZONTAL;
		
		// поиск пути
		action = new JButton("Найти путь");
                action.setPreferredSize(new Dimension(150,50));
		gbl.setConstraints(action, gb3);
		frame.getContentPane().add(action);
		action.addActionListener(actionListener);
		
		GridBagConstraints  gb4 = new GridBagConstraints();
		gb4.gridx = 2;
		gb4.gridy = 2;
		gb4.fill = gb4.HORIZONTAL;
		//сохранение
		save = new JButton("Сохранить результат");
                save.setPreferredSize(new Dimension(150,50));
		gbl.setConstraints(save, gb4);
		frame.getContentPane().add(save);
		save.addActionListener(actionListener);
		
		GridBagConstraints  gb5 = new GridBagConstraints();
		gb5.gridx = 2;
		gb5.gridy = 3;
		gb5.fill = gb5.HORIZONTAL;
		
		exit = new JButton("Выход");
                exit.setPreferredSize(new Dimension(100,50));
		gbl.setConstraints(exit, gb5);
		frame.getContentPane().add(exit);
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                 frame.dispose();
			}
		});
		frame.setVisible(true);
	
		
 	}
	
	public void setDisplayValue(String str){
		textA.setText(str);
	}
	
	
}
