package insper.store.candidatura;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "candidatura")
@EqualsAndHashCode(of = "id")
@Builder @Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class CandidaturaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_candidatura")
    private String id;

    @Column(name = "tx_name")
    private String name;

    @Column(name = "tx_email")
    private String email;

    @Column(name = "tx_hash")
    private String hash;

    public CandidaturaModel(Candidatura o) {
        this.id = o.id();
        this.name = o.name();
        this.email = o.email();
        this.hash = o.hash();
    }
    
    public Candidatura to() {
        return Candidatura.builder()
            .id(id)
            .name(name)
            .email(email)
            .hash(hash)
            .build();
    }
    
}
