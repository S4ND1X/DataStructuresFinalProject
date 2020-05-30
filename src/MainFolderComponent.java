import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class MainFolderComponent {

    private FileComponent folderList;
    private JTree treeNodeMain;

    public MainFolderComponent(FileComponent folderList){

        this.folderList = folderList;
        setTreeNode(folderList);
    }

    public JTree getTreeNode(){
        return this.treeNodeMain;
    }

    public  void setTreeNode(FileComponent mainNode){
        this.treeNodeMain = new JTree(mainNode.getFileComponentNode());//JTree se crea con el nodo raiz
    }

    public void getFileList(){
        this.folderList.displayFileInfo();
    }

}