import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Permgui implements ActionListener {

    JFrame frame;
    JPanel panel;
    JTextField textField;
    JButton button;
    JScrollPane prev;

    Permgui(){
         frame = new JFrame();
         frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
         panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,400));
        add_Items(panel);
        button.addActionListener(this);
    }

    public static void main(String[] args) {
      Permgui permgui = new Permgui();
        permgui.frame.add(permgui.panel);
        permgui.frame.pack();
        permgui.frame.setVisible(true);

    }



    private void add_Items (JPanel panel) {

         button = new JButton("Permutations");
        this.textField = new JTextField();
        panel.setLayout(new GridLayout(3,1));
        panel.add(button);
        panel.add(this.textField);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Permutations")) {
            String str = this.textField.getText();
            Permutation permutation = new Permutation();
            String [] columneName = {"Permutations"};
            ArrayList<String> print = permutation.permutaions(str);
            String [][] colmunEntries = new String[print.size()][print.size()];
            for (int i = 0; i < print.size(); i++) {
                System.out.println(print.get(i));
                colmunEntries[i][0] = print.get(i);
            }
            if(isThisComponentFoundInJPanel(prev)){
                panel.remove(prev);
            }

            JTable table = new JTable(colmunEntries,columneName);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            JScrollPane scp = new JScrollPane(table);
            this.panel.add(scp);
            prev = scp;
            panel.revalidate();
        }
    }

    boolean isThisComponentFoundInJPanel(Component c)
    {
        Component[] components = this.panel.getComponents();
        for (Component component : components) {
            if (c== component) {
                return true;
            }
        }
        return false;
    }
}
