package com.driverless.carpart;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.PRIVATE_MEMBER;

public class App extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		final DriverlessCar car = new DriverlessCar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 400, 500, 226);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(2, 2,0,0));
		setContentPane(contentPane);
		JTable table = new JTable(4, 4);
		final DefaultTableModel tableModel = (DefaultTableModel) table.getModel(); 
		tableModel.setValueAt("North", 3, 0); 
		contentPane.add(table, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton move = new JButton("move");
		move.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int beforePosX = car.getPositionX();
					int beforePosY = car.getPositionY();
					car.move();
					tableModel.setValueAt("", 4-beforePosY, beforePosX-1);
					tableModel.setValueAt(car.getOrientation(), 4-car.getPositionY(), car.getPositionX()-1); 
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		JButton clockwise = new JButton("clockwise");
		clockwise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				car.clockwise();
				tableModel.setValueAt(car.getOrientation(), 4-car.getPositionY(), car.getPositionX()-1); 
			}
		});
		menuBar.add(move);
		menuBar.add(clockwise);
	}

}
