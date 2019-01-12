import javax.swing.*;

public class Main extends JFrame{
    JPanel panel = new JPanel();
    String[] produkts = {"whiskey", "beer", "salat", "olive oil", "crust eggs", "tomatos", "chicken meat", "pork", "sweets", "candy"};
    double[] prices = {30, 3, 2, 15, 5, 2.50, 8, 7, 4, 6};

    JComboBox comboBox = new JComboBox(produkts);



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
    public Main() {
        panel.add(comboBox);
        add(panel);
}
}
