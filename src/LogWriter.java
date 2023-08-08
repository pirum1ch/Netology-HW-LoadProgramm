import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class LogWriter {

    private final String LOGFILEPATH = "Games/temp/temp.txt";

    public void writeLog(String log) {
        if (log.length() != 0) {
            try (Writer writer = new FileWriter(LOGFILEPATH)) {
                System.out.println(log);
                writer.write(log);
            } catch (IOException exc) {
                System.out.println("Ошибка записи в файл!");
                System.out.println(exc.getLocalizedMessage());
            }
        } else {
            System.out.println("Пустой лог!");
        }

    }
}
