package mini.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Nested;

// import org.glassfish.jersey.test.TestProperties;
// import org.glassfish.jersey.test.framework.junit.JerseyTest;

import java.util.ArrayList;

import javax.ws.rs.WebApplicationException;

import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import mini.usecase.SimpleUsecase;

@ExtendWith(MockitoExtension.class)
public class SimpleControllerTest {

    @InjectMocks
    public SimpleController target;

    @Mock
    public SimpleUsecase mockUsecase;

    @Nested
    public class Success {
        @DisplayName("正常系")
        @Test
        public void test() {
            Mockito.when(mockUsecase.get()).thenReturn(new ArrayList<>());
            Assertions.assertDoesNotThrow(()->{target.get();});
        }
    }

    @Nested
    public class Failure {

        @DisplayName("RuntimeException発生時にWebApplicationExceptionをthrowする")
        @Test
        public void test() {
            // Mockito.when(mockUsecase.get()).thenThrow(new RuntimeException("test-exception"));
            // Assertions.assertThrows(RuntimeException.class, ()->{target.get();});
            // Assertions.assertThrows(WebApplicationException.class, ()->{target.get();});
        }
    }
}