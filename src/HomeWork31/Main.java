package HomeWork31;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static String path1 = "C:" + File.separator + "Games" + File.separator;
    private static String path2 = "C:" + File.separator + "Games" + File.separator + "src" + File.separator;
    private static String path3 = "C:" + File.separator + "Games" + File.separator + "res" + File.separator;
    private static String path4 = "C:" + File.separator + "Games" + File.separator + "src" + File.separator + "main" + File.separator;
    private static String path5 = "C:" + File.separator + "Games" + File.separator + "temp" + File.separator;
    private static StringBuilder sbForDirectoriesAndFiles = new StringBuilder();
    static String separator = System.lineSeparator();

    public static void main(String[] args) {
        createSrcDirectory("src");
        createResDirectory("res");
        createSavegamesDirectory("savegames");
        createTempDirectory("temp");
        createMainDirectory("main");
        createTestDirectory("test");
        createDrawablesDirectory("drawables");
        createVectorsDirectory("vectors");
        createIconsDirectory("icons");
        createMainFile("Main.java");
        createUtilsFile("Utils.java");
        createTextFile("temp.txt");
        writeInfoInFile();
    }

    private static void createSrcDirectory(String nameDir) {
        File src = new File(path1 + nameDir);
        if (src.mkdir()) {
            sbForDirectoriesAndFiles.append("Каталог " + src.getName() + " был создан");
        }
    }

    private static void createResDirectory(String nameDir) {
        File res = new File(path1 + nameDir);
        if (res.mkdir()) {
            sbForDirectoriesAndFiles.append(separator).append("Каталог " + res.getName() + " был создан");
        }
    }

    private static void createSavegamesDirectory(String nameDir) {
        File savegames = new File(path1 + nameDir);
        if (savegames.mkdir()) {
            sbForDirectoriesAndFiles.append(separator).append("Каталог " + savegames.getName() + " был создан");
        }
    }

    private static void createTempDirectory(String nameDir) {
        File temp = new File(path1 + nameDir);
        if (temp.mkdir()) {
            sbForDirectoriesAndFiles.append(separator).append("Каталог " + temp.getName() + " был создан");
        }
    }

    private static void createMainDirectory(String nameDir) {
        File main = new File(path2 + nameDir);
        if (main.mkdir()) {
            sbForDirectoriesAndFiles.append(separator).append("Каталог " + main.getName() + " был создан");
        }
    }

    private static void createTestDirectory(String nameDir) {
        File test = new File(path2 + nameDir);
        if (test.mkdir()) {
            sbForDirectoriesAndFiles.append(separator).append("Каталог " + test.getName() + " был создан");
        }
    }

    private static void createDrawablesDirectory(String nameDir) {
        File drawables = new File(path3 + nameDir);
        if (drawables.mkdir()) {
            sbForDirectoriesAndFiles.append(separator).append("Каталог " + drawables.getName() + " был создан");
        }
    }

    private static void createVectorsDirectory(String nameDir) {
        File vectors = new File(path3 + nameDir);
        if (vectors.mkdir()) {
            sbForDirectoriesAndFiles.append(separator).append("Каталог " + vectors.getName() + " был создан");
        }
    }

    private static void createIconsDirectory(String nameDir) {
        File icons = new File(path3 + nameDir);
        if (icons.mkdir()) {
            sbForDirectoriesAndFiles.append(separator).append("Каталог " + icons.getName() + " был создан");
        }
    }

    private static void createMainFile(String nameFile) {
        File mainJava = new File(path4 + nameFile);
        try {
            if (mainJava.createNewFile()) {
                sbForDirectoriesAndFiles.append(separator).append("Файл " + mainJava.getName() + " был создан");
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    private static void createUtilsFile(String nameFile) {
        File utilsJava = new File(path4 + nameFile);
        try {
            if (utilsJava.createNewFile()) {
                sbForDirectoriesAndFiles.append(separator).append("Файл " + utilsJava.getName() + " был создан");
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    private static void createTextFile(String nameFile) {
        File text = new File(path5 + nameFile);
        try {
            if (text.createNewFile()) {
                sbForDirectoriesAndFiles.append(separator).append("Файл " + text.getName() + " был создан");
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    private static void writeInfoInFile() {
        String result = sbForDirectoriesAndFiles.toString();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:" + File.separator + "Games" + File.separator + "temp" + File.separator + "temp.txt", false))) {
            bw.write(result);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

}

