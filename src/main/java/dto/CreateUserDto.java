package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateUserDto {
    private String userId;
    private String name;
    private String contactNo;
    private String email;
    private String password;
}
