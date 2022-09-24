import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ServerUser {

	private JFrame frmServeruser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerUser window = new ServerUser();
					window.frmServeruser.setVisible(true);
					window.frmServeruser.setLocation(150,250);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServerUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServeruser = new JFrame();
		frmServeruser.setTitle("ServerUser");
		frmServeruser.setResizable(false);
		frmServeruser.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmServeruser.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 382, 330, 70);
		frmServeruser.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 13, 219, 36);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton.setBounds(239, 11, 72, 36);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(44, 44, 44));
		panel_1.setBounds(0, 0, 330, 50);
		frmServeruser.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Server User");
		lblNewLabel.setFont(new Font("Garamond", Font.BOLD, 22));
		lblNewLabel.setEnabled(true);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(33, 10, 190, 30);
		panel_1.add(lblNewLabel);
		frmServeruser.setBounds(100, 100, 330, 480);
		frmServeruser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
