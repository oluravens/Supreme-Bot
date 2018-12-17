import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {

	private JFrame contentFrame;
	private String windowName = "Currently Testing";
	

	public GUI() {

		contentFrame = new JFrame(windowName);

		contentFrame.add(new InputPane());

	}

	public static void main(String[] args) {

		GUI ui = new GUI();

		ui.contentFrame.setSize(800, 600);
		ui.contentFrame.setVisible(true);
	}

	@SuppressWarnings("serial")
	private class InputPane extends JPanel {

		private InputPane() {
			
			setBackground(Color.lightGray);
			setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();

			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.EAST;

			//creating all input labels
			JLabel usernameLabel = new JLabel("Google Username: ");
			add(usernameLabel, gbc);
			gbc.gridy++;

			JLabel passwordLabel = new JLabel("Google Password: ");
			add(passwordLabel, gbc);
			gbc.gridy++;

			JLabel categoryLabel = new JLabel("Category: ");
			add(categoryLabel, gbc);
			gbc.gridy++;

			JLabel keywordLabel = new JLabel("Keyword: ");
			add(keywordLabel, gbc);
			gbc.gridy++;
			
			JLabel nameLabel = new JLabel("Name: ");
			add(nameLabel, gbc);
			gbc.gridy++;
			
			JLabel emailLabel = new JLabel("Email: ");
			add(emailLabel, gbc);
			gbc.gridy++;
			
			JLabel telNumberLabel = new JLabel("Phone Number: ");
			add(telNumberLabel, gbc);
			gbc.gridy++;
			
			JLabel addressLabel = new JLabel("Adress: "); 
			add(addressLabel, gbc);
			gbc.gridy++;
			
		    JLabel aptUnitLabel = new JLabel("Appartment Unit: ");
			add(aptUnitLabel, gbc);
			gbc.gridy++;
			
			JLabel zipLabel = new JLabel("Zip Code: ");
			add(zipLabel, gbc);
			gbc.gridy++;
			
		    JLabel cityLabel = new JLabel("City: ");
			add(cityLabel, gbc);
			gbc.gridy++;
			
		    JLabel stateLabel = new JLabel("State: ");
			add(stateLabel, gbc);
			gbc.gridy++;
			
			JLabel creditLabel = new JLabel("Credit Card Number: ");
			add(creditLabel, gbc);
			gbc.gridy++;
			
			JLabel creditMonthLabel = new JLabel("Credit Expiration Month: ");
			add(creditMonthLabel, gbc);
			gbc.gridy++;
			
			JLabel creditYearLabel = new JLabel("Credit Expiration Year: ");
			add(creditYearLabel, gbc);
			gbc.gridy++;
			
			JLabel cvvLabel = new JLabel("Credit CVV: ");
			add(cvvLabel, gbc);
			gbc.gridy++;
			
			//adds title in top middle
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 2;
			gbc.anchor = GridBagConstraints.CENTER;

			JLabel title = new JLabel();
			Font titleFont = new Font("Impact", Font.BOLD, 24);
			title.setText("Supreme Drop Cop");
			title.setFont(titleFont);
			title.setForeground(Color.red.brighter());
			add(title, gbc);
			
			//moves the grid over to the right one
			gbc.gridx = 2;
			gbc.gridy = 1;
			gbc.gridwidth = 1;
			gbc.anchor = GridBagConstraints.WEST;

			//creating all text fields
			JTextField usernameTextField = new JTextField(18);
			add(usernameTextField, gbc);
			gbc.gridy++;

			JTextField passwordTextField = new JTextField(18);
			add(passwordTextField, gbc);
			gbc.gridy++;

			JTextField categoryTextField = new JTextField(18);
			add(categoryTextField, gbc);
			gbc.gridy++;

			JTextField keywordTextField = new JTextField(18);
			add(keywordTextField, gbc);
			gbc.gridy++;
			
			JTextField nameTextField = new JTextField(18);
			add(nameTextField, gbc);
			gbc.gridy++;
			
			JTextField emailTextField = new JTextField(18);
			add(emailTextField, gbc);
			gbc.gridy++;
			
			JTextField telNumberTextField = new JTextField(18);
			add(telNumberTextField, gbc);
			gbc.gridy++;
			
			JTextField addressTextField = new JTextField(18); 
			add(addressTextField, gbc);
			gbc.gridy++;
			
		    JTextField aptUnitTextField = new JTextField(18);
			add(aptUnitTextField, gbc);
			gbc.gridy++;
			
			JTextField zipTextField = new JTextField(18);
			add(zipTextField, gbc);
			gbc.gridy++;
			
		    JTextField cityTextField = new JTextField(18);
			add(cityTextField, gbc);
			gbc.gridy++;
			
		    JTextField stateTextField = new JTextField(18);
			add(stateTextField, gbc);
			gbc.gridy++;
			
			JTextField creditTextField = new JTextField(18);
			add(creditTextField, gbc);
			gbc.gridy++;
			
			JTextField creditMonthTextField = new JTextField(18);
			add(creditMonthTextField, gbc);
			gbc.gridy++;
			
			JTextField creditYearTextField = new JTextField(18);
			add(creditYearTextField, gbc);
			gbc.gridy++;
			
			JTextField cvvTextField = new JTextField(18);
			add(cvvTextField, gbc);
			gbc.gridy++;
		

			JButton submitButton = new JButton("Submit");
			submitButton.setBackground(Color.red.brighter());
			submitButton.setForeground(Color.white);
			
			//sets fields equal to their text upon click
			submitButton.addActionListener( new ActionListener()
			{
			    @Override
			    public void actionPerformed(ActionEvent e)
			    {
			    	
			    	//retrieving data from fields and adding to array
			    	ArrayList<String> dataList = new ArrayList<String>();
					
					dataList.add(usernameTextField.getText());
					dataList.add(passwordTextField.getText());
					dataList.add(nameTextField.getText());
					dataList.add(emailTextField.getText());
					dataList.add(telNumberTextField.getText());
					dataList.add(addressTextField.getText()); 
				    dataList.add(aptUnitTextField.getText());
					dataList.add(zipTextField.getText());
				    dataList.add(cityTextField.getText());
				    dataList.add(stateTextField.getText());
					dataList.add(creditTextField.getText());
					dataList.add(creditMonthTextField.getText());
					dataList.add(creditYearTextField.getText());
					dataList.add(cvvTextField.getText());
					dataList.add(categoryTextField.getText());
					dataList.add(keywordTextField.getText());
					
					//outputting data to data file
					outputData(dataList);
					
					removeAll();
					revalidate();
					repaint();
					
					gbc.gridx = 0;
					gbc.gridy = 0;
					add(new JLabel("Data Exported."), gbc);
			    }

			});
			
			add(submitButton,gbc);

		}
		
		
		private void outputData(ArrayList<String> data){
			
			try {
				
				Writer dataWriter = new FileWriter("data.txt");
				
				for(String s: data){
					
					dataWriter.write(s);
					dataWriter.write("\n");
					
				}
				
				dataWriter.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
