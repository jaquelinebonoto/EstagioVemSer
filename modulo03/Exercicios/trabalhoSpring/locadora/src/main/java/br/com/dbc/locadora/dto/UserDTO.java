
package br.com.dbc.locadora.dto;

import br.com.dbc.locadora.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Windows
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String password;
    
    
    public User DtotoUser (UserDTO dto){
            return User.builder()
                    .username(dto.getUsername())
                    .password(dto.getPassword())
                    .build();
    }
}
