package by.it.akhmelev.project05.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<TYPE> {

    boolean create(TYPE bean) throws SQLException;
    boolean update(TYPE bean) throws SQLException;
    boolean delete(TYPE bean) throws SQLException;
    TYPE read(long id) throws SQLException;
    List<TYPE> getAll() throws SQLException;
    List<TYPE> getAll(String where) throws SQLException;

}
