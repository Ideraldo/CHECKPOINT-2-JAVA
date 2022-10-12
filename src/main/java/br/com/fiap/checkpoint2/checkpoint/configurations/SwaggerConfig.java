package br.com.fiap.checkpoint2.checkpoint.configurations;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(
		title = "Pedidos", 
		version = "1.0", 
		description = "Projeto Checkpoint 2"))
public class SwaggerConfig {

}
