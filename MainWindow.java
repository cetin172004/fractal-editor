package gui;

//* = all
import javax.swing.*; // gui, gui elements
import java.awt.*; // borderlayout, flowlayout

/*
 * jframe > window sinifidir. uygulamalarda ana pencere olarak kullanilir
 * jpanel > bilesenlerin gruplandigi ya da duzenlendigi konteynerdir
 *  
 * 
 * 
*/


// Usage of Comments in this page
// /* title */ 
// // explanation about line/block
 
/*
  	CONTENT
  	1. Gui Elements
  	|	1.1. Top Panel Elements
  	|	|	1.1.1. Choose Fractal
  	|	|	1.1.2. Choose Depth
  	|	|	1.1.3. Choose Color
  	|	1.2. Fractal Panel  		
  	|	1.3. Bottom Panel Elements
  	|		1.3.1. Save Button
  	|		1.3.2. Send Button
  	|
  	2. Layout Management
  	|	2.1. Top Panel
  	|	2.2. Bottom Panel
  	|	2.3. Root
	|
  	3. Actions
  	|	3.1. Dropdown Action
  	|	3.2. Depth Spinner Action
  	|	3.3. Choose Color Action
  	|	3.4. Save Action
  	|	3.5. Send Action
  	|	
  	4. Window Properties
 */

public class MainWindow extends JFrame {
	public MainWindow() {
		// start server
		
		/* 1. GUI ELEMENTS */
			/* 1.1. Top Panel Elements */
				/* 1.1.1. Choose Fractal */
		JLabel choose_fractal = new JLabel("Choose Fractal:");
		String[] fractals = {"Sierpinski Triangle", "Koch Snowflake", "Barnsley Fern"};
		JComboBox<String> fractal_dropdown = new JComboBox<>(fractals);
				
				/* 1.1.2. Choose Depth */
		JLabel choose_depth = new JLabel("Depth:");
		SpinnerNumberModel depth_spinner_model = new SpinnerNumberModel(1,1,10,1);
		JSpinner depth_spinner = new JSpinner(depth_spinner_model);
		
				/* 1.1.3. Choose Color */
		JButton choose_color = new JButton("Choose Color");
		
			/* 1.2. Fractal Panel */
		JPanel fractal_panel = new JPanel();
		fractal_panel.setBackground(Color.WHITE);
		
			/* 1.3. Bottom Panel Elements */
				/* 1.3.1. Save Button */
		JButton save_button = new JButton("Save as Image");
				
				/* 1.3.2. Send Button */
		JButton send_button = new JButton("Send to the Server");
		
		/* 2. LAYOUT MANAGEMENT */
			/* 2.1. Top Panel */
		JPanel top_panel = new JPanel();
		top_panel.setLayout(new FlowLayout()); // FlowLayout: left to right 
		top_panel.add(choose_fractal);
		top_panel.add(fractal_dropdown);
		top_panel.add(choose_depth);
		top_panel.add(depth_spinner);
		top_panel.add(choose_color);
		
			/* 2.2. Bottom Panel */ 
		JPanel bottom_panel = new JPanel();
		bottom_panel.setLayout(new FlowLayout());
		bottom_panel.add(save_button);
		bottom_panel.add(send_button);
		
			/* 2.3. Root */
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout()); // BorderLayout: five regions
		root.add(top_panel, BorderLayout.NORTH);
		root.add(fractal_panel, BorderLayout.CENTER);
		root.add(bottom_panel, BorderLayout.SOUTH);
		
		/* 3. ACTIONS */
			/* 3.1 Dropdown Action */
		fractal_dropdown.addActionListener(e -> {
			// System.out.println(fractal_dropdown.getSelectedItem().getClass().getName());
			// >>> java.lang.String; (it returns string but it is object)
			// type is uncertain
			
			Object selected_item = fractal_dropdown.getSelectedItem();
			String selected_fractal = (String) selected_item;
			System.out.println(selected_fractal);
		});
		
			/* 3.2 Depth Spinner Action*/
		depth_spinner.addChangeListener(e -> {
			Object selected_number = depth_spinner.getValue();
			int selected_depth = (int) selected_number;
			System.out.println(selected_depth);
		});
		
			/* 3.3 Choose Color Action */
		choose_color.addActionListener(e -> {
			System.out.println("Renk secimi yapilacak");
		});
		
			/* 3.4 Save Action */
		save_button.addActionListener(e -> {
			System.out.println("Gorseli Indir");
		});	
		
			/* 3.5 Send Action */
		send_button.addActionListener(e -> {
			System.out.println("Sunucuya Gonder");
		});
		
		/* 4. WINDOW PROPERTIES */
		setTitle("Fractal Editor");
		setSize(600, 400);
		setIconImage((new ImageIcon("../../resources/icon.png")).getImage());
		setContentPane(root);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			SwingUtilities.invokeLater(MainWindow::new);
		});
	}

}


