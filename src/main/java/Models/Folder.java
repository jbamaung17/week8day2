package Models;

import java.util.List;

public class Folder {
    private String title;
    private List<File> files;

    public Folder() {}

    public Folder(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
