package ifsp.api_travel.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(scope = Flight.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "Flight")
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*@OneToMany(targetEntity = String.class, cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH}, orphanRemoval=true)
    @JoinColumn(name = "images_fk", referencedColumnName = "id")
    private List<String> images;*/

    @Column(name = "name")
    private String name;

    @Column(name = "airline")
    private String airline;

    @CreatedDate
    @Column(name = "departureDate")
    private String departureDate;

    @CreatedDate
    @Column(name = "returnDate")
    private String returnDate;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destiny")
    private String destiny;

    @Column(name = "price")
    private Long price;

    @Column(name = "vacancies")
    private Integer vacancies;

    @Column(name = "classType")
    private String classType;


/*    @OneToMany(targetEntity = AdditionalInfo.class, cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH}, orphanRemoval=true)
    @JoinColumn(name = "additionalInfo_fk", referencedColumnName = "id")
    private List<AdditionalInfo> additional;*/

}
