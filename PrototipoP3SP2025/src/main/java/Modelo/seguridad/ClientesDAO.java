/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.seguridad;

import Controlador.seguridad.Clientes; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import Modelo.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class ClientesDAO {

    private static final String SQL_SELECT = "SELECT codigo_clientes, nombre_clientes, estatus_clientes FROM clientes";
    private static final String SQL_INSERT = "INSERT INTO clientes(codigo_clientes, nombre_clientes, estatus_clientes) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE clientes SET nombre_clientes=?, estatus_clientes=? WHERE codigo_clientes = ?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE codigo_clientes=?";
    private static final String SQL_QUERY = "SELECT codigo_clientes, nombre_clientes, estatus_clientes FROM clientes WHERE codigo_clientes = ?";

    public List<Clientes> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clientes cliente = null;
        List<Clientes> clientes = new ArrayList<Clientes>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigoCliente = rs.getString("codigo_clientes");
                String nombreClientes = rs.getString("nombre_clientes");
                String estatusClientes = rs.getString("estatus_clientes");
                
                cliente = new Clientes();
                cliente.setCodigo_clientes(codigoCliente);
                cliente.setNombre_clientes(nombreClientes);
                cliente.setEstatus_clientes(estatusClientes);
                
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return clientes;
    }

    public int insert(Clientes cliente) { 
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getCodigo_clientes());
            stmt.setString(2, cliente.getNombre_clientes());
            stmt.setString(3, cliente.getEstatus_clientes());

            System.out.println("ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Clientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, cliente.getNombre_clientes());
            stmt.setString(2, cliente.getEstatus_clientes());
            stmt.setString(3, cliente.getCodigo_clientes());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Clientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, cliente.getCodigo_clientes());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Clientes query(Clientes cliente) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Clientes> clientes = new ArrayList<Clientes>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, cliente.getCodigo_clientes());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigoCliente = rs.getString("codigo_clientes");
                String nombreClientes = rs.getString("nombre_clientes");
                String estatusClientes = rs.getString("estatus_clientes");
                
                cliente = new Clientes();
                cliente.setCodigo_clientes(codigoCliente);
                cliente.setNombre_clientes(nombreClientes);
                cliente.setEstatus_clientes(estatusClientes);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cliente; 
    }
        
}
