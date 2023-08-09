import java.io.File;
import java.io.IOException;

public class FileWorker {

    private String log;
    StringBuilder stringBuilder = new StringBuilder();

    public String getLog() {
        return log;
    }

    public void createDir(String workPath, String newDirName) {
        checkParentDir(workPath);
        if (new File(workPath, newDirName).mkdir()) {
            log = stringBuilder.append("Directory \"").append(newDirName).append("\" was created successfully \n").toString();
        } else {
            log = stringBuilder.append("Directory \"").append(newDirName).append("\" was NOT created! \n").toString();
        }
    }

    public void createDirs(String workPath, String[] newDirNames) {
        if (newDirNames.length == 0) {
            stringBuilder.append("Empty array \n");
        } else {
            for (String newDirName : newDirNames) {
                createDir(workPath, newDirName);
            }
        }
    }

    public void createFile(String workPath, String newFileName) {
        try {
            if (new File(workPath, newFileName).createNewFile()) {
                stringBuilder.append("File \"").append(newFileName).append("\" was created successfully \n");
            }
        } catch (IOException exc) {
            stringBuilder.append("File \"").append(newFileName).append("\" was NOT created! \n");
            System.out.println(exc.getLocalizedMessage());
        }
    }

    public void createFiles(String workPath, String[] newFileNames) {
        for (String file : newFileNames) {
            createFile(workPath, file);
        }
    }

    public boolean checkParentDir(String parentDir) {
        File file = new File(parentDir);
        return file.exists() || file.mkdir();
    }
}
