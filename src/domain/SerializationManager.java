package domain;

import java.io.*;

public class SerializationManager {
    public static void serializeResults(String[] results) {
        try {
            FileOutputStream fileOut = new FileOutputStream("result.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(results);
            out.close();
            fileOut.close();
            System.out.println("Результати були серіалізовані в файл result.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] deserializeResults() {
        String[] results = null;
        try {
            FileInputStream fileIn = new FileInputStream("result.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            results = (String[]) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Результати були десеріалізовані.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return results;
    }
}
