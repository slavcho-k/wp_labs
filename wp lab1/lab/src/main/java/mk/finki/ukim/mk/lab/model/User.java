package mk.finki.ukim.mk.lab.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.finki.ukim.mk.lab.service.impl.PersonNameConverter;
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
    @Convert(converter = PersonNameConverter.class)
    private PersonName personName;
    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
//    @OneToMany(mappedBy = "user")
//    private List<ShoppingCart> carts;

    public User(PersonName personName, String password, LocalDate dateOfBirth) {
        this.personName = personName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
//        this.carts = new ArrayList<>();
    }
}
