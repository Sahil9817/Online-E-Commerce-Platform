package com.ecommerce.dao;

import com.ecommerce.model.ShippingAddress;
import com.ecommerce.utils.DatabaseConnection;

import java.sql.*;

public class ShippingDAO {

	// Add a new shipping address
	public void addShippingAddress(int userId, String addressLine1, String addressLine2, String city, String state,
			String zipCode, String country) {
		String query = "INSERT INTO shipping_addresses (user_id, address_line1, address_line2, city, state, zip_code, country) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, userId);
			stmt.setString(2, addressLine1);
			stmt.setString(3, addressLine2);
			stmt.setString(4, city);
			stmt.setString(5, state);
			stmt.setString(6, zipCode);
			stmt.setString(7, country);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Get shipping address by user ID
	public ShippingAddress getShippingAddress(int userId) {
		String query = "SELECT * FROM shipping_addresses WHERE user_id = ?";
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new ShippingAddress(rs.getInt("id"), rs.getInt("user_id"), rs.getString("address_line1"),
						rs.getString("address_line2"), rs.getString("city"), rs.getString("state"),
						rs.getString("zip_code"), rs.getString("country"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
