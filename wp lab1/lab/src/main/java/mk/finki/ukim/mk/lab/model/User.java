package mk.finki.ukim.mk.lab.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String surname;
    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
//    @OneToMany(mappedBy = "user")
//    private List<ShoppingCart> carts;

    public User(String username, String surname, String password, LocalDate dateOfBirth) {
        this.username = username;
        this.surname = surname;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
//        this.carts = new ArrayList<>();
    }
}
