package seventh;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


/**
 * Class FileManager
 *
 * @author Konstantsin Bolotko
 * @author Roslakov Andrew
 * @since 09.04.19
 */

public class FileManager {

    private File path;

    /**
     * If user input 0, it will be up in parent directory;
     * It is for copy file in opened directory, it need input absolute source path to file.
     *
     * @param startPath - it is directory with the program starts.
     */
    public void start(String startPath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            File fileList = new File(startPath);
            this.path = fileList;
            int n = 1;
            for (File f : fileList.listFiles()) {
                System.out.println(n++ + " " + f.toString());
            }
            System.out.println();
            boolean isStop = false;
            int i = 1;
            String userInput;
            do {
                userInput = reader.readLine();
                if (userInput.equals("create")) {
                    System.out.println("Input name of file");
                    File file = new File(path.toString().substring(0, path.toString().indexOf("\\")) + "/" + reader.readLine());
                    file.createNewFile();
                } else if (userInput.equals("create folder")) {
                    System.out.println("Input name of folder");
                    String nameOfFolder = reader.readLine();
                    File file = new File(path.toString().substring(0, path.toString().indexOf("\\")) + "/" + nameOfFolder);
                    file.mkdir();
                    System.out.println();
                    System.out.println("Folder called " + nameOfFolder + " was created");
                    System.out.println();
                    update();
                } else if (userInput.contains("delete")) {
                    int delete;
                    if (userInput.length() == 8) {
                        delete = Integer.valueOf(userInput.substring(7));
                    } else {
                        delete = Integer.valueOf(userInput.substring(7, 8));
                    }
                    File[] array = fileList.listFiles();
                    array[delete - 1].delete();
                } else if (!(userInput.contains(".")) & !(userInput.equals("stop")) & !(userInput.contains("delete"))
                        & !(userInput.equals("create")) & !(userInput.equals("create folder"))) {
                    this.path = fileList;
                    fileList = getOfListFilesInDirectory(Integer.valueOf(userInput), fileList);
                    if (!fileList.isFile()) {
                        this.path = fileList;
                    }
                    if (fileList.isDirectory()) {
                        for (File f : fileList.listFiles()) {
                            System.out.println(i++ + " " + f.toString());
                            this.path = fileList;
                        }
                        System.out.println();
                    } else {
                        System.out.println(i++ + " " + fileList.toString());
                        System.out.println();
                    }
                    i = 1;
                } else if (userInput.contains(".")) {
                    File fileCopyPath = new File(userInput);
                    String newFileCopyPath = fileCopyPath.toString().substring(fileCopyPath.toString().lastIndexOf("\\"));
                    File dest = new File(this.path + newFileCopyPath);
                    download(fileCopyPath, dest);
                    System.out.println();
                } else if (userInput.equals("delete")) {
                    userInput = reader.readLine();

                } else if (userInput.equals("stop")) {
                    isStop = true;
                }
            } while (!isStop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        int n = 1;
        for (File f : path.listFiles()) {
            System.out.println(n++ + " " + f.toString());
        }
        System.out.println();
    }


    public File getOfListFilesInDirectory(int number, File file) {
        File result;
        File[] f = file.listFiles();
        if (number == 0) {
            result = file.getParentFile();
        } else {
            result = f[number - 1];
        }
        return result;
    }


    /**
     * Method copies a file from a path to other a path.
     * <p>
     * If file is exist in this directory, it will be rewritten.
     *
     * @param src  absolute path for file.
     * @param dest absolute new path for file.
     */
    public void download(File src, File dest) {
        try {
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileManager sm = new FileManager();
        sm.start("d:\\\\");
    }
}