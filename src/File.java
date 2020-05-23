import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Iterator;

public class File extends FileComponent{

    private String fileName;
    private String fileCreationDate;
    private String fileAbsolutePath;
    private DefaultMutableTreeNode fileNode;


    public File(String fileName, String fileCreationDate, String fileAbsolutePath){
        this.fileName = fileName;
        this.fileCreationDate = fileCreationDate;
        this.fileAbsolutePath = fileAbsolutePath;
        this.fileNode = new DefaultMutableTreeNode(fileName);

    }



    @Override
    public void displayFileInfo(){
        System.out.println(getFileName() +  " creado el " + getCreationDate() +  " en " + getAbsolutePath());
    }

    //- -  - - - - - - - - - Getters - - - - - - - - - - -
    @Override
    public DefaultMutableTreeNode getFileComponentNode() { return this.fileNode; }
    @Override
    public String getCreationDate() { return fileCreationDate; }
    @Override
    public String getAbsolutePath() { return fileAbsolutePath; }
    @Override
    public String getFileName() { return fileName; }
}
