
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Entity.Utilisateur;

@Repository // bean
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

}
