/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.sql.*;
/**
 *
 * @author Administrador
 */
public class User {

    private String user;
    private String password;
    private String cadenaConexionSQlServer = "jdbc:sqlserver://localhost:1433;databaseName=";
    private String userBD;
    private String passwordBD;
    private String table;
    private String userTableField;
    private String passwordTableField;
    private String database;

    public User() {
        user = "";
        password = "";
        userBD = "";
        passwordBD = "";
    }

    public User(String user, String password) {
        setUser(user);
        setPassword(password);
    }

    public boolean login()  {
        boolean loginOk = true;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con=null;
            con=DriverManager.getConnection(this.cadenaConexionSQlServer + this.getDatabase(),
                    this.userBD,this.passwordBD);

            Statement st=con.createStatement();
            String sentencia="SELECT cuenta=count(*) FROM " + this.getTable() +
                             " WHERE " + this.getUserTableField() + " = '" + this.user +
                             "' AND " + this.getPasswordTableField() + " = '" + this.password + "'";

            ResultSet rs=st.executeQuery(sentencia);

            int cuenta=0;

            while(rs.next()) {
                cuenta=rs.getInt("cuenta");
            }

            if(cuenta==0) {
                loginOk=false;
            }

            rs.close();
            st.close();
            con.close();
        } catch(ClassNotFoundException ex1) {
            ex1.printStackTrace();
            loginOk=false;
        }
        catch(SQLException ex2) {
            ex2.printStackTrace();
            loginOk=false;
        }

        return loginOk;
    }
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }    

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword(char[] password) {
        this.password = String.valueOf(password);
    }

    public String getPasswordBD() {
        return passwordBD;
    }

    public void setPasswordBD(String passwordBD) {
        this.passwordBD = passwordBD;
    }

    public String getUserBD() {
        return userBD;
    }

    public void setUserBD(String userBD) {
        this.userBD = userBD;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getPasswordTableField() {
        return passwordTableField;
    }

    public void setPasswordTableField(String passwordTableField) {
        this.passwordTableField = passwordTableField;
    }

    public String getUserTableField() {
        return userTableField;
    }

    public void setUserTableField(String userTableField) {
        this.userTableField = userTableField;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
