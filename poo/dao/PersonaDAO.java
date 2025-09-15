package poo.dao;
import static poo.config.DatabaseConfig.*;
import poo.model.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    public void insertar(Persona persona) {
        String sql = "INSERT INTO personas(nombre, nacionalidad, fecha_nacimiento) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getNacionalidad());
            stmt.setDate(3, Date.valueOf(persona.getFechaDeNacimiento()));
            stmt.executeUpdate();
            System.out.println("✅ Persona insertada: " + persona.getNombre());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Persona> listar() {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT id, nombre, nacionalidad, fecha_nacimiento FROM personas";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                personas.add(new Persona(
                        rs.getString("nombre"),
                        rs.getString("nacionalidad"),
                        rs.getDate("fecha_nacimiento").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;


    }
}
