package com.lsh.springboothotkey.frame;

import com.lsh.springboothotkey.entry.Hotkey;
import com.lsh.springboothotkey.utils.Contains;
import com.lsh.springboothotkey.utils.JsonUtil;
import com.lsh.springboothotkey.utils.SwingUtil;
import com.melloware.jintellitype.JIntellitype;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  
 * @author Administrator
 */
public class AddFrame extends JDialog {

	Hotkey hk = new Hotkey();
	private int id;
	private IndexFrame parentF;
	
	public AddFrame(IndexFrame parentF, boolean model) {
		super(parentF,model);
		Contains.window = this;
		this.parentF = parentF;
		initComponents();
		
	}
	
	@SuppressWarnings("unchecked")
	private void initComponents() {

		buttonGroup1 = new ButtonGroup();
		submit = new JButton("确定");
		cancel = new JButton("取消");
		jTextField3 = new JTextField();
		jLabel1 = new JLabel("热键");
		jLabel2 = new JLabel("内容");
		jLabel3 = new JLabel("注释");
		jLabel4 = new JLabel("CTRL + SHIFT +");
		jComboBox1 = new JComboBox<>();
		jLabel6 = new JLabel("*");
		jScrollPane1 = new JScrollPane();
		jTextArea1 = new JTextArea();
		jLabel5 = new JLabel("加密");
		ryes = new JRadioButton("是");
		rno = new JRadioButton("否");
		jButton3 = new JButton("说明");

		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				submitActionPerformed(evt);
			}
		});

		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});

		jTextField3.setFont(Contains.F_S_0_16);

		jLabel1.setFont(Contains.F_S_1_16);

		jLabel2.setFont(Contains.F_S_1_16);

		jLabel3.setFont(Contains.F_S_1_16);

		jComboBox1.setFont(Contains.F_S_0_14);
		String[] keys = new String[]{"F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12"};
		jComboBox1.setModel(new DefaultComboBoxModel<>(keys));

		jLabel6.setFont(Contains.F_S_1_14);
		jLabel6.setForeground(Color.red);

		jTextArea1.setColumns(20);
		jTextArea1.setLineWrap(true);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jLabel5.setFont(Contains.F_S_1_14);

		buttonGroup1.add(ryes);
		ryes.setSelected(true);
		buttonGroup1.add(rno);

		jButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(28, 28, 28)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel1)
																		.addComponent(jLabel5))
																.addGap(18, 18, 18))
														.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addGap(24, 24, 24)
																.addComponent(jLabel4)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
														.addGroup(layout.createSequentialGroup()
																.addGap(22, 22, 22)
																.addComponent(ryes)
																.addGap(18, 18, 18)
																.addComponent(rno)))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
										.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
												.addComponent(jLabel3)
												.addGap(18, 18, 18)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(submit)
																.addGap(62, 62, 62)
																.addComponent(cancel))
														.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
												.addGap(6, 6, 6)))
								.addComponent(jLabel6)
								.addGap(18, 18, 18)
								.addComponent(jButton3)
								.addContainerGap(35, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGap(17, 17, 17)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1)
										.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel5)
										.addComponent(ryes)
										.addComponent(rno))
								.addGap(9, 9, 9)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup()
												.addGap(38, 38, 38)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6)
														.addComponent(jButton3)))
										.addGroup(layout.createSequentialGroup()
												.addGap(41, 41, 41)
												.addComponent(jLabel2)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel3)
										.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(27, 27, 27)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(submit)
										.addComponent(cancel))
								.addContainerGap(41, Short.MAX_VALUE))
		);

		pack();
		open2();
	}                      

	private void clearJfield() {
		jComboBox1.setSelectedIndex(0);
		ryes.setSelected(true);
		jTextArea1.setText("");
		jTextField3.setText("");
	}
	// 新增或修改
	private void submitActionPerformed(ActionEvent evt) {
		String key = jComboBox1.getSelectedItem().toString();
		String action = jTextArea1.getText().trim();
		String updateM = "";
		int result = 0;
		Contains.window = Contains.DIALOG;
		Contains.parentWindow = this;
		if (!StringUtils.isBlank(action)) {
			String encrypt = "否";
			if (ryes.isSelected()) {
				encrypt = "是";
				action = Contains.textEncode(action);
			}
			Hotkey hotkey = new Hotkey();
			hotkey.setHotkey("CTRL+SHIFT+" + key);
			hotkey.setKaction(action);
			hotkey.setExplain(jTextField3.getText());
			hotkey.setEncrypt(encrypt);
			if ( Contains.AUSTATE == 1) {
				int size = 0;
				if (Contains.HOTKEYS != null) {
					size = Contains.HOTKEYS.size();
				}
				hotkey.setKId(size);
				Contains.HOTKEYS.add(hotkey);
				boolean b = JsonUtil.objectToJson(Contains.HOTKEYS,Contains.HOTKEYROOT,Contains.JSONFILENAME);
				if (b) {
					registerRe(size,key);
					updateM = "新增成功~";
					parentF.initHotT();
				}
			} else {
				hotkey.setKId(id);
				Contains.HOTKEYS.remove(id);
				Contains.HOTKEYS.add(hotkey);
				boolean b = JsonUtil.objectToJson(Contains.HOTKEYS,Contains.HOTKEYROOT,Contains.JSONFILENAME);
				if (b) {
					JIntellitype.getInstance().unregisterHotKey(id);
					registerRe(id,key);
					updateM = "修改成功~";
					parentF.initHotT();
				}
			}
		} else {
				updateM +="内容不能为空~";
		}
		if (result == -2) {
			updateM += key+"已经被占用~";
		}
		if (result == -3) {
			updateM +="系统错误~";
		}
		Contains.DIALOG.showMessageDialog(this,updateM);
	}

	/**
	 * 重新注册
	 * @param key
	 */
	private void registerRe(int id,String key) {
		JIntellitype.getInstance().registerHotKey(id, JIntellitype.MOD_CONTROL+JIntellitype.MOD_SHIFT, Contains.keycode(key));
	}

	private void jButton3ActionPerformed(ActionEvent evt) {
		String message = "Tab键用 ~ 代替\nEnter键用 = 代替\n";
		Contains.window = Contains.DIALOG;
		Contains.parentWindow = this;
		Contains.DIALOG.showMessageDialog(this,message);
	}

	// 设置内容
	String title = "";
	private void initFrame() {
		if (Contains.AUSTATE == 1) {
			hk = null;
			title = "新增";
		} else {
			title = "编辑";
		}
		
		hk = parentF.getHk();
		if (hk != null) {
			id = hk.getKId();
			jComboBox1.setSelectedItem(hk.getHotkey().split("CTRL+SHIFT+")[0]);
			String encrypt = hk.getEncrypt();
			String kaction = hk.getKaction();
			if ("是".equals(encrypt)) {
				ryes.setSelected(true);
				kaction = Contains.textDecode(kaction);
			} else {
				rno.setSelected(true);
			}
			jTextArea1.setText(kaction);
			jTextField3.setText(hk.getExplain());
		}
	}
	
	// 显示窗口
	public void open2() {
		initFrame();
		SwingUtil.setFrameTitle(this,title);
	}

	private ButtonGroup buttonGroup1;
	private JButton submit;
	private JButton cancel;
	private JButton jButton3;
	private JComboBox<String> jComboBox1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JRadioButton ryes;
	private JRadioButton rno;
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;
	private JTextField jTextField3;
	// End of variables declaration                   
}
