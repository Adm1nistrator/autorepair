package autorepair;
 
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
 
@Component
public class ClientDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new client:
    @Transactional
    public void persist(Client client) {
        em.persist(client);
    }
 
    // Retrieves all the client:
    public List<Client> getAllClient() {
    	TypedQuery<Client> query = em.createQuery(
            "SELECT g FROM Client g ORDER BY g.id", Client.class);
    	return query.getResultList();
    }
}