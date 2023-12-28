package news.view;

import java.sql.SQLException;

import news.dao.NewDAO;

public class View {
	public static void main(String[] args) {
		try {
			NewDAO.intsertData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
