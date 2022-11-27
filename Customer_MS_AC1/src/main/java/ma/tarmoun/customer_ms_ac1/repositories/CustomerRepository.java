

package ma.tarmoun.customer_ms_ac1.repositories;
import ma.tarmoun.customer_ms_ac1.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {

}
