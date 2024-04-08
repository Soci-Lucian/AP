import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame {

    private int gridWidth = 5; // Default grid width
    private int gridHeight = 5; // Default grid height

    public GameGUI() {
        setTitle("Positional Game");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configuration panel
        JPanel configPanel = new JPanel();
        configPanel.setLayout(new FlowLayout());
        JLabel gridWidthLabel = new JLabel("Grid size:");
        JTextField gridWidthField = new JTextField(String.valueOf(gridWidth), 5);
        JLabel gridHeightLabel = new JLabel();
        JTextField gridHeightField = new JTextField(String.valueOf(gridHeight), 5);
        JButton newGameButton = new JButton("New Game");
        configPanel.add(gridWidthLabel);
        configPanel.add(gridWidthField);
        configPanel.add(gridHeightLabel);
        configPanel.add(gridHeightField);
        configPanel.add(newGameButton);
        add(configPanel, BorderLayout.NORTH);

        // Canvas for drawing the board
        JPanel canvasPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGrid(g, gridWidth, gridHeight);
            }
        };
        canvasPanel.setPreferredSize(new Dimension(400, 400));
        add(canvasPanel, BorderLayout.CENTER);

        // Control panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        JButton loadButton = new JButton("Load");
        JButton saveButton = new JButton("Save");
        controlPanel.add(loadButton);
        controlPanel.add(saveButton);
        add(controlPanel, BorderLayout.SOUTH);

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gridWidth = Integer.parseInt(gridWidthField.getText());
                    gridHeight = Integer.parseInt(gridHeightField.getText());
                    canvasPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(GameGUI.this, "Invalid input for grid size.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void drawGrid(Graphics g, int width, int height) {
        int canvasWidth = 400;
        int canvasHeight = 400;
        g.clearRect(0, 0, canvasWidth, canvasHeight);
        g.setColor(Color.BLACK);

        int cellWidth = canvasWidth / width;
        int cellHeight = canvasHeight / height;

        // Vertical lines
        for (int i = 0; i <= width; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, canvasHeight);
        }

        // Horizontal lines
        for (int i = 0; i <= height; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, canvasWidth, y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameGUI().setVisible(true);
            }
        });
    }
}
