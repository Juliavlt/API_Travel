package ifsp.api_travel.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(scope = Package.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "package")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "mainImage", nullable = false)
    private String mainImage;

    /*@OneToMany(targetEntity = String.class, cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH}, orphanRemoval=true)
    @JoinColumn(name = "images_fk", referencedColumnName = "id")
    private List<String> images;*/

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

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price")
    private String price;

/*    @OneToMany(targetEntity = Hotel.class, cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH}, orphanRemoval=true)
    @JoinColumn(name = "hotel_fk", referencedColumnName = "id")
    private Hotel hotel;*/

    /*@OneToMany(targetEntity = Flight.class, cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH}, orphanRemoval=true)
    @JoinColumn(name = "flight_fk", referencedColumnName = "id")
    private Flight flight;*/

/*    @Column(name = "packageType")
    private Map<String, Double> packageType;*/

}
