package dto.tm;


import javafx.scene.control.Button;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateUserTm  {
    private String userId;
    private String name;
    private String contactNo;
    private Button btnR;
    private Button btnD;

}
