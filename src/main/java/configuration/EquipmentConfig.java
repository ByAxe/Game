package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import parser.Parser;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class EquipmentConfig {
    @Bean
    public Parser parser(){
        Path relativePath1 = Paths.get("src/main/java/equipment", "equipment.txt");
        return new Parser(relativePath1.toString());
    }
}
