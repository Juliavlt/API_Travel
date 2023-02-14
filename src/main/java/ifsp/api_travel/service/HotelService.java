package ifsp.api_travel.service;

import ifsp.api_travel.model.Hotel;
import ifsp.api_travel.model.User;
import ifsp.api_travel.model.dto.HotelRequestDTO;
import ifsp.api_travel.model.dto.HotelResponseDTO;
import ifsp.api_travel.model.dto.UserRequestDTO;
import ifsp.api_travel.model.dto.UserResponseDTO;
import ifsp.api_travel.repository.HotelRepository;
import ifsp.api_travel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository repository;

    public HotelResponseDTO create(HotelRequestDTO requestDTO) {

        Hotel hotel = Hotel.builder()
                .name(requestDTO.getName())
                .departureDate(requestDTO.getDepartureDate())
                .returnDate(requestDTO.getReturnDate())
                .location(requestDTO.getLocation())
                .dailyPrice(requestDTO.getDailyPrice())
                .rate(requestDTO.getRate())
                .build();

        repository.save(hotel);

        return HotelResponseDTO.builder().build();
    }

    public HotelResponseDTO find(HotelRequestDTO requestDTO) {

        Hotel hotel = repository.findById(requestDTO.getId()).get();

        return HotelResponseDTO.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .departureDate(hotel.getDepartureDate())
                .returnDate(hotel.getReturnDate())
                .location(hotel.getLocation())
                .dailyPrice(hotel.getDailyPrice())
                .rate(hotel.getRate())
                .build();
    }

    public HotelResponseDTO update(Long id, HotelRequestDTO requestDTO) {
        Hotel hotel = repository.findById(id).get();
        if (hotel ==null){
            return HotelResponseDTO.builder().error("Hotel não existe.").build();
        }

        repository.save(Hotel.builder()
                .name(requestDTO.getName())
                .departureDate(requestDTO.getDepartureDate())
                .returnDate(requestDTO.getReturnDate())
                .location(requestDTO.getLocation())
                .dailyPrice(requestDTO.getDailyPrice())
                .rate(requestDTO.getRate())
                .build());

        return HotelResponseDTO.builder().build();
    }

    public HotelResponseDTO delete(Long id) {
        Hotel hotel = repository.findById(id).get();
        if (!ObjectUtils.isEmpty(hotel)) {
            repository.delete(hotel);
            return HotelResponseDTO.builder().build();
        }
        return HotelResponseDTO.builder().error("Hotel não existe.").build();
    }


    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }
}