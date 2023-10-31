package dataacess;

import common.Library;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



public class WordFileDAO {
    private static WordFileDAO instance = null;
    Library l;
    
    
    public WordFileDAO() {
        l = new Library();        
    }

    public static WordFileDAO Instance() {
        if (instance == null) {
            synchronized (WordFileDAO.class) {
                if (instance == null) {
                    instance = new WordFileDAO();
                }
            }
        }
        return instance;
    }
    
    public int countWordInFile(String fileSource, String word) {
        FileReader fr = null;

        try {
            fr = new FileReader(fileSource);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int count = 0;
            while (line != null) {
                String[] parts = line.split(" ");
                for (String w : parts) {
                    if (w.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
                line = br.readLine();
            }
            return count;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public void getFileNameContainsWordInDirectory(String source, String word) {
        File folder = new File(source);
        File[] listOfFiles = folder.listFiles();
        try {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    if (countWordInFile(file.getAbsolutePath(), word) != 0) {
                        System.out.println("file name: " + file.getName());
                    }
                }
            }
        }
        catch(Exception e) {
            System.out.println("Path not exist");
        }
    }
    
    public void getInput(int choice) {
        switch (choice) {
            case 1: {
                String path = l.checkInputPathFile("Enter Path: ");
                String word = l.inputString("Enter Word: ");    
                int count = countWordInFile(path, word);
                System.out.println("Count: " + count);
                break;
            }
            case 2: {
                String path = l.inputString("Enter Path: ");
                String word = l.inputString("Enter Word: ");
                getFileNameContainsWordInDirectory(path, word);
                break;
            }
        }
    }

}
