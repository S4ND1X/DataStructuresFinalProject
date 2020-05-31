/**
 * @author Jorge Sánchez Díaz
 * @version v1.0
 */
import javafx.scene.layout.Border;

import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Flow;

public class FileExplorerControls extends JPanel implements ActionListener {

    private JButton createFileButton,
                    createFolderButton,
                    removeComponentButton,
                    renameComponentButton,
                    fileInfoButton;
    private TreePanel treePanel;

    public FileExplorerControls(TreePanel treePanel){
        //Initialize Panel
        super();
        this.setLayout(new GridLayout());
        this.setBackground(new Color(255, 212, 160));
        //initialize treePanel
        this.treePanel = treePanel;



        //Initialize Icons
        Icon folderIco = createIcon("folder.png");
        Icon removeIco = createIcon("remove.png");
        Icon fileIco = createIcon("file.png");
        Icon renameIco = createIcon("rename.png");
        Icon infoIco = createIcon("info.png");
        //Initialize buttons
        this.createFileButton = createButton("New File", fileIco);
        this.createFolderButton = createButton("New Folder", folderIco);

        this.removeComponentButton = createButton("Delete", removeIco);
        this.removeComponentButton.setBackground(new Color(255, 77, 82));
        this.renameComponentButton = createButton("Rename", renameIco);
        this.fileInfoButton  = createButton("Info", infoIco);

        //Add everything to the panel
        this.add(this.createFileButton);
        this.add(this.createFolderButton);
        this.add(renameComponentButton);
        this.add(this.fileInfoButton);
        this.add(this.removeComponentButton);



    }


    /**
     *
     * @param buttonName Name of the JButton
     * @return The new JButton with that name
     */
    private JButton createButton(String buttonName, Icon icon){
        JButton tmp = new JButton(buttonName);
        tmp.setBackground(new Color(0, 0, 0));
        tmp.setForeground(Color.WHITE);
        tmp.setFocusPainted(false);
        tmp.setFont(new Font("Tahoma", Font.BOLD, 16));
        tmp.setBorderPainted(false);
        tmp.setIcon(icon);
        tmp.addActionListener(this);
        return tmp;
    }//Create buttons with style and listener

    private Icon createIcon(String iconName){
        return new ImageIcon(getClass().getResource(iconName));
    }//create icons with the name of the image

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
        if(selectedNodeExplorer == null){ return; }
       if(this.renameComponentButton == actionEvent.getSource()){
            String tmp = JOptionPane.showInputDialog(this,"Enter new name: ");
            if(tmp == null){ return;}
            //Get the selected node and rename that object
            selectedNodeExplorer.getFileComponentOfNode().setComponentName(tmp);
            selectedNodeExplorer.setUserObject(tmp);

       }else if(this.removeComponentButton == actionEvent.getSource()){
           //If the user confirms the remove then we remove all childrens and then we remove the current node from the parent
           if(JOptionPane.showConfirmDialog(this,
                                            "This action cannot be undone.\n Are you sure you want to delete this file?") == 0){
               selectedNodeExplorer.removeAllChildren();
               selectedNodeExplorer.removeFromParent();
           }else{ return; }
       }else if(this.createFolderButton == actionEvent.getSource()){
           String tmp = JOptionPane.showInputDialog(this,"New Folder name: ");
           if(tmp == null){ return;}
           try{
               Folder newFolder = new Folder(tmp, selectedNodeExplorer.getFileComponentOfNode().getFileName());
               selectedNodeExplorer.getFileComponentOfNode().add(newFolder);
           }catch (UnsupportedOperationException ex){
               JOptionPane.showMessageDialog(this,"Cannot create a folder inside a file");
           }
       }else if(this.createFileButton == actionEvent.getSource()){
           String tmp = JOptionPane.showInputDialog(this,"New Folder name: ");
           if(tmp == null){ return;}
           try{
               File newFile = new File(tmp, selectedNodeExplorer.getFileComponentOfNode().getFileName());
               selectedNodeExplorer.getFileComponentOfNode().add(newFile);
           }catch (UnsupportedOperationException ex){
               JOptionPane.showMessageDialog(this,"Cannot create any document inside a file");
           }
       }else if(this.fileInfoButton == actionEvent.getSource()){
           try{
               Folder folder = (Folder) selectedNodeExplorer.getFileComponentOfNode();
               String message = "Folder name: " + folder.getFileName() + "\nPath: "+ folder.getAbsolutePath() +
                                "\nCreation date: " + folder.getCreationDate() +
                                "\nNumber of files: " + folder.getAllChildCount();
               System.out.println(folder.getAllChildCount());
               JOptionPane.showMessageDialog(null, message,"Folder Information",
                                            JOptionPane.INFORMATION_MESSAGE,createIcon("infoMessage.png"));
           }catch (ClassCastException ex){
               File file = (File) selectedNodeExplorer.getFileComponentOfNode();
               String message = "File name: " + file.getFileName() + "\nPath: "+ file.getAbsolutePath() +
                       "\nCreation date: " + file.getCreationDate();
               JOptionPane.showMessageDialog(null, message,"File Information",
                       JOptionPane.INFORMATION_MESSAGE,createIcon("infoMessage.png"));
           }

           selectedNodeExplorer.getFileComponentOfNode().displayFileInfo();

       }

        refreshTreeUI(selectedNodeExplorer);
    }
}
