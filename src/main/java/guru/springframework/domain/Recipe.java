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

    //Använd EnumType.STRING, använder du ORDINAL så kommer det inte att stämma i db om du lägger till en difficulty
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @Lob //will be stored as a binary (blob field in the database)
    private Byte[] image;

    //Cascading so that if we delete recipe, notes will also be deleted
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    //mappedBy points out the target property "recipe" on the Many class (Ingredient)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(name = "recipe_category",
        joinColumns = @JoinColumn(name = "recipe_id"),
         inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;


}
