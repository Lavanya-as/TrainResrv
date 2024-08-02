import java.sql.*;

public class TrainDAO {
	public void displayTrainInfo() throws SQLException {
		String query = "Select * from train";
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			System.out.println("Train No: " + rs.getInt(1));
			if (rs.getInt(2) == 0)
				System.out.println("AC: no ");
			else
				System.out.println("AC: yes ");
			System.out.println("Capacity: " + rs.getInt(3));
		}

		System.out.println("------------------------------------------");
	}

	public int getCapacity(int id) throws SQLException {
		String query = "Select capacity from train where id=" + id;
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
}
