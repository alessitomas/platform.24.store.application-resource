package insper.store.candidatura;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CandidaturaResource implements CandidaturaController {

    @Autowired
    private CandidaturaService candidaturaService;

    @GetMapping("/candidaturas/info")
    public ResponseEntity<Map<String, String>> info() {
        return new ResponseEntity<Map<String, String>>(
            Map.ofEntries(
                Map.entry("microservice.name", CandidaturaApplication.class.getSimpleName()),
                Map.entry("os.arch", System.getProperty("os.arch")),
                Map.entry("os.name", System.getProperty("os.name")),
                Map.entry("os.version", System.getProperty("os.version")),
                Map.entry("file.separator", System.getProperty("file.separator")),
                Map.entry("java.class.path", System.getProperty("java.class.path")),
                Map.entry("java.home", System.getProperty("java.home")),
                Map.entry("java.vendor", System.getProperty("java.vendor")),
                Map.entry("java.vendor.url", System.getProperty("java.vendor.url")),
                Map.entry("java.version", System.getProperty("java.version")),
                Map.entry("line.separator", System.getProperty("line.separator")),
                Map.entry("path.separator", System.getProperty("path.separator")),
                Map.entry("user.dir", System.getProperty("user.dir")),
                Map.entry("user.home", System.getProperty("user.home")),
                Map.entry("user.name", System.getProperty("user.name")),
                Map.entry("jar", new java.io.File(
                    CandidaturaApplication.class.getProtectionDomain()
                        .getCodeSource()
                        .getLocation()
                        .getPath()
                    ).toString())
            ), HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<CandidaturaOut> create(CandidaturaIn in) {
        // parser
        Candidatura candidatura = CandidaturaParser.to(in);
        // insert using service
        candidatura = candidaturaService.create(candidatura);
        // return
        return ResponseEntity.created(
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(candidatura.id())
                .toUri())
            .body(CandidaturaParser.to(candidatura));
    }

    @Override
    public ResponseEntity<CandidaturaOut> update(String id, CandidaturaIn in) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    // @Override
    // public ResponseEntity<CandidaturaOut> login(LoginIn in) {
    //     Candidatura candidatura = candidaturaService.login(in.email(), in.password());
    //     if (candidatura == null) {
    //         return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    //     }
    //     return ResponseEntity.ok(CandidaturaParser.to(candidatura));
    // }

    @Override
    public ResponseEntity<CandidaturaOut> read(String idUser, String roleUser) {
        final CandidaturaOut candidatura = CandidaturaOut.builder()
            .id(idUser)
            .name(roleUser)
            .build();
        return ResponseEntity.ok(candidatura);
    }
    
}
