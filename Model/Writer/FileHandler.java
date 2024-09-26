package Code.Model.Writer;

import Code.Model.AnimalList.AnimalList;

import java.io.*;

public class FileHandler implements Writer{
    @Override
    public void writeToFile(AnimalList object, String fileName) throws IOException {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(object);
            oos.close();
        }
        catch (IOException e) {
            throw new IOException();
        }
    }

    @Override
    public AnimalList readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (AnimalList) ois.readObject();
        }
    }
}
