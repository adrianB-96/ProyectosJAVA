/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PassReset;
import java.sql.*;
import java.util.*;
/**
 *
 * @author justh
 */
public class resetPwdAppDAOImplementation implements resetPwdAppDAO, AutoCloseable{

    static{
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver cargado con exito");
        }catch(Exception ex){
            System.out.println(ex.getClass() + " " + ex.getMessage());
        }
    }
    
    String usuario = "root";

    Connection con = null;
    
    
    
    public resetPwdAppDAOImplementation(String url) throws Exception{
        String passPrimaria = System.getenv("DB_PASS_PRIMARY");
        String passSecundaria = System.getenv("DB_PASS_FALLBACK");
        
        if(passPrimaria==null || passSecundaria==null){
            throw new Exception("Fallo con las variables de entorno, no estan definidas.");
        }
        
        try {
            con = DriverManager.getConnection(url, usuario, passPrimaria);
            System.out.println("Conexión exitosa con la contraseña primaria.");
        } catch (SQLException e) {
            System.out.println("Fallo con contraseña primaria. Intentando con la secundaria...");
            try {
                con = DriverManager.getConnection(url, usuario, passSecundaria);
                System.out.println("Conexión exitosa con la contraseña secundaria.");
            } catch (SQLException e2) {
                System.err.println("Fallo crítico: Ninguna contraseña funcionó.");
                throw new Exception("No se pudo conectar a la BD. Primer Intento: " + e.getMessage() + " || Segundo intento: " + e2.getMessage(), e2);
            }
        }
    }
    
    @Override
    public String getPwdUser(String username) throws Exception {
        String resultado = "";
        String sql = "SELECT login_pwd FROM auth_user WHERE username = ?";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, username);
            
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    resultado = rs.getString("login_pwd");
                }
            }
        }
        if("".equalsIgnoreCase(resultado)){
            resultado = "El usuario no existe o la consulta ha fallado.";
        }
        
        return resultado;
    }

    @Override
    public int setPwdUser(String username) throws Exception {
        int resultado = 0;
        String sql = "UPDATE auth_user SET login_pwd = 'e64b78fc3bc91bcbc7dc232ba8ec59e0' WHERE username = ?";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, username);
            
            resultado = ps.executeUpdate();
        }
        return resultado;
    }

    @Override
    public String getSuperuser(String username) throws Exception {
        String resultado = "";
        String sql = "SELECT is_superuser FROM auth_user WHERE username = ?";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, username);
            
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    resultado = rs.getString("is_superuser");
                    if("t".equals(resultado)){
                        resultado="Sí es superAdmin";
                    }else if("f".equals(resultado)){
                        resultado="No es superAdmin";
                    }
                }
            }
        }
        return resultado;
    }
    
    @Override
    public List<Dispositivos> getDevices() throws Exception {
        List<Dispositivos> listaDevices = new ArrayList<Dispositivos>();
        
        String sql = "SELECT device_name, enabled, fw_version, comm_type, ip_address, gateway, subnet_mask, ip_port, sn, id FROM acc_device";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Dispositivos devices = new Dispositivos(rs.getString("device_name"), rs.getBoolean("enabled"), rs.getString("fw_version"), rs.getInt("comm_type"), rs.getString("ip_address"), rs.getString("gateway"), rs.getString("subnet_mask"), rs.getString("ip_port"), rs.getString("sn"), rs.getString("id"));
                    listaDevices.add(devices);
                }
            }
        }
        
        return listaDevices;
    }
    
    @Override
    public void updateDeviceEnabled(String id, boolean estado) throws SQLException {
        String sql = "UPDATE acc_device SET enabled = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, estado);
            ps.setString(2, id);
            ps.executeUpdate();
        }
        String sql2 = "UPDATE acc_door SET enabled = ? WHERE dev_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql2)) {
            ps.setBoolean(1, estado);
            ps.setString(2, id);
            ps.executeUpdate();
        }
    }
    
    @Override
    public String updateAppEmpleados() throws SQLException {
        String respuesta;
        String sql = "UPDATE pers_person SET app_authorization = FALSE";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
            respuesta = "Se ha actualizado a " + ps.executeUpdate() + " personas.";
        }
        return respuesta;
    }

    @Override
    public void close() throws Exception {
        con.close();
    }    
}
