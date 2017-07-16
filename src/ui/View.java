package ui;

import java.awt.Font;

import mainpart.Init;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View extends JFrame {
	/**
	 * ʵ�ִ��ڻ�
	 */
	private static final long serialVersionUID = -30969714760891598L;
	private JFrame frame; // ������
	private JButton submit; // �ύ��ť
	private JButton remove; // ɾ����ť
	private JTextArea input; // �����
	private static JTextArea output; // �����

	public View() {
		initwin();
	}

	// ������������
	public static void setOut(String s) {
		output.append(s);
		output.setCaretPosition(output.getDocument().getLength());
	}

	// ���ڳ�ʼ��
	private void initwin() {
		frame = new JFrame();
		submit = new JButton("input");
		remove = new JButton("clear");
		input = new JTextArea();
		output = new JTextArea();

		// ������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 900);
		frame.getContentPane().setLayout(null);
		frame.setTitle("myDbms");
		frame.setLocationRelativeTo(null);
		// JPanel panel = new JPanel();
		// panel.setLayout(new GridLayout());
		// frame.add(panel);

		// �ύ��ť
		submit.setBounds(300, 120, 100, 50);
		submit.addActionListener(new listensubmit());
		frame.add(submit);

		// ɾ����ť
		remove.setBounds(800, 120, 100, 50);
		remove.addActionListener(new listenremove());
		frame.add(remove);

		// �����
		output.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 24));
		// int len = output.getText().length();
		// output.setCaretPosition(len);
		JScrollPane jsp2 = new JScrollPane(output);
		jsp2.setAutoscrolls(true);
		jsp2.setBounds(100, 200, 1000, 600);
		// Point p = new Point();
		// p.setLocation(100, output.getLineCount() * 100);
		// jsp2.getViewport().setViewPosition(p);
		frame.add(jsp2);

		// �����
		input.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 17));
		
		// �����Enter������
		input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String sql = input.getText();
					sql = sql.trim();
					if (sql.isEmpty())
						return;
					if (sql.charAt(sql.length() - 1) != ';') {
						Init.handleSql(sql);
						input.setText("");
					}
				}
			}
		});
		
		JScrollPane jsp1 = new JScrollPane(input);
		jsp1.setAutoscrolls(true);
		jsp1.setBounds(100, 50, 1000, 50);

		frame.add(jsp1);

		// ��ʾ����
		frame.setVisible(true);
	}

	// ������ť�¼�
	// �ύ
	private class listensubmit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String sql = input.getText();
			if (!sql.equals("")) {
				Init.handleSql(sql);
				input.setText("");
			}
		}
	}

	// ɾ��
	private class listenremove implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			input.setText("");
			output.setText("");
		}
	}

}
