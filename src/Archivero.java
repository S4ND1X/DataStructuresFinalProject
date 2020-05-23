import javax.swing.*;

public class Archivero {

    private FileComponent folderList;
    private JTree masterNode;

    public Archivero(FileComponent folderList){
        this.folderList = folderList;
        this.masterNode = new JTree(folderList.getFileComponentNode());
    }

    public JTree getMasterNode(){
        return  this.masterNode;
    }

    public void getFileList(){
        this.folderList.displayFileInfo();
    }

}
