import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.net.*;

public class ServerUser {

	private JFrame frmServeruser;
	private JTextField textArea;
	private JPanel panel;
	private static JPanel panel_2;
	private static Box verticalBox = Box.createVerticalBox();
	private static DataOutputStream outData;
	
	private static JPanel FormatPanel(String x) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		Calendar today = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); 
		
		JLabel out = new JLabel(x);
		out.setFont(new Font("SansSerif",Font.PLAIN,16));
		out.setForeground(Color.WHITE);
		out.setBackground(new Color(120,121,120));
		out.setOpaque(true);
		out.setBorder(new EmptyBorder(15,15,15,50));
		
		JLabel time = new JLabel();
		time.setText(sdf.format(today.getTime()));
		
		panel.add(out);
		panel.add(time);
		
		return panel;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerUser window = new ServerUser();
					window.frmServeruser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			ServerSocket skt = new ServerSocket(6001);
			while(true) {
				Socket s = skt.accept();
				DataInputStream inData =  new DataInputStream(s.getInputStream());
				outData =new DataOutputStream(s.getOutputStream());
				
				while(true) {
					String msg = inData.readUTF();
					JPanel messagePanel = FormatPanel(msg);
					
					JPanel left = new JPanel(new BorderLayout());
					left.add(messagePanel,BorderLayout.LINE_START);
					
					verticalBox.add(left);
					verticalBox.add(Box.createVerticalStrut(20));
					
					panel_2.validate();
				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
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
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 499, 546, 93);
		frmServeruser.getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_2 = new JPanel(new BorderLayout());
		panel_2.setBounds(0, 58, 546, 442);
		frmServeruser.getContentPane().add(panel_2);
		
		textArea = new JTextField();
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textArea.setBounds(10, 28, 395, 36);
		panel.add(textArea);
		
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String sendtxt = textArea.getText();
				
					JPanel panel_3 = FormatPanel(sendtxt);
				
					JPanel right = new JPanel(new BorderLayout());
					right.add(panel_3,BorderLayout.LINE_END);
				
					verticalBox.add(right);
					verticalBox.add(Box.createVerticalStrut(20));
				
					panel_2.add(verticalBox,BorderLayout.PAGE_START);
				
					outData.writeUTF(sendtxt);
				
					textArea.setText("");
				
					panel_2.repaint();
					panel_2.invalidate();
					panel_2.validate();
					
				}catch(Exception se) {
					se.printStackTrace();
				}
				
			}
		});
		
		btnNewButton.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		btnNewButton.setBounds(440, 28, 72, 36);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(44, 44, 44));
		panel_1.setBounds(0, 0, 546, 54);
		frmServeruser.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Server User");
		lblNewLabel.setFont(new Font("Garamond", Font.BOLD, 22));
		lblNewLabel.setEnabled(true);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(75, 10, 353, 30);
		panel_1.add(lblNewLabel);
		
		
		frmServeruser.setBounds(100, 100, 550, 620);
		frmServeruser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
