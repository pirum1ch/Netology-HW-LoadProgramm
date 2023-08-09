public class Main {
    public static void main(String[] args) {

        String workPath = "Games";

        FileWorker fw = new FileWorker();
        LogWriter logWriter = new LogWriter();

        //TODO В папке Games создайте несколько директорий: src, res, savegames, temp.
        fw.createDirs(workPath, new String[]{"src", "res", "savegames", "temp"});

        //TODO В каталоге src создайте две директории: main, test.
        fw.createDirs(workPath + "/src", new String[]{"main", "test"});

        //TODO В подкаталоге main создайте два файла: Main.java, Utils.java.
        fw.createFiles(workPath + "/src/main", new String[]{"Main.java", "Utils.java"});

        //TODO В каталог res создайте три директории: drawables, vectors, icons.
        fw.createDirs(workPath + "/res", new String[]{"drawables", "vectors", "icons"});

        //TODO В директории temp создайте файл temp.txt.
        fw.createFile(workPath + "/temp", "temp.txt");

        logWriter.writeLog(fw.getLog());
    }

}