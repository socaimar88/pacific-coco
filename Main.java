import java.sql.*;
public class Main {
    public static void main(String[] args) {
        String usuario = "root";
        String password = "M@riaclara62";
        String url = "jdbc:mysql://localhost:3306/pacific";
        Connection conexion;
        Statement statement;
        ResultSet rs;



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO CLIENTE(CEDULA,NOMBRES,APELLIDOS) VALUES('1113','JHON','PARRA')");
            rs = statement.executeQuery("SELECT * FROM CLIENTE");
            rs.next();
            do{
                System.out.println(rs.getString("cedula")+" : "+rs.getString("nombres")+" : "+rs.getString("apellidos"));
            }while(rs.next());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}