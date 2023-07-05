package org.example.services;
import org.example.entities.MyUser;
import org.example.models.CustomMyUserDetails;
import org.example.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.*;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository) throws SQLException {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        MyUser myUser = userRepository.findByUsername(username);
        if (myUser == null) {
            throw new UsernameNotFoundException("Utilisateur introuvable :" + username);
        }
        String role = retrieveUserRoleFromDatabase(myUser);
        if (role == null) {
            throw new IllegalStateException("Role non defini pour l'utilisateur");
        }
        return new CustomMyUserDetails(myUser, role);
    }

    private String retrieveUserRoleFromDatabase(MyUser user) {
        String role = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Touzani1998@@")) {
            PreparedStatement statement = connection.prepareStatement("SELECT role FROM roles WHERE user_id = ?");
            statement.setLong(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                role = resultSet.getString("role");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }
}
