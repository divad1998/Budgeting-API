//package com.budgit.unitTests;
//
//import com.budgit.data.PatronRepository;
//import com.budgit.extensions.PatronParameterResolver;
//import com.budgit.hateoas.model.Response;
//import com.budgit.service.PatronService;
//import com.budgit.table.Patron;
//import com.budgit.web.api.PatronController;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.mock.mockito.SpyBean;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import org.springframework.util.StreamUtils;
//import reactor.core.publisher.Mono;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.mockito.internal.verification.VerificationModeFactory.times;
//
//@WebFluxTest(controllers = {PatronController.class})
//@ExtendWith({PatronParameterResolver.class})
//class PatronControllerSpec {
//    private Patron patron;
//    private Mono<Patron> patronMono;
//    @SpyBean
//    private PatronService patronService;
//
//    @Mock
//    private PatronRepository patronRepository;
//
//    @Autowired
//    private WebTestClient client;
//
//    @BeforeEach
//    void init(Patron injectedPatron) {
//        patron = injectedPatron;
//        patronMono = Mono.just(patron);
//    }
//
//    //Patron Story: patron wants to create an account with me.
//    @Nested
//    @DisplayName("Creating a patron.")
//    class CreatingPatron {
//
//        @Test
//        @DisplayName("Creating patron returns HttpStatus.CREATED, hal+json return type -- holding welcome string and links.")
//        void createPatron() throws IOException {
//            ClassPathResource expectedJson = new ClassPathResource("/jsonTestData/CreatePatronResponse.json");
//            String expectedString = StreamUtils.copyToString(expectedJson.getInputStream(), Charset.defaultCharset());
//
//            client.post()
//                    .uri("http://localhost:8080/api/patrons")
//                    .body(patronMono, Patron.class)
//                    .exchange()
//                    .expectStatus()
//                        .isCreated()
//                    .expectHeader()
//                        .contentType("application/hal+json")
//                    .expectBody()
//                        .json(expectedString);
//
//            Mockito.verify(patronService, times(1)).create(any()); //JESUS!
//        }
//
////        @Test
////        @DisplayName("Return HttpStatus.BAD_REQUEST when empty fields are in create-patron request.")
////        void createPatronWithEmptyField() {
////            Patron patron = new Patron();
////            patron.setFirstName(""); patron.setLastName("l");
////            patron.setOtherNames("l"); patron.setCountry("c"); patron.setState("s");
////            patron.setLga("lga"); patron.setCity("city"); patron.setSex("sex");
////            patron.setCateringFor(1); patron.setEmail("email"); patron.setPassword("p");
////
////            client.post()
////                    .uri("http://localhost:8080/api/patrons")
////                    .body(Mono.just(patron), Patron.class)
////                    .exchange()
////                    .expectStatus()
////                        .isBadRequest();
////        }
//
////        @Test
////        @DisplayName("Return HttpStatus.BAD_REQUEST when non-blank fields are blank.")
////        void createPatronWithBlankField() {
////            Patron patron = new Patron();
////            patron.setFirstName(" ");patron.setLastName("l");
////            patron.setOtherNames("l"); patron.setCountry("c"); patron.setState("s");
////            patron.setLga("lga"); patron.setCity("city"); patron.setSex("sex");
////            patron.setCateringFor(1); patron.setEmail("email"); patron.setPassword("p");
////
////            client.post()
////                    .uri("http://localhost:8080/api/patrons")
////                    .body(Mono.just(patron), Patron.class)
////                    .exchange()
////                    .expectStatus()
////                        .isBadRequest();
////        }
//
////        @Test
////        @DisplayName("Return HttpStatus.BAD_REQUEST when fields' size constraints are gone against.")
////        void createPatronWithOutOfRangeValues() {
////            Patron patron = new Patron();
////            patron.setProfileMedia("$");
////            patron.setFirstName("123456789012345678901"); patron.setLastName("l");
////            patron.setOtherNames("l"); patron.setCountry("c"); patron.setState("s");
////            patron.setLga("lga"); patron.setCity("city"); patron.setSex("sex");
////            patron.setCateringFor(1); patron.setEmail("email"); patron.setPassword("p");
////
////            Response response = new Response("Hey! Now our patron!");
////            when(patronService.create(patron)).thenReturn(response);
////
////            client.post()
////                    .uri("http://localhost:8080/api/patrons")
////                    .body(Mono.just(patron), Patron.class)
////                    .exchange()
////                    .expectStatus()
////                        .isBadRequest();
////        }
////    }
//
////    @Nested
////    @DisplayName("Updating a Patron.")
////    class UpdatingPatron {
////
////        @Test
////        @DisplayName("Return OK_STATUS, hal+json and patron+links when after updating patron")
////        void updatePatron() throws IOException {
////            Mono<Patron> patronStream = Mono.just(patron);
////            when(patronService.update(any())).thenReturn(patronStream);
////
////            ClassPathResource expectedJson = new ClassPathResource("/jsonTestData/UpdatePatronResponse.json");
////            String expectedString = StreamUtils.copyToString(expectedJson.getInputStream(), Charset.defaultCharset());
////
////            client
////                    .put()
////                    .uri("http://localhost:8080/api/patrons/{patronId}", 1)
////                    .body(patronStream, Patron.class)
////                    .exchange()
////                    .expectStatus()
////                        .isOk()
////                    .expectHeader()
////                        .contentType("application/hal+json");
//////                    .expectBody() //ToDo
//////                        .json(expectedString);
////
////            Mockito.verify(patronService, times(1)).update(any());
////        }
//   }
//}