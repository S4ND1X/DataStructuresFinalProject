import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class TreePanel extends JPanel implements TreeSelectionListener {
    private  JTree tree;
    private HybridNode selectedNodePanel;

    public TreePanel(JTree tree){
        this.tree = tree;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1280, 420));
        tree.addTreeSelectionListener(this);
        add(tree, BorderLayout.CENTER);
    }
    public void setTree(JTree tree){
        this.tree = tree;
    }
    public JTree getTree(){
        return this.tree;
    }
    public HybridNode getSelectedNodePanel(){
        return this.selectedNodePanel;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        try{
            //Se obtiene el nodo del objeto que estoy seleccionando
            this.selectedNodePanel = (HybridNode)tree.getLastSelectedPathComponent();
            System.out.println(this.selectedNodePanel.getFileComponentOfNode().getFileName());
        }catch (NullPointerException ex){
            System.out.println("No se deteca un componente archivo o un nombre");
        }

    }
}