package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;


}
