package file;

import dao.DAO;

import java.io.IOException;

public interface FileManager {
    void save(DAO collection) throws IOException;
    DAO get();
}
