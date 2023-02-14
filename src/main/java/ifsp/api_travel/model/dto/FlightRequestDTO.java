package ifsp.api_travel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /*private List<String> images;*/

    private Long id;

    private String name;

    private String departureDate;

    private String returnDate;

    private String origin;

    private String destiny;

    private Long price;

    private Integer vacancies;

    private String classType;

    private String airline;

/*  private List<AdditionalInfo> additional;*/
}
