package microservice.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class RouteApplication {

    private static Logger loggger = LoggerFactory.getLogger(RouteApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RouteApplication.class, args);
        loggger.info("<<<<<< server start....... >>>>>>");
    }

}
