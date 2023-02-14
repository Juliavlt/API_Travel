package ifsp.api_travel.service;

import ifsp.api_travel.model.User;
import ifsp.api_travel.model.dto.UserRequestDTO;
import ifsp.api_travel.model.dto.UserResponseDTO;
import ifsp.api_travel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.List;

import static ifsp.api_travel.model.Constants.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserResponseDTO create(UserRequestDTO requestDTO) {

        if (!ObjectUtils.isEmpty(repository.findByUsername(requestDTO.getUsername()))) {
            return UserResponseDTO.builder().error("Usuário já cadastrado.").build();
        }

        User user = User.builder()
                .username(requestDTO.getUsername())
                .password(requestDTO.getPassword())
                .name(requestDTO.getName())
                .email(requestDTO.getEmail())
                .phone(requestDTO.getPhone())
                .profileType(getProfileType(requestDTO.getUsername()))
                .build();

        repository.save(user);

        return UserResponseDTO.builder().build();
    }

    public UserResponseDTO update(Long id, UserRequestDTO requestDTO) {
        User user = repository.findById(id).get();
        if (user ==null){
            return UserResponseDTO.builder().error("Usuário não existe.").build();
        }

        repository.save(User.builder()
                .id(user.getId())
                .username(requestDTO.getUsername())
                .name(requestDTO.getUsername())
                .password(requestDTO.getPassword())
                .phone(requestDTO.getPhone())
                .email(requestDTO.getEmail())
                .build());

        return UserResponseDTO.builder().build();
    }

    public UserResponseDTO delete(String username) {
        User user = repository.findByUsername(username);
        if (!ObjectUtils.isEmpty(user)) {
            repository.delete(user);
            return UserResponseDTO.builder().build();
        }
        return UserResponseDTO.builder().error("Usuário não existe.").build();
    }

    public UserResponseDTO authenticate(UserRequestDTO request) {
        User user = repository.findByUsername(request.getUsername());
        if (!ObjectUtils.isEmpty(user) && user.getPassword().equals(request.getPassword())) {
            return UserResponseDTO.builder()
                    .username(user.getUsername())
                    .name(user.getName())
                    .profileType(user.getProfileType())
                    .build();
        }
        if (!ObjectUtils.isEmpty(user) &&
                    !user.getPassword().equals(request.getPassword())) {
                return UserResponseDTO.builder().error("Dados incorretos!").build();
            }

        return UserResponseDTO.builder().error("Usuário não existe.").build();
    }

    private String getProfileType(String username) {
        if (username.length() == SIZE_CPF){
            return CPF;
        } else
            return CNPJ;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}