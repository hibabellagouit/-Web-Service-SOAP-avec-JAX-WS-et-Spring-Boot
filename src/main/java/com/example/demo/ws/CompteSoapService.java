package com.example.demo.ws;

import com.example.demo.entities.Compte;
import com.example.demo.entities.TypeCompte;
import com.example.demo.repositories.CompteRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Service web SOAP pour la gestion des comptes bancaires.
 * Ce service expose des opérations CRUD sur les comptes via des appels SOAP.
 * 
 * L'annotation @WebService indique que cette classe est un service web SOAP.
 * L'annotation @Component permet à Spring de détecter cette classe comme un bean géré.
 */
@Component
@WebService(
    serviceName = "BanqueWSService",
    portName = "BanqueWSPort",
    targetNamespace = "http://ws.demo.example.com/"
)
public class CompteSoapService {

    @Autowired
    private CompteRepository compteRepository;

    /**
     * Récupère la liste de tous les comptes bancaires.
     * 
     * @return Une liste contenant tous les comptes existants
     */
    @WebMethod(operationName = "getComptes")
    public List<Compte> getComptes() {
        return compteRepository.findAll();
    }

    /**
     * Récupère un compte bancaire par son identifiant.
     * 
     * @param id L'identifiant du compte à récupérer
     * @return Le compte correspondant à l'identifiant, ou null si non trouvé
     */
    @WebMethod(operationName = "getCompte")
    public Compte getCompte(@WebParam(name = "id") Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    /**
     * Crée un nouveau compte bancaire avec le solde et le type spécifiés.
     * 
     * @param solde Le solde initial du compte
     * @param type Le type de compte (COURANT ou EPARGNE)
     * @return Le compte créé avec son identifiant généré
     */
    @WebMethod(operationName = "createCompte")
    public Compte createCompte(
            @WebParam(name = "solde") double solde,
            @WebParam(name = "type") TypeCompte type) {
        // Création d'un nouveau compte avec la date courante
        Compte compte = new Compte(null, solde, new Date(), type);
        // Sauvegarde du compte en base de données
        return compteRepository.save(compte);
    }

    /**
     * Supprime un compte bancaire par son identifiant.
     * 
     * @param id L'identifiant du compte à supprimer
     * @return true si le compte a été supprimé avec succès, false si le compte n'existe pas
     */
    @WebMethod(operationName = "deleteCompte")
    public boolean deleteCompte(@WebParam(name = "id") Long id) {
        // Vérifie si le compte existe avant de tenter de le supprimer
        if (compteRepository.existsById(id)) {
            compteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}