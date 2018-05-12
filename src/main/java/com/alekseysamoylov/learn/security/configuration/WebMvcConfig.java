package com.alekseysamoylov.learn.security.configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@ComponentScan(basePackages = {
//        "com.alekseysamoylov.learn.security.controller"
//})
public class WebMvcConfig implements WebMvcConfigurer {

//    /**
//     * We mention this in the book, but this helps to ensure that the intercept-url patterns prevent access to our
//     * controllers. For example, once security has been applied for administrators try commenting out the modifications
//     * to the super class and requesting <a
//     * href="http://localhost:800/calendar/events/.html">http://localhost:800/calendar/events/.html</a>. You will
//     * observe that security is bypassed since it did not match the pattern we provided. In later chapters, we discuss
//     * how to secure the service tier which helps mitigate bypassing of the URL based security too.
//     */
//    // FIXME: FInd out what this is and why it is here.
//    @Bean
//    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
//        RequestMappingHandlerMapping result = new RequestMappingHandlerMapping();
//        result.setUseSuffixPatternMatch(false);
//        result.setUseTrailingSlashMatch(false);
//        return result;
//    }
//
//    @Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**")
//                .addResourceLocations("/resources/")
//                .setCachePeriod(31_556_926)
//        ;
//    }
//
//    @Override
//    public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
//        configurer
//                .ignoreAcceptHeader(false)
//                .favorPathExtension(true) // .html / .json / .ms
//                .defaultContentType(MediaType.TEXT_HTML) // text/html
//                .mediaTypes(
//                        new HashMap<String, MediaType>(){
//                            {
//                                put("html", MediaType.TEXT_HTML);
//                                put("xml", MediaType.APPLICATION_XML);
//                                put("json", MediaType.APPLICATION_JSON);
//                            }
//                        })
//        ;
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new MappingJackson2HttpMessageConverter());
//    }
//
//
//    @Bean
//    public MappingJackson2JsonView jacksonView() {
//        MappingJackson2JsonView jacksonView = new MappingJackson2JsonView();
//        jacksonView.setExtractValueFromSingleKeyModel(true);
//
//        Set<String> modelKeys = new HashSet<String>();
//        modelKeys.add("events");
//        modelKeys.add("event");
//        jacksonView.setModelKeys(modelKeys);
//
//        return jacksonView;
//    }
//
////    @Override
////    public void configureViewResolvers(final ViewResolverRegistry registry) {
////        registry.viewResolver(thymeleafViewResolver);
////    }
//
//
//    // i18N support
//    @Bean
//    public ReloadableResourceBundleMessageSource messageSource() {
//        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
//        resource.setBasenames("/WEB-INF/locales/messages");
//        resource.setDefaultEncoding("UTF-8");
//        resource.setFallbackToSystemLocale(Boolean.TRUE);
//        return resource;
//    }
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
//        configurer.enable();
//    }


}
