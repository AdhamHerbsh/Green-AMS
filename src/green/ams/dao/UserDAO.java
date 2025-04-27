package green.ams.dao;

import green.ams.APP;
import green.ams.GLOBAL;
import green.ams.models.User;
import green.ams.services.dbhelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adham
 */
public class UserDAO extends DAO {

    private dbhelper db;
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    private User user;
    private List<User> users_list;
    
    
    public UserDAO() {
        this.db = new dbhelper();
        try {
            this.conn = db.getConnection();
            if (conn == null) {
                System.out.println("Error: Database connection is null.");
            }
        } catch (Exception e) {
            System.out.println("Error initializing database connection: " + e.getMessage());
        }
    }

        public boolean addUser(User user) {
        if (user == null) {
            System.out.println("Error: User object is null.");
            return false;
        }

        boolean success = false;
        String sql = "INSERT INTO users (FullName, Email, Address, PhoneNumber, Role, Password, CreatedDate) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            pst = conn.prepareStatement(sql);

            pst.setString(1, user.getFull_name());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getAddress());
            pst.setString(4, user.getPhone_number());
            pst.setString(5, "User Public");
            pst.setString(6, user.getPassword());
            pst.setDate(7, new java.sql.Date(new java.util.Date().getTime()));

            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User inserted successfully!");
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    GLOBAL.user_id = rs.getInt(1);
                    success = true;
                } else {
                    throw new SQLException("Creating area failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error inserting user: " + e.getMessage());
        } finally {
            closeResources(pst, null, null);
        }

        return success;
    }
    
    public int getUserId() {
        int id = 0;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT MAX(ID) FROM users");
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        } finally {
            closeResources(null, st, rs);
        }
        return id;
    }

    public User getUser(int id) {
        if (id <= 0) {
            System.out.println("Error: User Id is empty");
        }

        try {
            String sql = "SELECT ID, FullName, Email, Address, PhoneNumber, Role, Password, Score, CreatedDate FROM users WHERE ID = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();

            if (rs.next()) {

                user = new User();

                user.setId(rs.getInt("ID"));
                user.setFull_name(rs.getString("FullName"));
                user.setEmail(rs.getString("Email"));
                user.setAddress(rs.getString("Address"));
                user.setPhone_number(rs.getString("PhoneNumber"));
                user.setRole(rs.getString("Role"));
                user.setPassword(rs.getString("Password"));
                user.setScore(rs.getInt("Score"));
                user.setCreated_date(rs.getDate("CreatedDate"));
            } else {
                System.out.println("No user found for this id");
            }
        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        } finally {
            closeResources(pst, null, rs);
        }
        return user;
    }

    public boolean checkUser(User user) {
        if (user == null || user.getEmail() == null || user.getPassword() == null) {
            System.out.println("Error: User or credentials are null");
            return false;
        }

        String username = user.getEmail();
        String password = user.getPassword();
        boolean found = false;

        try {
            String sql = "SELECT ID, Email, Password, Role FROM users WHERE Email = ? AND Password = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);

            rs = pst.executeQuery();

            if (rs.next()) {

                String username_db = rs.getString("Email");
                String password_db = rs.getString("Password");

                if (username.equals(username_db) && password.equals(password_db)) {
                    System.out.println("User found");
                    found = true;
                    GLOBAL.user_id = rs.getInt("ID");

                } else {
                    System.out.println("User not found");
                    printUserModel(user);
                }
            } else {
                System.out.println("No user found for these credentials");
            }
        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        } finally {
            closeResources(pst, null, rs);
        }
        return found;
    }

    public void getUsers() {
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.print(rs.getString(1));
                System.out.println(" -- " + rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        } finally {
            closeResources(null, st, rs);
        }
    }

    public List<User> getUsersList() {
        
        users_list = new ArrayList<>();
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()) {
        
                user = new User();
                user.setFull_name(rs.getString("FullName"));
                user.setEmail(rs.getString("Email"));
                user.setPhone_number(rs.getString("PhoneNumber"));
                user.setAddress(rs.getString("Address"));
                user.setRole(rs.getString("Role"));
                user.setCreated_date(rs.getDate("CreatedDate"));
                
                users_list.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        } finally {
            closeResources(null, st, rs);
        }
        
        
        return users_list;
    }

    public boolean updateUser(User user) {

        String sql = "UPDATE users SET FullName = ?, Address = ?, PhoneNumber = ?, Password = ? WHERE ID = ?";

        boolean success = false;
        
        User old_user = getUser(user.getId());
        
        try (PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, user.getFull_name());
            pst.setString(2, user.getAddress());
            pst.setString(3, user.getPhone_number());
            pst.setString(4, user.getPassword().equals("") ? old_user.getPassword() : user.getPassword());
            pst.setInt(5, user.getId());

            int affectedRows = pst.executeUpdate();
            if (affectedRows <= 0) {
                System.out.println("No user found with ID: " + user.getId());
            } else {
                success = true;
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } finally {
            closeResources(pst, null, null);

        }
        return success;
    }

    public void printUserModel(User user) {
        if (user == null) {
            System.out.println("User is null");
            return;
        }

        System.out.println(user.getId());
        System.out.println(user.getFull_name());
        System.out.println(user.getEmail());
        System.out.println(user.getPhone_number());
        System.out.println(user.getAddress());
        System.out.println(user.getPassword());
        System.out.println(user.getRole());
        System.out.println(user.getCreated_date());
    }
}
