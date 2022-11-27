package ma.tarmoun.eureka_ms_ac1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMsAc1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMsAc1Application.class, args);
    }

}
