package com.kdw.pokeivemul;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.kdw.pokeivemul.IndividualValue.service.IndividualValueService;
import com.kdw.pokeivemul.IndividualValue.vo.IndividualValueVo;

public class Frame1 extends JFrame{

	private Frame2 frame2;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private JComboBox<String> comboBox1;
	
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	
	private JTextArea textArea1;
	
	private JButton button1;
	
	private List<IndividualValueVo> list;
	
	public Frame1() {
		try {
			this.setTitle("TestUI");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(500, 600);
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			IndividualValueService service = new IndividualValueService();
			IndividualValueVo individualValueVo = new IndividualValueVo();
			list = service.selectList(individualValueVo);
			
			
			panel1 = new JPanel();
			panel1.setLayout(new FlowLayout());
			
			comboBox1 = new JComboBox<String>();
			comboBox1.addItem("선택");
			for(IndividualValueVo vo : list) {
				comboBox1.addItem(vo.getName());
			}
			
			comboBox1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox<String> cb=(JComboBox<String>)e.getSource();
					int index=cb.getSelectedIndex();
					String name = (String)cb.getSelectedItem();
					
					if(index > 0) {
						IndividualValueVo vo = list.get(index - 1);
						textField1.setText(String.valueOf(vo.getH()));
						textField2.setText(String.valueOf(vo.getA()));
						textField3.setText(String.valueOf(vo.getB()));
						textField4.setText(String.valueOf(vo.getC()));
						textField5.setText(String.valueOf(vo.getD()));
						textField6.setText(String.valueOf(vo.getS()));
						
						textArea1.setText("");
						textArea1.append("체력(H) : " + vo.getH() + "\n");
						textArea1.append("공격(A) : " + vo.getA() + "\n");
						textArea1.append("방어(B) : " + vo.getB() + "\n");
						textArea1.append("특수공격(C) : " + vo.getC() + "\n");
						textArea1.append("특수방어(D) : " + vo.getD() + "\n");
						textArea1.append("스피드(S) : " + vo.getS() + "\n");
					}else {
						textField1.setText("0");
						textField2.setText("0");
						textField3.setText("0");
						textField4.setText("0");
						textField5.setText("0");
						textField6.setText("0");
					}
				}
			});
			panel1.add(comboBox1);
			
			textField1 = new JTextField(4);
			textField1.setHorizontalAlignment(JTextField.CENTER);
			textField1.setText("0");
			panel1.add(textField1);
			
			textField2 = new JTextField(4);
			textField2.setHorizontalAlignment(JTextField.CENTER);
			textField2.setText("0");
			panel1.add(textField2);
			
			textField3 = new JTextField(4);
			textField3.setHorizontalAlignment(JTextField.CENTER);
			textField3.setText("0");
			panel1.add(textField3);
			
			textField4 = new JTextField(4);
			textField4.setHorizontalAlignment(JTextField.CENTER);
			textField4.setText("0");
			panel1.add(textField4);
			
			textField5 = new JTextField(4);
			textField5.setHorizontalAlignment(JTextField.CENTER);
			textField5.setText("0");
			panel1.add(textField5);
			
			textField6 = new JTextField(4);
			textField6.setHorizontalAlignment(JTextField.CENTER);
			textField6.setText("0");
			panel1.add(textField6);
			
			this.add(panel1);
			
			panel2 = new JPanel();
			panel2.setSize(500, 500);
			textArea1 = new JTextArea("콤보박스를 선택하세요.", 25, 35);
			panel2.add(textArea1);
			this.add(panel2);
			
			panel3 = new JPanel();
			panel3.setSize(500, 300);
			frame2 = new Frame2();
			button1 = new JButton("스피드 빠른순");
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame2.setVisible(true);
				}
			});
			panel3.add(button1);
			this.add(panel3);
			
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
