import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
		
		ui.contentFrame.setSize(800, 400);
		ui.contentFrame.setVisible(true);
	}
	
	@SuppressWarnings("serial")
	private class InputPane extends JPanel {
		
		private InputPane() {
			
			setLayout(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();

	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.anchor = GridBagConstraints.EAST;

	        add(new JLabel("Mortage Amount: $"), gbc);
	        gbc.gridy++;
	        add(new JLabel("Mortage term: "), gbc);
	        gbc.gridx += 2;
	        add(new JLabel("Years or "), gbc);
	        gbc.gridx += 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        add(new JLabel(" months "), gbc);
	        gbc.anchor = GridBagConstraints.EAST;
	        gbc.gridx = 0;
	        gbc.gridy++;
	        add(new JLabel("Interest rate: "), gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 0;
	        gbc.anchor = GridBagConstraints.WEST;

	        add(new JTextField(10), gbc);
	        gbc.gridy++;
	        add(new JTextField(10), gbc);
	        gbc.gridx += 2;
	        add(new JTextField(10), gbc);
	        gbc.gridx = 1;
	        gbc.gridy++;
	        add(new JTextField(10), gbc);
	        
		}
	}
}
