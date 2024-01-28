package gov.toki.accountingapprestapi.core.api.config;


@Configuration
@EnableWebMvc
public class SpringFoxConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo("Estu Fasting Rest APIs",
                "APIs for Estu Fasting Project.",
                "0.0.1-SNAPSHOT",
                "Terms of catering",
                new Contact("Tabıldot", "https://github.com/EstuFasting", "smh01.2019@gmail.com"),
                "MIT License", "https://github.com/EstuFasting",
                Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .securityContexts(List.of(securityContext()))
                .securitySchemes(List.of(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey(HttpHeaders.AUTHORIZATION, "JWT", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return List.of(new SecurityReference(HttpHeaders.AUTHORIZATION, authorizationScopes));
    }

}