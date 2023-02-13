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
@JsonIdentityInfo(scope = Hotel.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    /*@Column(name = "images", nullable = false)
    private List<String> images;*/

    @Column(name = "location")
    private String location;

    @Column(name = "rate")
    private String rate;

    @CreatedDate
    @Column(name = "departureDate")
    private String departureDate;

    @CreatedDate
    @Column(name = "returnDate")
    private String returnDate;

    @Column(name = "dailyPrice")
    private String dailyPrice;

/*    @Column(name = "additional")
    private Map<String, String> additional;*/

}
