package gui;

/*
 * jframe > window sinifidir. uygulamalarda ana pencere olarak kullanilir
 * jpanel > bilesenlerin gruplandigi ya da duzenlendigi konteynerdir
 *  
 * 
 * 
*/

//* = all
import javax.swing.*; // gui, gui elements
import java.awt.*; // borderlayout, flowlayout

public class MainWindow extends JFrame {
	public MainWindow() {
		// start server
		
		// GUI ELEMENTS
			// Top Panel
				// Choose Fractal
		JLabel choose_fractal = new JLabel("Choose Fractal:");
		String[] fractals = {"Sierpinski Triangle", "Koch Snowflake", "Barnsley Fern"};
		JComboBox<String> fractal_dropdown = new JComboBox(fractals);
				
				// Choose Depth
		JLabel choose_depth = new JLabel("Depth:");
		SpinnerNumberModel depth_spinner_model = new SpinnerNumberModel(1,1,10,1);
		JSpinner depth_spinner = new JSpinner(depth_spinner_model);
		
				// Choose Color
		JButton choose_color = new JButton("Choose Color");
		
		
		// LAYOUT MANAGEMENT
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());
		
		JPanel top_panel = new JPanel();
		top_panel.setLayout(new FlowLayout());
		
		// WINDOW PROPERTIES
		this.setTitle("Fractal Editor");
		this.setSize(400, 300);
		this.setIconImage((new ImageIcon("../../resources/icon.png")).getImage());
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			SwingUtilities.invokeLater(MainWindow::new);
		});
	}

}


