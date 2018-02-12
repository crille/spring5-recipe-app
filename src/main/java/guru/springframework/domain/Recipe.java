package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer serving;
    private String source;
    private String url;
    private String directions;
    //todo add
    //private Difficulty difficulty

    @Lob //will be stored as a binary (blob field in the database)
    private Byte[] image;

    //Cascading so that if we delete recipe, notes will also be deleted
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    //mappedBy points out the target property "recipe" on the Many class (Ingredient)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;


}
