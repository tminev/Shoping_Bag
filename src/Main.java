import java.awt.FlowLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {
    String[] produkts = {"whiskey", "beer", "salat", "olive oil", "crust eggs", "tomatos", "chicken meat", "pork", "sweets", "candy"};
    double[] prices = {30, 3, 2, 15, 5, 2.50, 8, 7, 4, 6};
    double totalPrice = 0;
    double curPrice = 0;
    JComboBox comboBox = new JComboBox(produkts);
    JPanel panel = new JPanel();
    JLabel priceTotalLbl = new JLabel();
    JLabel curPriceLbl = new JLabel();
    JTextField quantity = new JTextField(10);

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    public static void main(String[] args) {
        createAndShowGUI();
    }

    public Main() { // add elements
        panel.add(comboBox);

        add(panel);
        add(quantity);
        this.getContentPane().setLayout(new FlowLayout());
        comboBox.addActionListener(event -> showCurPrice());

        JButton buttonAdd = new JButton("add");
        buttonAdd.addActionListener(event -> addProducts());
        add(buttonAdd);
        model.addColumn("product");
        model.addColumn("price");
        model.addColumn("quantity");

        add(table);
        JButton buttonRemove = new JButton("Remove");
        buttonRemove.addActionListener(event -> removeProducts());
        add(buttonRemove);
        add(curPriceLbl);
        add(priceTotalLbl);
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new Main();
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private int quantityIsNumCheck() {
        Pattern p = Pattern.compile("^\\d+$");
        Matcher numberMatcher;
        int quant = 0;
        numberMatcher = p.matcher(quantity.getText());
        if (numberMatcher.matches()) {
            quant = Integer.parseInt(quantity.getText());
            System.out.println(quant);
        } else {
            System.out.println("Invalid Number");
            quant=0;
        }
        return quant;
    }

    private void addProducts() {
        if (quantityIsNumCheck() != 0) {
            for (int i = 0; i < produkts.length; i++) {
                if (comboBox.getSelectedItem().equals(produkts[i])) {

                    model.addRow(new Object[]{produkts[i], prices[i], quantityIsNumCheck()});
                    totalPrice += prices[i];
                }
            }
            priceTotalLbl.setText("Total Price: " + totalPrice + " lv");
            System.out.println(totalPrice);
        }
    }

    private void removeProducts() {
        double temp = (double) table.getValueAt(table.getSelectedRow(), 1);
        totalPrice -= temp;
        model.removeRow(table.getSelectedRow());
        priceTotalLbl.setText("Total Price: " + totalPrice + " lv");
    }

    private void showCurPrice() {
        for (int i = 0; i < produkts.length; i++) {
            if (comboBox.getSelectedItem().equals(produkts[i])) {
                curPrice = prices[i];
            }
        }
        curPriceLbl.setText("Current Price: " + curPrice + " lv");
    }

}