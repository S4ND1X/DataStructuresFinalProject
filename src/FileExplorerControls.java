import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExplorerControls extends JPanel implements ActionListener {

    private JButton createFileButton,
                    createFolderButton,
                    removeComponentButton,
                    renameComponentButton;
    private TreePanel treePanel;

    public FileExplorerControls(TreePanel treePanel){
        //Initialize Panel
        super();
        this.setPreferredSize(new Dimension(150,600));
        //initialize treePanel
        this.treePanel = treePanel;
        //Initialize buttons
        this.createFileButton = createButton("New File");
        this.createFolderButton = createButton("New Folder");
        this.removeComponentButton = createButton("Remove element");
        this.renameComponentButton = createButton("Rename element");
        //Add Listener to buttons
        this.createFileButton.addActionListener(this);
        this.removeComponentButton.addActionListener(this);
        this.createFolderButton.addActionListener(this);
        this.renameComponentButton.addActionListener(this);
        //Add everything to the panel
        this.add(this.createFileButton);
        this.add(this.removeComponentButton);
        this.add(this.createFolderButton);
        this.add(this.removeComponentButton);
        this.add(renameComponentButton);


    }


    private JButton createButton(String buttonName){
        JButton button = new JButton(buttonName);
        return button;
    }



    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       if(this.renameComponentButton == actionEvent.getSource()){
           String tmp = JOptionPane.showInputDialog(this,"Nuevo nombre");
           this.treePanel.getSelectedNodePanel().getFileComponentOfNode().setComponentName(tmp);
           this.treePanel.getSelectedNodePanel().setUserObject(tmp);
           //Actualizar
           DefaultTreeModel model = (DefaultTreeModel)this.treePanel.getTree().getModel();
           HybridNode root = this.treePanel.getSelectedNodePanel();
           model.reload(root);

       }else if(this.removeComponentButton == actionEvent.getSource()){
           if(JOptionPane.showConfirmDialog(this,"Seguro que quieres eleminiar?") == 0){
               HybridNode selectedNodeExplorer = this.treePanel.getSelectedNodePanel();
               selectedNodeExplorer.removeAllChildren();
               selectedNodeExplorer.removeFromParent();
               DefaultTreeModel model = (DefaultTreeModel)this.treePanel.getTree().getModel();
               HybridNode root = selectedNodeExplorer;
               model.reload(root);
           }
        }else if(this.createFolderButton == actionEvent.getSource()){
           DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
           Date date = new Date();//Obtener fecha actual

           Folder folder = new Folder("Folder Prueba",dateFormat.format(date),"D:/creado boton/");
           HybridNode tmpNode = folder.getFolderNode();

           System.out.println(this.treePanel.getSelectedNodePanel());

           HybridNode selectedNodeExplorer = this.treePanel.getSelectedNodePanel();
           selectedNodeExplorer.getFileComponentOfNode().add(folder);//Añadir archivo al componente de archivo que tiene ese nodo

           DefaultTreeModel model = (DefaultTreeModel)this.treePanel.getTree().getModel();
           HybridNode root = selectedNodeExplorer;
           root.add(tmpNode);
           model.reload(root);

        }
    }
}
