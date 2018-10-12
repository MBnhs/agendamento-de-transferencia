package br.com.marcelo.agendamentotransferencia;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.marcelo.agendamentotransferencia.repository.TransferenciaRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = { TransferenciaRepository.class })
@EnableTransactionManagement
public class PerfilDeTesteH2Config {

	@Bean
	@Profile("test")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:store");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource();
	}
}
