package insper.store.inscricao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Inscricao", description = "Inscricao API")
public class InscricaoResource implements InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @GetMapping("/inscricoes/info")
    @Tag(name = "Info", description = "Inscricao API Info")
    public ResponseEntity<Map<String, String>> info() {
        return new ResponseEntity<Map<String, String>>(
            Map.ofEntries(
                Map.entry("microservice.name", InscricaoApplication.class.getSimpleName()),
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
                    InscricaoApplication.class.getProtectionDomain()
                        .getCodeSource()
                        .getLocation()
                        .getPath()
                    ).toString())
            ), HttpStatus.OK
        );
    }


    @GetMapping("/inscricoes/hello")

    @Operation(summary = "Hello", description = "Hello")
    public String hello() {
        return "Hello from inscrit!";
    }

    @Override
    @Operation(summary = "Create Inscricao", description = "Create Inscricao")
    public ResponseEntity<InscricaoOut> create(InscricaoIn in) {
        // parser
        Inscricao inscricao = InscricaoParser.to(in);
        // insert using service
        inscricao = inscricaoService.create(inscricao);
        // return
        return ResponseEntity.created(
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(inscricao.id())
                .toUri())
            .body(InscricaoParser.to(inscricao));
    }

    @Override
    @Operation(summary = "Update", description = "Update Inscricao")
    public ResponseEntity<InscricaoOut> update(String id, InscricaoIn in) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    // @Override
    // public ResponseEntity<InscricaoOut> login(LoginIn in) {
    //     Inscricao inscricao = inscricaoService.login(in.email(), in.password());
    //     if (inscricao == null) {
    //         return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    //     }
    //     return ResponseEntity.ok(InscricaoParser.to(inscricao));
    // }

    @Override
    @Operation(summary = "Read", description = "Read Inscricao")
    public ResponseEntity<InscricaoOut> read(String idInscricao) {
        final InscricaoOut inscricao = InscricaoOut.builder()
            .id(idInscricao)
            .build();
        return ResponseEntity.ok(inscricao);
    }
    
}
