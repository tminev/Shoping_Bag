import javax.swing.*;

public class Main extends JFrame{
    public static void main(String[] args) {
        createAndShowGUI();
    }
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new Main();
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
