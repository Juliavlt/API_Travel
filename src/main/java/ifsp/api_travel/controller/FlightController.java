package ifsp.api_travel.controller;

import ifsp.api_travel.model.Flight;
import ifsp.api_travel.model.dto.FlightRequestDTO;
import ifsp.api_travel.model.dto.FlightResponseDTO;
import ifsp.api_travel.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/travel")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("/flight")
    @Transactional
    public ResponseEntity<?> getFlight(@RequestBody FlightRequestDTO flightRequestDTO) {

        FlightResponseDTO response = flightService.get(flightRequestDTO);
        if (response.getError()==null){
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response.getError());
    }

    @PostMapping("/flight")
    @Transactional
    public ResponseEntity<?> createFlight(
            @RequestBody FlightRequestDTO flightRequestDTO) {

        FlightResponseDTO flight = flightService.create(flightRequestDTO);

        if(flight.getError()==null){
            return ResponseEntity.ok(String.valueOf(flight.getId()));
        }
        return ResponseEntity.badRequest().body(flight.getError());
    }

    @DeleteMapping("/flight")
    @Transactional
    public ResponseEntity deleteFlight(@RequestBody FlightRequestDTO request) {
        FlightResponseDTO flightResponseDTO = flightService.delete(request.getName());
        if(flightResponseDTO.getError()==null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body(flightResponseDTO.getError());
    }

    @GetMapping("/flights")
    @Transactional
    public ResponseEntity<List<Flight>> getFlights(){
        List<Flight> response = flightService.getAllFlights();
        return ResponseEntity.ok(response);
    }
}
