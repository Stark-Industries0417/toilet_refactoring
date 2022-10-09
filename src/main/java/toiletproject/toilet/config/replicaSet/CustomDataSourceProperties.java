package toiletproject.toilet.config.replicaSet;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.datasource")
public class CustomDataSourceProperties {
    private String url;
    private String username;
    private String password;
    private Slave slave;

    @Getter
    @Setter
    public static class Slave {
        private String name;
        private String url;
    }
}