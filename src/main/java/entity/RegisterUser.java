package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class RegisterUser {
    @Id
    private String userId;
    private String name;
    private String contactNo;
    private String email;
    private String password;

}
