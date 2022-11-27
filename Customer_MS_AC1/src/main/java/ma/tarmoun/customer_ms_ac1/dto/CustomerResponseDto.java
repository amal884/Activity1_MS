package ma.tarmoun.customer_ms_ac1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDto {
    private String id ;
    private String name;
    private String email;
}
