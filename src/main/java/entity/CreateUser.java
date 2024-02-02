package entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateUser {
    private String userId;
    private String name;
    private String contactNo;
    private String email;
    private String password;

}
