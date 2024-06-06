package edu.inteli.a2024.m01.grupo2.planejador;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuração global de CORS para a aplicação Spring Boot.
 * Define as políticas de CORS (Cross-Origin Resource Sharing) aplicáveis a
 * todas as rotas da aplicação.
 * Permite que recursos da aplicação sejam requisitados de qualquer origem, com
 * qualquer método HTTP e cabeçalhos.
 */
@Configuration
public class CORSConfig {
    /**
     * Define e registra a configuração global de CORS.
     * Utiliza um bean do tipo {@link WebMvcConfigurer} para customizar a
     * configuração MVC da aplicação,
     * especificamente para adicionar mapeamentos de CORS que se aplicarão
     * globalmente.
     *
     * @return Uma instância de {@link WebMvcConfigurer} com as configurações de
     *         CORS definidas.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * Configura as políticas de CORS para a aplicação.
             * Este método especifica que todas as rotas ("/**") permitem solicitações de
             * qualquer origem ("*"),
             * com qualquer método HTTP e qualquer cabeçalho. Isso foi feito para evitar o
             * erro de CORS que a gente teve enquanto rodava as duas aplicações via
             * localhost.
             *
             * @param registry O registro de configurações de CORS a ser modificado.
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }
}
