package by.it.narushevich.jd02_05;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFileLang {

    private static void createFileLang() {

        String defaultLang = createFile("txt" + File.separator + "message.txt");
        String russianLang = createFile("txt" + File.separator + "message_ru_RU.txt");
        String belorussianLang = createFile("txt" + File.separator + "message_be_BY.txt");

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(defaultLang));
                BufferedWriter writer2 = new BufferedWriter(new FileWriter(russianLang));
                BufferedWriter writer3 = new BufferedWriter(new FileWriter(belorussianLang))
        ) {
            writer.write("message.welcome=Welcome!\n" +
                    "message.question=How do you do?\n" +
                    "person.firstname=Marianna\n" +
                    "person.lastname=Narushevich\n" +
                    "error.error1=That locale don't exist\n");
            writer2.write("message.welcome=Привет!\n" + "message.question=Как дела?\n" +
                    "person.firstname=Марианна\n" +
                    "person.lastname=Нарушевич\n" +
                    "error.error1=Такая местность не существует\n");
            writer3.write("message.welcome=Прывітанне!\n" +
                    "message.question=Як справы?\n" +
                    "person.firstname=Марыана\n" +
                    "person.lastname=Нарушэвіч\n" +
                    "error.error1=Такая мясцовасць не існуе\n");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private static String createFile(String name) {
        String userDir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String pathPack = TaskB.class.getPackage().getName().replace(".", File.separator);
        return userDir + pathPack + File.separator + name;
    }

}
