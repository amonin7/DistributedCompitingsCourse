package mainpackage;

import mainpackage.config.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

    private static final Logger log = LoggerFactory.getLogger(MainApplication.class);

    private Properties props;

    @Autowired
    public MainApplication(Properties props) {
        this.props = props;
        log.info("\n\n\t" + this.props.getPrefix() + "\n");
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
