package insper.store.inscricao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import insper.store.account.AccountController;
import insper.store.account.AccountOut;
import insper.store.job.JobController;
import insper.store.job.JobOut;
import lombok.NonNull;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    
    @Autowired
    private JobController jobController;
    
    @Autowired
    private AccountController accountController;
    
    
    
    public Inscricao create(Inscricao in) {

        ResponseEntity<JobOut> response = jobController.read(in.id_job());

        if (response.getStatusCode().isError()) throw new IllegalArgumentException("Invalid job");

        ResponseEntity<AccountOut> response2 = accountController.read(in.id_user());

        if (response2.getStatusCode().isError()) throw new IllegalArgumentException("Invalid user");

        
        return inscricaoRepository.save(new InscricaoModel(in)).to();
        
    }

    @Cacheable(value = "inscricao", key = "#id")
    public Inscricao read(@NonNull String id) {
        return inscricaoRepository.findById(id).map(InscricaoModel::to).orElse(null);
    }

    // public Inscricao login(String email, String password) {
    //     String hash = calculateHash(password);
    //     return accountRepository.findByEmailAndHash(email, hash).map(AccountModel::to).orElse(null);
    // }

    // private String calculateHash(String text) {
    //     try {
    //         MessageDigest digest = MessageDigest.getInstance("SHA-256");
    //         byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
    //         byte[] encoded = Base64.getEncoder().encode(hash);
    //         return new String(encoded);
    //     } catch (NoSuchAlgorithmException e) {
    //         throw new RuntimeException(e);
    //     }
    // }
    
}
