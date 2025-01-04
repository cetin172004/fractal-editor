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
  =================================
  	CONTENT
  	1. Gui Elements
  		1.1. Top Panel
  			1.1.1. Choose Fractal
  			1.1.2. Choose Depth
  			1.1.3. Choose Color
  	2. Layout Management
  	3. Actions
  	4. Window Properties
 
 
  
 */

public class MainWindow extends JFrame {
	public MainWindow() {
		

		
		
		
		// start server
		
		/* GUI ELEMENTS */
			/* Top Panel Elements */
				/* Choose Fractal */
		JLabel choose_fractal = new JLabel("Choose Fractal:");
		String[] fractals = {"Sierpinski Triangle", "Koch Snowflake", "Barnsley Fern"};
		JComboBox<String> fractal_dropdown = new JComboBox<>(fractals);
				
				/* Choose Depth */
		JLabel choose_depth = new JLabel("Depth:");
		SpinnerNumberModel depth_spinner_model = new SpinnerNumberModel(1,1,10,1);
		JSpinner depth_spinner = new JSpinner(depth_spinner_model);
		
				/* Choose Color */
		JButton choose_color = new JButton("Choose Color");
		
		
		/* LAYOUT MANAGEMENT */
			/* Top Panel */
		JPanel top_panel = new JPanel();
		top_panel.setLayout(new FlowLayout());
		top_panel.add(choose_fractal);
		top_panel.add(fractal_dropdown);
		top_panel.add(choose_depth);
		top_panel.add(depth_spinner);
		top_panel.add(choose_color);
			/* Root */
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());
		root.add(top_panel);
		
		/* ACTIONS */
			/* Dropdown Action */
		fractal_dropdown.addActionListener(e -> {
			// System.out.println(fractal_dropdown.getSelectedItem().getClass().getName());
			// >>> java.lang.String; (it returns string but it is object)
			
			Object selectedItem = fractal_dropdown.getSelectedItem();
			String selectedFractal = (String) selectedItem;
			System.out.println(selectedFractal);
		});
		
		/* WINDOW PROPERTIES */
		setTitle("Fractal Editor");
		setSize(400, 300);
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


