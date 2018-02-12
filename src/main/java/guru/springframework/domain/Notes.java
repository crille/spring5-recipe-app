package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    //Large object (Lob)
    @Lob //To allow more than 256 characters for notes, will be stored in a clob field in the db
    private String recipeNotes;
}
