package insper.store.candidatura;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidaturaRepository extends CrudRepository<CandidaturaModel, String> {
    
}
