package com.emplacements.projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmplacementManager {

    // URL de connexion à la base de données MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/Emplacements";
    private static final String USER = "root";  // Votre nom d'utilisateur MySQL
    private static final String PASSWORD = "";  // Votre mot de passe MySQL (laisser vide si aucun)

    public static void main(String[] args) {
        try {
            // Connexion à la base de données
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Affichage des emplacements existants dans la base de données
            System.out.println("Liste des emplacements :");
            displayEmplacements(connection);

            // Ajouter un nouvel emplacement
            System.out.println("\nAjout d'un nouvel emplacement...");
            addEmplacement(connection, "Nouvelle Vitrine", "Vitrine pour pièces anciennes");

            // Afficher les emplacements après l'ajout
            System.out.println("\nListe des emplacements après ajout :");
            displayEmplacements(connection);

            // Fermer la connexion
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour afficher tous les emplacements dans la table "Emplacements"
    private static void displayEmplacements(Connection connection) throws SQLException {
        String query = "SELECT * FROM Emplacements";
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int idEmplacement = rs.getInt("idEmplacement");
            String nomEmplacement = rs.getString("nomEmplacement");
            String descriptionEmplacement = rs.getString("descriptionEmplacement");

            System.out.println("ID: " + idEmplacement + ", Nom: " + nomEmplacement + ", Description: " + descriptionEmplacement);
        }
    }

    // Méthode pour ajouter un emplacement à la base de données
    private static void addEmplacement(Connection connection, String nom, String description) throws SQLException {
        String query = "INSERT INTO Emplacements (nomEmplacement, descriptionEmplacement) VALUES (?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, nom);
        stmt.setString(2, description);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Emplacement ajouté avec succès !");
        }
    }

    // Méthode pour supprimer un emplacement (par exemple, en fonction de son ID)
    private static void deleteEmplacement(Connection connection, int idEmplacement) throws SQLException {
        String query = "DELETE FROM Emplacements WHERE idEmplacement = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, idEmplacement);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Emplacement supprimé avec succès !");
        }
    }
}
