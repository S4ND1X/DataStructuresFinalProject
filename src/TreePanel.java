/**
 * @author Jorge Sánchez Díaz
 * @version v1.0
 */
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class TreePanel extends JPanel implements TreeSelectionListener {
    private  JTree tree;
    private HybridNode selectedNodePanel;

    public TreePanel(JTree tree){
        this.setBackground(Color.BLACK);
        this.tree = tree;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(720, 480));
        tree.addTreeSelectionListener(this);
        customIcons();
        add(tree, BorderLayout.CENTER);
    }


    private void customIcons(){
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) this.tree.getCellRenderer();
        Icon closedIcon = new ImageIcon(getClass().getResource("closedFolder.png"));
        Icon openIcon = new ImageIcon(getClass().getResource("openFolder.png"));
        Icon leafIcon = new ImageIcon(getClass().getResource("fileTree.png"));
        renderer.setClosedIcon(closedIcon);
        renderer.setOpenIcon(openIcon);
        renderer.setLeafIcon(leafIcon);
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
        }catch (NullPointerException ex){
            System.out.println("No se deteca un componente archivo o un nombre");
        }

    }
}