package poo.dao;

import poo.model.Empleado;
import static poo.config.DatabaseConfig.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    public void insertar(Empleado empleado) {
        String sqlPersona = "INSERT INTO personas(nombre, nacionalidad, fecha_nacimiento) VALUES (?, ?, ?) RETURNING id";
        String sqlEmpleado = "INSERT INTO empleados(persona_id, sueldo, bono) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtPersona = conn.prepareStatement(sqlPersona)) {
                stmtPersona.setString(1, empleado.getNombre());
                stmtPersona.setString(2, empleado.getNacionalidad());
                stmtPersona.setDate(3, Date.valueOf(empleado.getFechaDeNacimiento()));

                ResultSet rs = stmtPersona.executeQuery();
                rs.next();
                int personaId = rs.getInt("id");

                try (PreparedStatement stmtEmpleado = conn.prepareStatement(sqlEmpleado)) {
                    stmtEmpleado.setInt(1, personaId);
                    stmtEmpleado.setBigDecimal(2, empleado.getSueldo());
                    BigDecimal bono = BigDecimal.ZERO; // Si es gerente puedes extenderlo
                    stmtEmpleado.setBigDecimal(3, bono);
                    stmtEmpleado.executeUpdate();
                }
                conn.commit();
                System.out.println("✅ Empleado insertado: " + empleado.getNombre());
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Empleado> listar() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = """
            SELECT p.id AS persona_id, p.nombre, p.nacionalidad, p.fecha_nacimiento,
                   e.sueldo, e.bono
            FROM empleados e
            JOIN personas p ON p.id = e.persona_id
            """;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Empleado empleado = new Empleado(
                        rs.getString("nombre"),
                        rs.getString("nacionalidad"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getBigDecimal("sueldo")
                );
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public Empleado buscarPorId(int id) {
        String sql = """
                SELECT p.id AS persona_id, p.nombre, p.nacionalidad,  p.fecha_nacimiento,
                    e.sueldo, e.bono
                FROM empleados e 
                JOIN personas p ON p.id = e.persona_id
                WHERE e.id = ?;    
                """;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,id);

            try (ResultSet rs = stmt.executeQuery()) {
                if(rs.next()){
                    return new Empleado(
                            rs.getString("nombre"),
                            rs.getString("nacionalidad"),
                            rs.getDate("fecha_nacimiento").toLocalDate(),
                            rs.getBigDecimal("sueldo")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarSueldo(int id, BigDecimal nuevoSueldo) {
        String sql = """
            UPDATE empleados
            SET sueldo = ?
            WHERE persona_id = ?
            """;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBigDecimal(1, nuevoSueldo);
            stmt.setInt(2, id);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Sueldo actualizado para ID " + id);
            } else {
                System.out.println("⚠️ No se encontró empleado con ID " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sqlEmpleado = "DELETE FROM empleados WHERE persona_id = ?";
        String sqlPersona = "DELETE FROM personas WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmtEmpleado = conn.prepareStatement(sqlEmpleado);
                 PreparedStatement stmtPersona = conn.prepareStatement(sqlPersona)) {

                stmtEmpleado.setInt(1, id);
                stmtEmpleado.executeUpdate();

                stmtPersona.setInt(1, id);
                int filas = stmtPersona.executeUpdate();
                conn.commit();

                if (filas > 0) {
                    System.out.println("✅ Empleado eliminado con ID " + id);
                } else {
                    System.out.println("⚠️ No se encontró persona con ID " + id);
                }
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
