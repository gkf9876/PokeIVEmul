package com.kdw.pokeivemul;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.kdw.pokeivemul.baseStats.service.BaseStatsService;
import com.kdw.pokeivemul.baseStats.vo.BaseStatsVo;

public class Frame2 extends JFrame{

	private JPanel panel1;
	private JPanel panel2;
	
	private JTextArea textArea1;
	private JScrollPane scrollPane1;

	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	
	private List<BaseStatsVo> list;

	public Frame2() {
		try {
			this.setTitle("스피드 빠른 순");
			this.setSize(500, 600);
			this.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			BaseStatsService service = new BaseStatsService();
			BaseStatsVo individualValueVo = new BaseStatsVo();
			list = service.selectList(individualValueVo);
			
			panel1 = new JPanel();
			//panel1.setPreferredSize(new Dimension(500, 600));
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
			for(BaseStatsVo vo : list) {
				JPanel panel = new JPanel();
				panel.setLayout(new FlowLayout(FlowLayout.LEFT));
				
				JLabel label1 = new JLabel();
				label1.setSize(100, 50);
				label1.setText(vo.getName());
				panel.add(label1);
				
				textField2 = new JTextField(4);
				textField2.setHorizontalAlignment(JTextField.CENTER);
				textField2.setText(Integer.toString(vo.getH()));
				panel.add(textField2);
				
				textField3 = new JTextField(4);
				textField3.setHorizontalAlignment(JTextField.CENTER);
				textField3.setText(Integer.toString(vo.getA()));
				panel.add(textField3);
				
				textField4 = new JTextField(4);
				textField4.setHorizontalAlignment(JTextField.CENTER);
				textField4.setText(Integer.toString(vo.getB()));
				panel.add(textField4);
				
				textField5 = new JTextField(4);
				textField5.setHorizontalAlignment(JTextField.CENTER);
				textField5.setText(Integer.toString(vo.getC()));
				panel.add(textField5);
				
				textField6 = new JTextField(4);
				textField6.setHorizontalAlignment(JTextField.CENTER);
				textField6.setText(Integer.toString(vo.getD()));
				panel.add(textField6);
				
				textField7 = new JTextField(4);
				textField7.setHorizontalAlignment(JTextField.CENTER);
				textField7.setText(Integer.toString(vo.getS()));
				panel.add(textField7);
				
				panel1.add(panel);
			}
			//panel1.setPreferredSize(new Dimension(400, 5000));
			scrollPane1 = new JScrollPane(panel1);
			panel1.setAutoscrolls(true);
			scrollPane1.setPreferredSize(new Dimension(450, 500));
			panel2 = new JPanel();
			panel2.add(scrollPane1);
			this.add(panel2);
			
			this.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
