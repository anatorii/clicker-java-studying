import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Clicker extends JFrame {
    static int width = 800;
    static int height = 600;
    static int clientWidth;
    static int clientHeight;
    JLabel label;
    int counter = 0;

    public Clicker() {
        super("Clicker");
        initGui();
    }

    private void initGui() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Clicker.width, Clicker.height);
        this.setLocation(d.width / 2 - Clicker.width / 2, d.height / 2 - Clicker.height / 2);
        this.getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel panelUp = new JPanel(new GridBagLayout());
        panelUp.setBackground(Color.yellow);
        panelUp.setPreferredSize(new Dimension(0, 100));

        JPanel panelDown = new JPanel(new GridBagLayout());
        panelDown.setBackground(Color.green);

        JButton button = new JButton("Кнопка регистрации нажатий");
        button.setFont(new Font("Courier", Font.PLAIN, 18));
        panelUp.add(button);

        label = new JLabel("Кнопка нажата - " + counter + " раз");
        label.setFont(new Font("Serif", Font.PLAIN, 50));
        label.setBackground(Color.white);
        label.setOpaque(true);
        panelDown.add(label);

        this.add(panelUp, BorderLayout.NORTH);
        this.add(panelDown, BorderLayout.CENTER);
        this.setVisible(true);

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonChanged(e);
            }
        });
    }

    private void buttonChanged(ActionEvent e) {
        counter++;
        label.setText("Кнопка нажата - " + counter + " раз");
    }

    public void setVisible(boolean b) {
        super.setVisible(b);
        clientWidth = Clicker.width;
        clientHeight = Clicker.height;
        if (isResizable()) {
            clientWidth = getContentPane().getWidth();
            clientHeight = getContentPane().getHeight();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Clicker frame = new Clicker();
            }
        });
    }
}
