import Serialize.DeSerialize;
import Serialize.GameProgress;
import Serialize.Serialize;

public class Main {
    public static void main(String[] args) {

        //Задание 1
        FileWorker fw = new FileWorker();
        LogWriter logWriter = new LogWriter();
        Serialize saveGame = new Serialize();
        DeSerialize deSer = new DeSerialize();

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


        //Задание 2
        //TODO Создать три экземпляра класса GameProgress.
        GameProgress gp1 = new GameProgress(100, 1, 22, 250.4);
        GameProgress gp2 = new GameProgress(90, 2, 45, 554.4);
        GameProgress gp3 = new GameProgress(20, 4, 55, 600.1);


        saveGame.saveGame("Games/savegames/", new Object[]{gp1, gp2, gp3});
        saveGame.zipFiles("Games/savegames/zip.zip", saveGame.getListOfSaves("Games/savegames/"));

        // Задание 3
        deSer.openZip("Games/savegames/zip.zip", "Games");
        // TODO   Вывести в консоль состояние сохранненой игры.
        saveGame.getListOfSaves("Games/savegames/").stream().map(x -> "Games/savegames/" + x).forEach(deSer::deSerializeSaveGame);

    }

}