import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana(JTree tree){
        setTitle("File Explorer");
        setBounds(350, 300, 200, 200);
        add(new PanelArbol(tree));
        Container panelContenido = getContentPane();
        panelContenido.add(new JScrollPane(tree));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
static class PanelArbol extends JPanel{
        public PanelArbol(JTree tree){
            setLayout(new BorderLayout());
            setBackground(Color.BLACK);
            add(tree, BorderLayout.NORTH);
        }
}
}
