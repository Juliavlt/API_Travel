package ifsp.api_travel.controller;

import ifsp.api_travel.model.Hotel;
import ifsp.api_travel.model.dto.HotelRequestDTO;
import ifsp.api_travel.model.dto.HotelResponseDTO;
import ifsp.api_travel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/travel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("/hotel")
    @Transactional
    public ResponseEntity<?> getHotel(@RequestBody HotelRequestDTO hotelRequestDTO) {

        HotelResponseDTO response = hotelService.find(hotelRequestDTO);
        if (response.getError()==null){
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response.getError());
    }

    @PostMapping("/hotel")
    @Transactional
    public ResponseEntity<?> createHotel(
            @RequestBody HotelRequestDTO hotelRequestDTO) {

        HotelResponseDTO hotel = hotelService.create(hotelRequestDTO);

        if(hotel.getError()==null){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body(hotel.getError());
    }

    @DeleteMapping("/hotel")
    @Transactional
    public ResponseEntity deleteHotel(@RequestBody HotelRequestDTO request) {
        HotelResponseDTO hotelResponseDTO = hotelService.delete(request.getId());
        if(hotelResponseDTO.getError()==null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body(hotelResponseDTO.getError());
    }

    @GetMapping("/hotels")
    @Transactional
    public ResponseEntity<List<Hotel>> getHotels(){
        List<Hotel> response = hotelService.getAllHotels();
        return ResponseEntity.ok(response);
    }
}
