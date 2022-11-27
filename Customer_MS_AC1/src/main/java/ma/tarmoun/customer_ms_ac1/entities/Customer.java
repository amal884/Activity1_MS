package ma.tarmoun.customer_ms_ac1.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    private String name;
    private String email;


}
