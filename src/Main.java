import Serialize.GameProgress;
import Serialize.Serialize;

public class Main {
    public static void main(String[] args) {

        //Задание 1
        String workPath = "Games";

        FileWorker fw = new FileWorker();
        LogWriter logWriter = new LogWriter();
        Serialize saveGame = new Serialize();

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


        //Задание 2
        //TODO Создать три экземпляра класса GameProgress.
        GameProgress gp1 = new GameProgress(100, 1, 22, 250.4);
        GameProgress gp2 = new GameProgress(90, 2, 45, 554.4);
        GameProgress gp3 = new GameProgress(20, 4, 55, 600.1);


        saveGame.saveGame(workPath + "/savegames/", new Object[] {gp1, gp2, gp3});
        saveGame.zipFiles(workPath + "/savegames/", saveGame.getListOfSaves(workPath + "/savegames/"));


    }

}