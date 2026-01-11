package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale de l'application Spring Boot.
 * Cette classe sert de point d'entrée pour le démarrage de l'application.
 * L'annotation @SpringBootApplication active la configuration automatique,
 * le scan des composants et la configuration des beans Spring.
 */
@SpringBootApplication
public class DemoApplication {
    
    /**
     * Méthode principale qui lance l'application Spring Boot.
     * 
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        // Démarrage de l'application Spring Boot
        SpringApplication.run(DemoApplication.class, args);
    }
}