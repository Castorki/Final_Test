package Code.Model.Service;

import Code.Model.AnimalList.AnimalList;
import Code.Model.Writer.Writer;

import java.io.IOException;

public class SaverLoader <T> {
    private final Writer writer;

    public SaverLoader(Writer writer) {
        this.writer = writer;
    }

    public void saveToFile(AnimalList tree, String fileName) throws IOException {
        try {
            writer.writeToFile(tree, fileName);
        } catch (IOException e) {

            throw new IOException();
        }
    }

    public AnimalList loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try {
            return writer.readFromFile(fileName);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
}
