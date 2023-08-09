package Serialize;

import java.io.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Serialize {

    public void saveGame(String fullPath, Object[] object) {
        if (object.length != 0) {
            for (Object obj : object) {
                String saveName = "Save_" + obj.hashCode() + "_" + new Timestamp(new Date().getTime()) + ".dat";
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fullPath + saveName))) {
                    oos.writeObject(obj);
                    System.out.println("File " + fullPath + saveName + " was created");
                } catch (IOException exc) {
                    System.out.println(exc.getLocalizedMessage());
                }
            }
        } else {
            System.out.println("Пустой массив сохранений!");
        }
    }

    public void zipFiles(String fullPath, List<String> listOfZippingFiles) {
        if (listOfZippingFiles.size() != 0) {

            String filepath;

            try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(fullPath))) {
                for (String str : listOfZippingFiles) {
                    filepath = "Games/savegames/" + str;
                    FileInputStream fis = new FileInputStream(filepath);
                    ZipEntry zipEntry = new ZipEntry(filepath);

                    zos.putNextEntry(zipEntry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zos.write(buffer);
                    fis.close();

                    System.out.println(eraser(filepath) ? "File " + str + " was deleted" : "File wasn\'t deleted");
                }
                zos.closeEntry();
            } catch (IOException exc) {
                System.out.println(exc.getLocalizedMessage());
            }
        } else {
            System.out.println("Пустой массив сохранений!");
        }
    }

    public List<String> getListOfSaves(String fullPath) {
        return Stream.of(new File(fullPath).listFiles()).filter(x -> x.getName().contains(".dat")).map(File::getName).collect(Collectors.toList());
    }

    public boolean eraser(String fullPath) {
        return new File(fullPath).delete();
    }
}
