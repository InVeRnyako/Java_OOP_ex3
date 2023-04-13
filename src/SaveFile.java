import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SaveFile implements Serializable {
    private String saveFileName;
    private String path = System.getProperty("user.dir");

    public SaveFile(String saveName) {
        saveFileName = path.concat("/" + saveName + ".data");
    }

    public SaveFile() {
        saveFileName = path.concat("/test.data");
    }

    public void saveData(Object objectToSave) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFileName))) {
            oos.writeObject(objectToSave);
            System.out.println("File has been written");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Object readData() {
        Object importObject = new Tree();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFileName))) {
            importObject = ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return importObject;
    }

}
