import DB.DBHelper;
import Models.File;
import Models.Folder;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Folder folder1 = new Folder("CodeClan work");
        DBHelper.save(folder1);

        File file1 = new File("Jean's Homework", "txt", 400, folder1);
        DBHelper.save(file1);
        File file2 = new File("Jean's pictures of cats", "jpg", 10000, folder1);
        DBHelper.save(file2);

        Folder foundFolder = DBHelper.find(Folder.class, folder1.getId());
        List<File> foundFiles = DBHelper.getAll(File.class);


    }
}
