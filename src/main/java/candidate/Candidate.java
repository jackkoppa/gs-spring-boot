package candidate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
@Data
public class Candidate {

    public Candidate(String name, String owner, Number value, String makeModel) {
        this.name = name;
        this.owner = owner;
        this.value = value;
        this.makeModel = makeModel;
    }

    public Candidate() { 
        this.name = "";
        this.owner = "";
        this.value = 0;
        this.makeModel = "";
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(required=false, hidden=true, notes = "Id generated during creation")
    private Long id;

    private final String name;

    private String owner;

    private Number value;

    private String makeModel;
}