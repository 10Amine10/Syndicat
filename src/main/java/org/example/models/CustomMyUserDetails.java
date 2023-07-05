package org.example.models;

import org.example.entities.MyUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomMyUserDetails implements UserDetails {
    private MyUser user;
    private String role;

    public CustomMyUserDetails(MyUser user, String role) {
        this.user = user;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Retourner la liste des rôles ou autorités de l'utilisateur
        // Si votre classe MyUser a une propriété pour stocker les rôles, vous pouvez les retourner ici
        // Sinon, vous pouvez créer une classe représentant les rôles et les retourner ici
        return null;
    }

    @Override
    public String getPassword() {
        // Retourner le mot de passe de l'utilisateur
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        // Retourner le nom d'utilisateur de l'utilisateur
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Vérifier si le compte de l'utilisateur n'est pas expiré
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Vérifier si le compte de l'utilisateur n'est pas verrouillé
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Vérifier si les informations d'identification de l'utilisateur ne sont pas expirées
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Vérifier si le compte de l'utilisateur est activé
        return true;
    }
}
