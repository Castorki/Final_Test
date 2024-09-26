package Code.Model.Writer;

import Code.Model.AnimalList.AnimalList;

import java.io.IOException;

public interface Writer {

    void writeToFile(AnimalList object, String filename) throws IOException;
    AnimalList readFromFile(String filename) throws IOException, ClassNotFoundException;
}
