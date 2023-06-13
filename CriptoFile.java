import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import classes.*;

public class CriptoFile extends JFrame{
	
	private JLabel lblFile, lblResultado;
	private JButton btnEncrypt, btnDecrypt;
	
	public CriptoFile(){
		
		lblFile = new JLabel("Selecione um arquivo ...");
		lblFile.setBounds(50,50,500,40);
		lblFile.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblFile.setOpaque(true);
		lblFile.setBackground(Color.WHITE);
		add(lblFile);
		lblFile.addMouseListener(
			new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {
					JFileChooser fileChooser = new JFileChooser();
					int result = fileChooser.showOpenDialog(null);
					if (result == JFileChooser.APPROVE_OPTION) {
						lblFile.setText(fileChooser.getSelectedFile().getAbsolutePath());
					}
				}
			}
		);
		
		lblResultado = new JLabel();
		lblResultado.setBounds(50,150,500,400);
		lblFile.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		add(lblResultado);
		
		btnEncrypt = new JButton("Criptografar");
		btnEncrypt.setBounds(50,100,245,40);
		btnEncrypt.setFont(new Font("Arial", Font.BOLD, 18));
		add(btnEncrypt);
		btnEncrypt.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Criptografia.encrypt(lblFile.getText())){
						
						lblResultado.setText("Arquivo criptografado com sucesso !!!");
						lblResultado.setForeground(Color.BLUE);
						
					}else{
						
						lblResultado.setText("Arquivo não criptografado");
						lblResultado.setForeground(Color.RED);
					}
				}
			}
		);
		
		btnDecrypt = new JButton("Descriptografar");
		btnDecrypt.setBounds(305,100,245,40);
		btnDecrypt.setFont(new Font("Arial", Font.BOLD, 18));
		add(btnDecrypt);
		btnDecrypt.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Criptografia.decrypt(lblFile.getText())){
						
						lblResultado.setText("Arquivo foi descriptografado com sucesso !!!");
						lblResultado.setForeground(Color.BLUE);
						
					}else{
						
						lblResultado.setText("Arquivo não descriptografado");
						lblResultado.setForeground(Color.RED);
					}
				}
			}
		);
	}

	public static void main(String args[]){
		
		CriptoFile form = new CriptoFile();
		
		form.setLayout(null);
		form.setBounds(0,0,600,300);
		form.setLocationRelativeTo(null);
		form.setVisible(true);
		form.setResizable(false);
		form.setTitle("Criptografar arquivo");
		form.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}