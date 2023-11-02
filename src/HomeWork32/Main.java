package HomeWork32;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    private static final String pathForSaveFile1 = "C:" + File.separator + "Games" + File.separator + "savegames" + File.separator + "save1.dat";
    private static final String pathForSaveFile2 = "C:" + File.separator + "Games" + File.separator + "savegames" + File.separator + "save2.dat";
    private static final String pathForSaveFile3 = "C:" + File.separator + "Games" + File.separator + "savegames" + File.separator + "save3.dat";
    private static final String pathForZip = "C:" + File.separator + "Games" + File.separator + "savegames" + File.separator + "savegame.zip";
    private static final String pathForOpenFileForDes = "C:" + File.separator + "Games" + File.separator + "savegames" + File.separator + "save1.dat";
    static String[] pathOfObj = new String[3];
    static GameProgress gameProgress1 = new GameProgress(2, 1, 10, 4);
    static GameProgress gameProgress2 = new GameProgress(4, 2, 11, 5.5);
    static GameProgress gameProgress3 = new GameProgress(15, 3, 20, 10.5);

    public static void main(String[] args) {
        savaGames(gameProgress1, gameProgress2, gameProgress3);
        createZipArchive(pathForZip, pathOfObj);
        deleteFile();
        openZip();
        openProgress();
    }

    public static void savaGames(GameProgress gameProgresses1, GameProgress gameProgresses2, GameProgress gameProgresses3) {
        try (BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream(pathForSaveFile1)); ObjectOutputStream oos = new ObjectOutputStream(bos1);
             BufferedOutputStream bos2 = new BufferedOutputStream(new FileOutputStream(pathForSaveFile2)); ObjectOutputStream oos2 = new ObjectOutputStream(bos2);
             BufferedOutputStream bos3 = new BufferedOutputStream(new FileOutputStream(pathForSaveFile3)); ObjectOutputStream oos3 = new ObjectOutputStream(bos3)) {
            oos.writeObject(gameProgresses1);
            oos2.writeObject(gameProgresses2);
            oos3.writeObject(gameProgresses3);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public static void createZipArchive(String pathForZip, String[] pathOfObj) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(pathForZip))) {
            pathOfObj[0] = pathForSaveFile1;
            pathOfObj[1] = pathForSaveFile2;
            pathOfObj[2] = pathForSaveFile3;
            for (int i = 0; i < pathOfObj.length; i++) {
                FileInputStream fis = new FileInputStream(pathOfObj[i]);
                ZipEntry zipEntry = new ZipEntry(pathOfObj[i]);
                zout.putNextEntry(zipEntry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
                fis.close();
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public static void deleteFile() {
        final File pathForSaveFile1 = new File("C:" + File.separator + "Games" + File.separator + "savegames" + File.separator + "save1.dat");
        final File pathForSaveFile2 = new File("C:" + File.separator + "Games" + File.separator + "savegames" + File.separator + "save2.dat");
        final File pathForSaveFile3 = new File("C:" + File.separator + "Games" + File.separator + "savegames" + File.separator + "save3.dat");
        pathForSaveFile1.delete();
        System.out.println("Файл " + pathForSaveFile1.getName() + " удален");
        pathForSaveFile2.delete();
        System.out.println("Файл " + pathForSaveFile2.getName() + " удален");
        pathForSaveFile3.delete();
        System.out.println("Файл " + pathForSaveFile3.getName() + " удален");
    }

    public static void openZip() {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(pathForZip))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fout = new FileOutputStream(name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void openProgress() {
        GameProgress gameProgress;
        try (BufferedInputStream bos = new BufferedInputStream(new FileInputStream(pathForOpenFileForDes)); ObjectInputStream ois = new ObjectInputStream(bos)) {
            gameProgress = (GameProgress) ois.readObject();
            System.out.println(gameProgress.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
