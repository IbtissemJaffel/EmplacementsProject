CREATE DATABASE Emplacements;
USE Emplacements;
CREATE TABLE Emplacements (
    idEmplacement INT PRIMARY KEY AUTO_INCREMENT,
    nomEmplacement VARCHAR(50) NOT NULL,
    descriptionEmplacement VARCHAR(255)
);
INSERT INTO Emplacements (nomEmplacement, descriptionEmplacement)
VALUES 
('Bibliothèque', 'Étagère principale pour livres'),
('Boîte à timbres', 'Boîte en bois pour timbres rares'),
('Album de cartes', 'Album pour cartes postales anciennes'),
('Vitrine', 'Vitrine en verre pour pièces de monnaie');
SHOW TABLES;
SELECT * FROM Emplacements;
