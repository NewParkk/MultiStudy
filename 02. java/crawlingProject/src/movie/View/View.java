package movie.View;

import java.sql.SQLException;

import crawlingProject.Rottentomatoes;

public class View {

	public static void main(String[] args) {
		try {
			Rottentomatoes.collectData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
