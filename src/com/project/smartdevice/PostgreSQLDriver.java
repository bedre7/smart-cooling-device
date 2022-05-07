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
            Tools.delay(1500);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public void connectionControl(){

        Connection con = this.connect();
        System.out.println(Icons.LOADING+" Connecting to Database...");
        Tools.delay();

        if(con!=null){
            System.out.println("Connected to Database successfully... "+ Icons.SUCCESS+"\n");
        }
        else{
            System.out.println("Database connection error " + Icons.ERROR+"\n");
            System.exit(0);
        }
    }
    @Override
    public boolean searchUser(String username) {
        Connection conn = this.connect();

        System.out.println(Icons.LOADING + " Searching user...");
        Tools.delay(800);
        boolean isUser = false;

        String sql = "SELECT * FROM \"User\" WHERE username =\'" + username+"\'" ;

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

        Connection conn = this.connect();

        System.out.println(Icons.LOADING+" Authenticating user...");
        Tools.delay(1200);


        String sql = "SELECT *  FROM \"User\" WHERE \"username\"=\'"+username+"\' AND \"password\"=\'" + password+"\'";

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

        return user;
    }
}
