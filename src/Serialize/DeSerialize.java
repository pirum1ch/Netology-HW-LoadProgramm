package Serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DeSerialize {

    // TODO   Произвести распаковку архива в папке savegames.
    public void openZip(String fullPathToZipFile, String fullPathtoExtractDir) {
        if (fullPathToZipFile.length() != 0 && fullPathtoExtractDir.length() != 0) {
            try (ZipInputStream zis = new ZipInputStream(new FileInputStream(fullPathToZipFile))) {
                ZipEntry zipEntry;

                while ((zipEntry = zis.getNextEntry()) != null) {

                    FileOutputStream fos = new FileOutputStream(zipEntry.getName());
                    for (int i = zis.read(); i != -1; i = zis.read()) {
                        fos.write(i);
                    }
                    fos.flush();
                    fos.close();
                    zis.closeEntry();
                }
            } catch (IOException exception) {
                System.out.println(exception.getLocalizedMessage());
            }
        }
    }

    // TODO   Произвести считывание и десериализацию одного из разархивированных файлов save.dat.
    public void deSerializeSaveGame(String fullPathToFile) {
        GameProgress gameProgress = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fullPathToFile))) {

            gameProgress = (GameProgress) ois.readObject();

        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        System.out.println(gameProgress);
    }

}
