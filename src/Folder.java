import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.Iterator;

public class Folder extends FileComponent {

    private ArrayList fileComponents;
    private String folderName;
    private String folderCreationDate;
    private String folderAbsolutePath;
    private DefaultMutableTreeNode folderNode;

    public Folder(String folderName, String folderCreationDate, String folderAbsolutePath){
        this.fileComponents = new ArrayList();
        this.folderName = folderName;
        this.folderAbsolutePath = folderAbsolutePath;
        this.folderCreationDate = folderCreationDate;
        this.folderNode = new DefaultMutableTreeNode(folderName);
    }

    @Override
    public DefaultMutableTreeNode getFileComponentNode() { return this.folderNode; }
    @Override
    public void add(FileComponent newFileComponent){
        this.fileComponents.add(newFileComponent);
    }
    @Override
    public void remove(FileComponent newFileComponent){
        this.fileComponents.remove(newFileComponent);
    }
    @Override
    public void displayFileInfo(){
        System.out.println(getFileName() +  " creado el " + getCreationDate() +  " en " + getAbsolutePath());

        Iterator fileIterator = fileComponents.iterator();

        while(fileIterator.hasNext()){
            FileComponent fileInfo = (FileComponent) fileIterator.next();
            fileInfo.displayFileInfo();
            this.folderNode.add(fileInfo.getFileComponentNode());
        }
    }


    public DefaultMutableTreeNode getFolderNode(){
        return this.folderNode;
    }

    //- -  - - - - - - - - - Getters - - - - - - - - - - -
    @Override
    public FileComponent getFileComponent(int fileComponentIndex){
        return (FileComponent) this.fileComponents.get(fileComponentIndex);
    }
    @Override
    public String getFileName(){ return this.folderName; }
    @Override
    public String getCreationDate(){ return this.folderCreationDate; }
    @Override
    public String getAbsolutePath(){ return this.folderAbsolutePath; }





}
