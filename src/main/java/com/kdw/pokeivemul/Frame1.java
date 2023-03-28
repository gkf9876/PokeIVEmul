package com.kdw.pokeivemul;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.kdw.pokeivemul.IndividualValue.service.IndividualValueService;
import com.kdw.pokeivemul.IndividualValue.vo.IndividualValueVo;
import com.kdw.pokeivemul.Nature.service.NatureService;
import com.kdw.pokeivemul.Nature.vo.NatureVo;

public class Frame1 extends JFrame{

	private Frame2 frame2;
	
	private JPanel panel1;
	private JPanel panel11;
	private JPanel panel12;
	private JPanel panel22;
	private JPanel panel2;
	private JPanel panel3;
	
	//포켓몬 종
	private JComboBox<String> comboBox1;
	
	//성격
	private JComboBox<String> comboBox2;
	
	//종족값
	private JLabel label1;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	
	//개체값
	private JLabel label11;
	private JTextField textField11;
	private JTextField textField12;
	private JTextField textField13;
	private JTextField textField14;
	private JTextField textField15;
	private JTextField textField16;
	
	//노력치
	private JLabel label21;
	private JTextField textField21;
	private JTextField textField22;
	private JTextField textField23;
	private JTextField textField24;
	private JTextField textField25;
	private JTextField textField26;
	
	private JTextArea textArea1;
	private JScrollPane scrollPane1;
	
	//스피드 빠른순 정렬버튼
	private JButton button1;
	
	//실능치 계산 버튼
	private JButton button2;
	
	private List<IndividualValueVo> list;
	private List<NatureVo> natureList;
	
	public Frame1() {
		try {
			this.setTitle("TestUI");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(500, 670);
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			IndividualValueService service = new IndividualValueService();
			IndividualValueVo individualValueVo = new IndividualValueVo();
			list = service.selectList(individualValueVo);
			
			
			panel1 = new JPanel();
			panel1.setLayout(new FlowLayout());
			panel1.setPreferredSize(new Dimension(500, 160));
			
			comboBox1 = new JComboBox<String>();
			comboBox1.setPreferredSize(new Dimension(400, 20));
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
			
			//종족값
			panel11 = new JPanel();
			panel11.setPreferredSize(new Dimension(500, 30));
			label1 = new JLabel("종족값");
			panel11.add(label1);
			
			textField1 = new JTextField(4);
			textField1.setHorizontalAlignment(JTextField.CENTER);
			textField1.setText("0");
			panel11.add(textField1);
			
			textField2 = new JTextField(4);
			textField2.setHorizontalAlignment(JTextField.CENTER);
			textField2.setText("0");
			panel11.add(textField2);
			
			textField3 = new JTextField(4);
			textField3.setHorizontalAlignment(JTextField.CENTER);
			textField3.setText("0");
			panel11.add(textField3);
			
			textField4 = new JTextField(4);
			textField4.setHorizontalAlignment(JTextField.CENTER);
			textField4.setText("0");
			panel11.add(textField4);
			
			textField5 = new JTextField(4);
			textField5.setHorizontalAlignment(JTextField.CENTER);
			textField5.setText("0");
			panel11.add(textField5);
			
			textField6 = new JTextField(4);
			textField6.setHorizontalAlignment(JTextField.CENTER);
			textField6.setText("0");
			panel11.add(textField6);
			
			panel1.add(panel11);
			
			//개체값
			panel12 = new JPanel();
			panel12.setPreferredSize(new Dimension(500, 30));
			label11 = new JLabel("개체값");
			panel12.add(label11);
			
			textField11 = new JTextField(4);
			textField11.setHorizontalAlignment(JTextField.CENTER);
			textField11.setText("31");
			panel12.add(textField11);
			
			textField12 = new JTextField(4);
			textField12.setHorizontalAlignment(JTextField.CENTER);
			textField12.setText("31");
			panel12.add(textField12);
			
			textField13 = new JTextField(4);
			textField13.setHorizontalAlignment(JTextField.CENTER);
			textField13.setText("31");
			panel12.add(textField13);
			
			textField14 = new JTextField(4);
			textField14.setHorizontalAlignment(JTextField.CENTER);
			textField14.setText("31");
			panel12.add(textField14);
			
			textField15 = new JTextField(4);
			textField15.setHorizontalAlignment(JTextField.CENTER);
			textField15.setText("31");
			panel12.add(textField15);
			
			textField16 = new JTextField(4);
			textField16.setHorizontalAlignment(JTextField.CENTER);
			textField16.setText("31");
			panel12.add(textField16);
			
			panel1.add(panel12);
			
			//노력치
			panel22 = new JPanel();
			panel22.setPreferredSize(new Dimension(500, 30));
			label21 = new JLabel("노력치");
			panel22.add(label21);
			
			textField21 = new JTextField(4);
			textField21.setHorizontalAlignment(JTextField.CENTER);
			textField21.setText("0");
			panel22.add(textField21);
			
			textField22 = new JTextField(4);
			textField22.setHorizontalAlignment(JTextField.CENTER);
			textField22.setText("0");
			panel22.add(textField22);
			
			textField23 = new JTextField(4);
			textField23.setHorizontalAlignment(JTextField.CENTER);
			textField23.setText("0");
			panel22.add(textField23);
			
			textField24 = new JTextField(4);
			textField24.setHorizontalAlignment(JTextField.CENTER);
			textField24.setText("0");
			panel22.add(textField24);
			
			textField25 = new JTextField(4);
			textField25.setHorizontalAlignment(JTextField.CENTER);
			textField25.setText("0");
			panel22.add(textField25);
			
			textField26 = new JTextField(4);
			textField26.setHorizontalAlignment(JTextField.CENTER);
			textField26.setText("0");
			panel22.add(textField26);
			
			panel1.add(panel22);
			
			//성격
			NatureService natureService = new NatureService();
			NatureVo natureVo = new NatureVo();
			natureList = natureService.selectList(natureVo);
			
			comboBox2 = new JComboBox<String>();
			comboBox2.setPreferredSize(new Dimension(400, 20));
			comboBox2.addItem("선택");
			for(NatureVo vo : natureList) {
				comboBox2.addItem(vo.getName());
			}
			panel1.add(comboBox2);
			this.add(panel1);
			
			panel2 = new JPanel();
			panel2.setSize(500, 500);
			textArea1 = new JTextArea("콤보박스를 선택하세요.", 25, 35);
			scrollPane1 = new JScrollPane(textArea1);
			scrollPane1.setPreferredSize(new Dimension(400, 400));
			panel2.add(scrollPane1);
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
			
			//실능치 계산
			button2 = new JButton("실능치 계산");
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//종족 선택
					int index = comboBox1.getSelectedIndex();
					String name = (String)comboBox1.getSelectedItem();

					//성격 선택
					int index2 = comboBox2.getSelectedIndex();
					String natureName = (String)comboBox2.getSelectedItem();
					
					if(index > 0 && index2 > 0) {
						IndividualValueVo vo = list.get(index - 1);
						NatureVo natureVo = natureList.get(index2 - 1);
						
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
						textArea1.append("\n\n");
						
						//실수치 계산
						//체력 = 종족값 + (노력치 / 4 + 개체값) / 2 + 10 + Lv
						int H = (int)Math.floor((vo.getH() + (Integer.parseInt(textField21.getText()) / 4 + Integer.parseInt(textField11.getText())) / 2 + 10 + 50));
						
						//그외 = {종족값 + (노력치 / 4 + 개체값) / 2 + 5} * 성격보정
						int A = (int)Math.floor((vo.getA() + (Integer.parseInt(textField22.getText()) / 4 + Integer.parseInt(textField12.getText())) / 2 + 5) * natureVo.getA());
						int B = (int)Math.floor((vo.getB() + (Integer.parseInt(textField23.getText()) / 4 + Integer.parseInt(textField13.getText())) / 2 + 5) * natureVo.getB());
						int C = (int)Math.floor((vo.getC() + (Integer.parseInt(textField24.getText()) / 4 + Integer.parseInt(textField14.getText())) / 2 + 5) * natureVo.getC());
						int D = (int)Math.floor((vo.getD() + (Integer.parseInt(textField25.getText()) / 4 + Integer.parseInt(textField15.getText())) / 2 + 5) * natureVo.getD());
						int S = (int)Math.floor((vo.getS() + (Integer.parseInt(textField26.getText()) / 4 + Integer.parseInt(textField16.getText())) / 2 + 5) * natureVo.getS());
						
						textArea1.append("실능 체력(H) : " + H + "\n");
						textArea1.append("실능 공격(A) : " + A + "\n");
						textArea1.append("실능 방어(B) : " + B + "\n");
						textArea1.append("실능 특수공격(C) : " + C + "\n");
						textArea1.append("실능 특수방어(D) : " + D + "\n");
						textArea1.append("실능 스피드(S) : " + S + "\n");
						textArea1.append("\n\n");
						
						//결정력 계산
						//자속 (실수치 * 1.5(자속) * 기술위력 * 랭크업 * 특성(천하장사)
						double attackDamage = A * 1.5;
						double specialAttackDamage = C * 1.5;
						
						textArea1.append("@ 자속 공격 결정력\n");
						textArea1.append("- 25 위력 : " + (int)Math.floor(attackDamage * 25) + "\n");
						textArea1.append("- 40 위력 : " + (int)Math.floor(attackDamage * 40) + "\n");
						textArea1.append("- 60 위력 : " + (int)Math.floor(attackDamage * 60) + "\n");
						textArea1.append("- 90 위력 : " + (int)Math.floor(attackDamage * 90) + "\n");
						textArea1.append("- 120 위력 : " + (int)Math.floor(attackDamage * 120) + "\n");
						textArea1.append("\n");
						
						textArea1.append("@ 자속 특수공격 결정력\n");
						textArea1.append("- 25 위력 : " + (int)Math.floor(specialAttackDamage * 25) + "\n");
						textArea1.append("- 40 위력 : " + (int)Math.floor(specialAttackDamage * 40) + "\n");
						textArea1.append("- 60 위력 : " + (int)Math.floor(specialAttackDamage * 60) + "\n");
						textArea1.append("- 90 위력 : " + (int)Math.floor(specialAttackDamage * 90) + "\n");
						textArea1.append("- 120 위력 : " + (int)Math.floor(specialAttackDamage * 120) + "\n");
						textArea1.append("\n\n");
						
						//내구력 계산
						//(체력 실능 * (물리/특수 방어 실능) / 0.411
						double stamina = H * B / 0.411;
						double specialStamina = H * D / 0.411;
						textArea1.append("@ 내구력 계산\n");
						textArea1.append("- 물리 내구력 : " + (int)Math.floor(stamina) + "\n");
						textArea1.append("- 특수 내구력 : " + (int)Math.floor(specialStamina) + "\n");
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
			panel3.add(button2);
			this.add(panel3);
			
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
