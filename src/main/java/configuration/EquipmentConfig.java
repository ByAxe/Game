package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import parser.MyParser;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class EquipmentConfig {

    @Bean
    public MyParser parser(){
        Path relativePath = Paths.get("src/main/java/equipment", "equipment.txt");
        return new MyParser(relativePath.toString());
    }
}
