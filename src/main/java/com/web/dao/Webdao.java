package com.web.dao;

import com.web.model.Products;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAOImpl implements ProductsDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; 
    private String jdbcUsername = "your_username"; 
    private String jdbcPassword = "your_password"; 

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    @Override
    public void addProduct(Products product) {
        String sql = "INSERT INTO products (name, description, price, categoryId, imageUrl, stockQuantity) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getCategoryId());
            statement.setString(5, product.getImageUrl());
            statement.setInt(6, product.getStockQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Products getProductById(int productId) {
        Products product = null;
        String sql = "SELECT * FROM products WHERE productId = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                product = new Products();
                product.setProductId(resultSet.getInt("productId"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("price"));
                product.setCategoryId(resultSet.getInt("categoryId"));
                product.setImageUrl(resultSet.getString("imageUrl"));
                product.setStockQuantity(resultSet.getInt("stockQuantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Products> getAllProducts() {
        List<Products> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Products product = new Products();
                product.setProductId(resultSet.getInt("productId"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("price"));
                product.setCategoryId(resultSet.getInt("categoryId"));
                product.setImageUrl(resultSet.getString("imageUrl"));
                product.setStockQuantity(resultSet.getInt("stockQuantity"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void updateProduct(Products product) {
        String sql = "UPDATE products SET name = ?, description = ?, price = ?, categoryId = ?, imageUrl = ?, stockQuantity = ? WHERE productId = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getCategoryId());
            statement.setString(5, product.getImageUrl());
            statement.setInt(6, product.getStockQuantity());
            statement.setInt(7, product.getProductId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int productId) {
        String sql = "DELETE FROM products WHERE productId = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, productId);
            statement.executeUpdate();
        ```java
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
package com.web.dao;

import com.web.model.Users;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAOImpl implements UsersDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; 
    private String jdbcUsername = "your_username"; 
    private String jdbcPassword = "your_password"; 

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    @Override
    public void addUser (Users user) {
        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Users getUser ById(int userId) {
        Users user = null;
        String sql = "SELECT * FROM users WHERE userId = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new Users();
                user.setUser Id(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Users user = new Users();
                user.setUser Id(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUser (Users user) {
        String sql = "UPDATE users SET username = ?, password = ?, email = ? WHERE userId = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getUser Id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser (int userId) {
        String sql = "DELETE FROM users WHERE userId = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
package com.web.dao;

import com.web.model.OrderItems;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsDAOImpl implements OrderItemsDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/your_database "; 
    private String jdbcUsername = "your_username"; 
    private String jdbcPassword = "your_password"; 

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    @Override
    public void addOrderItem(OrderItems orderItem) {
        String sql = "INSERT INTO order_items (orderId, productId, quantity) VALUES (?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderItem.getOrderId());
            statement.setInt(2, orderItem.getProductId());
            statement.setInt(3, orderItem.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderItems getOrderItemById(int orderItemId) {
        OrderItems orderItem = null;
        String sql = "SELECT * FROM order_items WHERE orderItemId = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderItemId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                orderItem = new OrderItems();
                orderItem.setOrderItemId(resultSet.getInt("orderItemId"));
                orderItem.setOrderId(resultSet.getInt("orderId"));
                orderItem.setProductId(resultSet.getInt("productId"));
                orderItem.setQuantity(resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItem;
    }

    @Override
    public List<OrderItems> getAllOrderItems() {
        List<OrderItems> orderItems = new ArrayList<>();
        String sql = "SELECT * FROM order_items";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                OrderItems orderItem = new OrderItems();
                orderItem.setOrderItemId(resultSet.getInt("orderItemId"));
                orderItem.setOrderId(resultSet.getInt("orderId"));
                orderItem.setProductId(resultSet.getInt("productId"));
                orderItem.setQuantity(resultSet.getInt("quantity"));
                orderItems.add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItems;
    }

    @Override
    public void updateOrderItem(OrderItems orderItem) {
        String sql = "UPDATE order_items SET orderId = ?, productId = ?, quantity = ? WHERE orderItemId = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderItem.getOrderId());
            statement.setInt(2, orderItem.getProductId());
            statement.setInt(3, orderItem.getQuantity());
            statement.setInt(4, orderItem.getOrderItemId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItem(int orderItemId) {
        String sql = "DELETE FROM order_items WHERE orderItemId = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderItemId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
package com.web.dao;

import com.web.model.Categories;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAOImpl implements CategoriesDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; 
    private String jdbcUsername = "your_username"; 
    private String jdbcPassword = "your_password"; 

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    @Override
    public void addCategory(Categories category) {
        String sql = "INSERT INTO categories (name, description) VALUES (?, ?)";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, category.getName ());
            statement.setString(2, category.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Categories getCategoryById(int categoryId) {
        Categories category = null;
        String sql = "SELECT * FROM categories WHERE categoryId = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                category = new Categories();
                category.setCategoryId(resultSet.getInt("categoryId"));
                category.setName(resultSet.getString("name"));
                category.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Categories> getAllCategories() {
        List<Categories> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Categories category = new Categories();
                category.setCategoryId(resultSet.getInt("categoryId"));
                category.setName(resultSet.getString("name"));
                category.setDescription(resultSet.getString("description"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public void updateCategory(Categories category) {
        String sql = "UPDATE categories SET name = ?, description = ? WHERE categoryId = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, category.getName());
            statement.setString(2, category.getDescription());
            statement.setInt(3, category.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(int categoryId) {
        String sql = "DELETE FROM categories WHERE categoryId = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, categoryId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}