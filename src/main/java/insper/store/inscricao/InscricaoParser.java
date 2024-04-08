package insper.store.inscricao;

public class InscricaoParser {

    public static Inscricao to(InscricaoIn in) {
        return Inscricao.builder()
            .id_user(in.id_user())
            .id_job(in.id_job())
            .status("Pendente")
            .build();
    }

    public static InscricaoOut to(Inscricao Inscricao) {
        return InscricaoOut.builder()
            .id(Inscricao.id())
            .id_user(Inscricao.id_user())
            .id_job(Inscricao.id_job())
            .status(Inscricao.status())
            .build();
    }
    
}
