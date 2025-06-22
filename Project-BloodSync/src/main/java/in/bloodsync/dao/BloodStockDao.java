package in.bloodsync.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.bloodsync.dbutil.DBConnection;
import in.bloodsync.pojo.BloodStockPojo;

public class BloodStockDao {
	public static List<BloodStockPojo> getAllBloodStock() throws SQLException{
		Connection conn=DBConnection.getConnection();
		String query="SELECT * FROM blood_stock";
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(query);
		List<BloodStockPojo> stocks=new ArrayList<>();
		BloodStockPojo stock = new BloodStockPojo();
		while(rs.next()) {
			stock.setBloodType(rs.getString("blood_type"));
			stock.setAvailableUnits(rs.getInt("available_units"));
			stock.setDonatedUnits(rs.getInt("donated_units"));
			stock.setTotalUnits(rs.getInt("total_units"));
			stocks.add(stock);
			
		}
		st.close();
		rs.close();
		return stocks;
	}
  public static int updateStock(int id,int units) throws SQLException{
	  Connection conn=DBConnection.getConnection();
	  String query="UPDATE blood_stock SET " 
	  		+ " available_units=available_units + ?,"
			  + " total_units=total_units +  ?" +
	  		" WHERE bloodd_type=(SELECT blood_type FROM blood_donors WHERE donor_id=?)";
	   PreparedStatement ps=conn.prepareStatement(query);
	   ps.setInt(1,units);
	   ps.setInt(2,units);
	   ps.setInt(3,id);
	   
	   return ps.executeUpdate();
	   
	   
	    
  }
}
