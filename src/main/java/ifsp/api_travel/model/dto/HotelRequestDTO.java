package ifsp.api_travel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelRequestDTO implements Serializable {

    private Long id;

    private String name;

    /*private List<String> images;*/

    private String location;

    private String rate;

    private String departureDate;

    private String returnDate;

    private String dailyPrice;

    /* private Map<String, String> additional;*/
}
