package java2020EndProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;

public class WorkRecord extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkRecord frame = new WorkRecord();
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
	public WorkRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB098\uC758 \uC791\uC5C5\uB0B4\uC5ED");
		lblNewLabel.setBounds(159, 10, 97, 30);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(22, 50, 389, 350);
		contentPane.add(table);
		
		btnNewButton = new JButton("\uC885\uB8CC");
		btnNewButton.setBounds(314, 408, 97, 23);
		contentPane.add(btnNewButton);
	}

}
