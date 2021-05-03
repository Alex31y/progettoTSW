package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public interface ProductModel {
	public void doSave(ArticoloBean product) throws SQLException;

	public boolean doDelete(int code) throws SQLException;

	public ArticoloBean getArticolo(int id) throws SQLException;
	
	public ArrayList<ArticoloBean> getArticoli(String order) throws SQLException;
}
