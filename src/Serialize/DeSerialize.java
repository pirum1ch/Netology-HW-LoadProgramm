package Serialize;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DeSerialize{

// TODO   Произвести распаковку архива в папке savegames.
    public void openZip (String fullPathToZipFile, String fullPathtoExtractDir){
        if(fullPathToZipFile.length()!=0 && fullPathtoExtractDir.length() != 0){
            try(FileInputStream fis = new FileInputStream(fullPathToZipFile);
                ZipInputStream zis = new ZipInputStream(fis))
            {
                ZipEntry zipEntry;
                String fileName;

                while ((zipEntry = zis.getNextEntry()) != null){
                    fileName = zipEntry.getName();

                    FileOutputStream fos = new FileOutputStream(fileName);
                    for (int i = zis.read(); i != -1; i = zis.read()) {
                        fos.write(i);
                    }
                    fos.flush();
                    zis.closeEntry();
                    fos.close();
                }
            }catch (IOException exception){
                System.out.println(exception.getLocalizedMessage());
            }
        }
    }
// TODO   Произвести считывание и десериализацию одного из разархивированных файлов save.dat.
    public void deSerializeSaveGame(String fullPathToFile){
        GameProgress gameProgress = null;
        try(FileInputStream fis = new FileInputStream(fullPathToFile);
            ObjectInputStream ois = new ObjectInputStream(fis))
        {

            gameProgress = (GameProgress) ois.readObject();

        }catch (IOException | ClassNotFoundException exception){
            System.out.println(exception.getLocalizedMessage());
        }
        System.out.println(gameProgress);
    }

    public List<String> getListOfZips(String fullPath){
        return Stream.of(new File(fullPath).listFiles()).filter(x -> x.getName().contains(".zip")).map(File::getAbsolutePath).collect(Collectors.toList());
    }
// TODO   Вывести в консоль состояние сохранненой игры.




}
