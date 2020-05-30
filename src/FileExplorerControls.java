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
    private JLabel absoluthPathLabel,
                    creationDateLabel;
    private TreePanel treePanel;

    public FileExplorerControls(TreePanel treePanel){
        //Initialize Panel
        super();
        this.setPreferredSize(new Dimension(1280,100));
        this.setBackground(Color.black);
        //initialize treePanel
        this.treePanel = treePanel;
        //Initialize Labels
        this.absoluthPathLabel = new JLabel("Absolut path: ");
        this.absoluthPathLabel.setFont(new Font("Consolas", Font.ITALIC, 18));
        this.absoluthPathLabel.setForeground(Color.WHITE);

        this.creationDateLabel = new JLabel("Creation date: ");
        this.creationDateLabel.setFont(new Font("Consolas", Font.ITALIC, 17));
        this.creationDateLabel.setForeground(Color.WHITE);
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
        this.add(this.createFolderButton);
        this.add(this.removeComponentButton);
        this.add(renameComponentButton);
        this.add(this.absoluthPathLabel);
        this.add(this.creationDateLabel);


    }


    /**
     *
     * @param buttonName Name of the JButton
     * @return The new JButton with that name
     */
    private JButton createButton(String buttonName){
        return new JButton(buttonName);
    }//Create buttons

    /**
     * @param root Node from wich the UI is going to update
     */
    private void refreshTreeUI(HybridNode root){
        DefaultTreeModel model = (DefaultTreeModel)this.treePanel.getTree().getModel();
        model.reload(root);
    }//Update tree UI



    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        HybridNode selectedNodeExplorer = this.treePanel.getSelectedNodePanel();
        this.absoluthPathLabel.setText("Absolut Path: " +
                                        selectedNodeExplorer.getFileComponentOfNode().getAbsolutePath());
        this.creationDateLabel.setText("Creation date: " +
                                        selectedNodeExplorer.getFileComponentOfNode().getCreationDate());

       if(this.renameComponentButton == actionEvent.getSource()){
           String tmp = JOptionPane.showInputDialog(this,"Enter new name: ");

           //Get the selected node and rename that object
           selectedNodeExplorer.getFileComponentOfNode().setComponentName(tmp);
           selectedNodeExplorer.setUserObject(tmp);

       }else if(this.removeComponentButton == actionEvent.getSource()){
           //If the user confirms the remove then we remove all childrens and then we remove the current node from the parent
           if(JOptionPane.showConfirmDialog(this,
                                            "This action cannot be undone.\n Are you sure you want to delete this file?") == 0){
               selectedNodeExplorer.removeAllChildren();
               selectedNodeExplorer.removeFromParent();
           }
       }else if(this.createFolderButton == actionEvent.getSource()){
           String tmp = JOptionPane.showInputDialog(this,"New Folder name: ");
           try{
               Folder newFolder = new Folder(tmp, selectedNodeExplorer.getFileComponentOfNode().getFileName());
               selectedNodeExplorer.getFileComponentOfNode().add(newFolder);
           }catch (UnsupportedOperationException ex){
               JOptionPane.showMessageDialog(this,"Cannot create a folder inside a file");
           }
       }else if(this.createFileButton == actionEvent.getSource()){
           String tmp = JOptionPane.showInputDialog(this,"New Folder name: ");
           try{
               File newFile = new File(tmp, selectedNodeExplorer.getFileComponentOfNode().getFileName());
               selectedNodeExplorer.getFileComponentOfNode().add(newFile);
           }catch (UnsupportedOperationException ex){
               JOptionPane.showMessageDialog(this,"Cannot create any document inside a file");
           }

       }
        refreshTreeUI(selectedNodeExplorer);
    }
}
