import javax.swing.tree.DefaultMutableTreeNode;

public abstract class FileComponent {

    public void add(FileComponent newFileComponent){
        throw new UnsupportedOperationException();
    }

    public void remove(FileComponent newFileComponent){
        throw new UnsupportedOperationException();
    }

    public FileComponent getFileComponent(int fileComponentIndex){ throw new UnsupportedOperationException(); }

    public void setComponentName(String componentName){ throw new UnsupportedOperationException(); }

    public String getFileName(){
        throw new UnsupportedOperationException();
    }

    public String getCreationDate(){
        throw new UnsupportedOperationException();
    }

    public String getAbsolutePath(){
        throw new UnsupportedOperationException();
    }

    public void displayFileInfo(){
        throw new UnsupportedOperationException();
    }

    protected abstract HybridNode getFileComponentNode();
}
