import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Window extends JFrame {

    private TreePanel treePanel;
    private MainFolderComponent mainFolderComponent;

    public Window(MainFolderComponent mainFolderComponent){
        this.treePanel = new TreePanel(mainFolderComponent.getTreeNode());
        //Set window
        setTitle("File Explorer");
        setBounds(350, 300, 1280, 720);

        //Set the tree panel and the main folder
        setTreePanel(treePanel);
        setMainFolderComponent(mainFolderComponent);
        add(this.treePanel, BorderLayout.CENTER);


        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) this.mainFolderComponent.getTreeNode().getCellRenderer();
        renderer.setFont(new Font("Consolas", Font.BOLD, 30));
        renderer.setSize(1280, 420);


        //Add Scrollbar
        Container panelContenido = getContentPane();
        panelContenido.add(new JScrollPane(this.treePanel));
        //Add the controls panel
        add(new FileExplorerControls(this.treePanel), BorderLayout.NORTH);
        //Config values of window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setMainFolderComponent(MainFolderComponent mainFolderComponent){
        this.mainFolderComponent = mainFolderComponent;
        this.treePanel.setTree(this.mainFolderComponent.getTreeNode());
    }

    public TreePanel getTreePanel()
    {
        return this.treePanel;
    }

    public void setTreePanel(TreePanel treePanel){
        this.treePanel = treePanel;
    }

}
