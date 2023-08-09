package Serialize;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Serialize {
    public void saveGame(String fullPath, Object [] object){
        if (object.length != 0) {
            for (Object obj : object){
                String saveName = "Save_" + obj.hashCode() + "_" + new Timestamp(new Date().getTime()) +".dat";
                try(FileOutputStream fos = new FileOutputStream(fullPath + saveName); ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    oos.writeObject(obj);
                }catch (IOException exc){
                    System.out.println(exc.getLocalizedMessage());
                }
            }
        }else {
            System.out.println("Пустой массив сохранений!");
        }
    }

    public void zipFiles(String fullPath, List<String> listOfZippingFiles) {
        if (listOfZippingFiles.size() != 0) {
            String zipName = "ZIP_" + new Timestamp(new Date().getTime()) +".zip";
            try(FileOutputStream fos = new FileOutputStream(fullPath + zipName);
                ZipOutputStream zos = new ZipOutputStream(fos))
            {
                for (String str : listOfZippingFiles){
                    ZipEntry zipEntry = new ZipEntry(str);
                    zos.putNextEntry(zipEntry);
                    System.out.println(eraser(str)?"File " + str + " was deleted":"File wan\'t deleted");
                }
            }catch (IOException exc){
                System.out.println(exc.getLocalizedMessage());
            }
        }else {
            System.out.println("Пустой массив сохранений!");
        }
    }

    public List<String> getListOfSaves(String fullPath){
        return Stream.of(new File(fullPath).listFiles()).filter(x -> x.getName().contains(".dat")).map(File::getAbsolutePath).collect(Collectors.toList());
    }

    public boolean eraser(String fullPath){
        return new File(fullPath).delete();
    }
}
