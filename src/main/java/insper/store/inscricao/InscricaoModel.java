package insper.store.inscricao;

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
@Table(name = "inscricao")
@EqualsAndHashCode(of = "id")
@Builder @Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class InscricaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_inscricao")
    private String id;

    @Column(name = "tx_id_user")
    private String id_user;

    @Column(name = "tx_id_job")
    private String id_job;

    @Column(name = "tx_status")
    private String status;
    

    public InscricaoModel(Inscricao o) {
        this.id = o.id();
        this.id_user = o.id_user();
        this.id_job = o.id_job();
        this.status = o.status();
    }
    
    public Inscricao to() {
        return Inscricao.builder()
            .id(id)
            .id_user(id_user)
            .id_job(id_job)
            .status(status)
            .build();
    }
    
}
