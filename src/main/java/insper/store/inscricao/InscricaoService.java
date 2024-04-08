package insper.store.inscricao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    public Inscricao create(Inscricao in) {
        // in.hash(calculateHash(in.password()));
        // in.password(null);
        return inscricaoRepository.save(new InscricaoModel(in)).to();
    }

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
