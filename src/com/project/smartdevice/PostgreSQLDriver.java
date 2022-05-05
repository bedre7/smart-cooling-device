package com.project.smartdevice;

import com.project.smartdevice.utilities.Icons;

import java.sql.*;

public class PostgreSQLDriver implements IDatabaseMS {

    @Override
    public Connection connect() {
        Connection con=null;

        final String db_NAME="smart-cooling-device";
        final String db_USER="postgres";
        final int db_PORT=5432;
        final String db_PASSWORD="1321";
        final String db_URLJDBC="jdbc:postgresql://localhost:"+db_PORT+"/"+db_NAME;

        try{
            con= DriverManager.getConnection(db_URLJDBC,db_USER,db_PASSWORD);
            if(con!=null)
                System.out.println("Connected successfully... "+ Icons.SUCCESS);
            else
                System.out.println("Connection error " + Icons.ERROR);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    @Override
    public boolean searchUser(String username) {
        System.out.println(Icons.LOADING + " Searching user...");

        boolean isUser = false;

        String sql = "SELECT * FROM \"User\" WHERE username =" + username ;

        Connection conn = this.connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();

            isUser =rs.next();

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isUser;
    }

    @Override
    public User authenticateUser(String username, String password) {
        User user = null;

        System.out.println(Icons.LOADING+" Authenticating user...");

        if(searchUser(username)){

            String sql = "SELECT *  FROM \"User\" WHERE \"username\"="+username+" AND \"password\"=" + password;

            Connection conn = this.connect();
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                conn.close();

                while (rs.next()) {
                    username = rs.getString("username");
                    password = rs.getString("password");

                    user = new User.Builder(username, password)
                            .build();

                    System.out.println(user+ "has been authenticated ");
                }
                rs.close();
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return user;
    }
}
