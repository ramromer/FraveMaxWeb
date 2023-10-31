package FraveMax.FraveMaxWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class FraveMaxWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(FraveMaxWebApplication.class, args);
		Connection con=Conexion.getConexion();
	}

}
