package insper.store.inscricao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = { "insper.store.account", "insper.store.job" })
@EnableDiscoveryClient
@SpringBootApplication
@EnableCaching
public class InscricaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InscricaoApplication.class, args);
    }

}
