public class Main {
    public static void main(String[] args) {

        FileWorker fw = new FileWorker();
        LogWriter logWriter = new LogWriter();

        //TODO В папке Games создайте несколько директорий: src, res, savegames, temp.
        fw.createDirs("Games", new String[]{"src", "res", "savegames", "temp"});

        //TODO В каталоге src создайте две директории: main, test.
        fw.createDirs("Games/src", new String[]{"main", "test"});

        //TODO В подкаталоге main создайте два файла: Main.java, Utils.java.
        fw.createFiles("Games/src/main", new String[]{"Main.java", "Utils.java"});

        //TODO В каталог res создайте три директории: drawables, vectors, icons.
        fw.createDirs("Games/res", new String[]{"drawables", "vectors", "icons"});

        //TODO В директории temp создайте файл temp.txt.
        fw.createFile("Games/temp", "temp.txt");

        logWriter.writeLog(fw.getLog());
    }

}