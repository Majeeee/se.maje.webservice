package se.maje.WebService_Uppgifter_Lektion_6.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.maje.WebService_Uppgifter_Lektion_6.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}