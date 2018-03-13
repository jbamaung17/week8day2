package Models;

public class File {
    private String name;
    private String extention;
    private int size;
    private Folder folder;

    public File() {}

    public File(String name, String extention, int size, Folder folder) {
        this.name = name;
        this.extention = extention;
        this.size = size;
        this.folder = folder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
