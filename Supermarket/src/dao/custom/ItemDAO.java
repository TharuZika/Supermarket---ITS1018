package dao.custom;

import dao.CrudDAO;
import model.Item;
import java.sql.SQLException;

public class ItemDAO extends CrudDAO<Item,String>{
    boolean ifItemExist(String code) throws SQLException, ClassNotFoundException;
    String generateNewID() throws SQLException, ClassNotFoundException;
}
