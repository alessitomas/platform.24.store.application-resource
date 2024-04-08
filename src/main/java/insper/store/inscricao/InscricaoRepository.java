package insper.store.inscricao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends CrudRepository<InscricaoModel, String> {
    
}
