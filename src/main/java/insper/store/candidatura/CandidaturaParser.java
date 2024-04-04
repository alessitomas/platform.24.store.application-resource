package insper.store.candidatura;

public class CandidaturaParser {

    public static Candidatura to(CandidaturaIn in) {
        return Candidatura.builder()
            .email(in.email())
            .name(in.name())
            .password(in.password())
            .build();
    }

    public static CandidaturaOut to(Candidatura Candidatura) {
        return CandidaturaOut.builder()
            .id(Candidatura.id())
            .email(Candidatura.email())
            .name(Candidatura.name())
            .build();
    }
    
}
