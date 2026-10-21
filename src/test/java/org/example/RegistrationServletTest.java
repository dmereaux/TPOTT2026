package org.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class RegistrationServletTest {
    @Test
    public void shouldRedirectToRegistrationPageIfAnyParamIsEmpty() throws ServletException, IOException {
        HttpServletRequest mockRequest = mock();
        HttpServletResponse mockResponse = mock();
        RequestDispatcher mockRequestDispatcher = mock();
        when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockRequestDispatcher);

        new RegistrationServlet().doPost(mockRequest, mockResponse);

        verify(mockRequest, times(1)).getRequestDispatcher(eq("/Register_1.jsp"));
    }

    @Test
    public void shouldRedirectToRegistrationSuccessPageIfAllParamsAreNonEmpty() throws ServletException, IOException {
        HttpServletRequest mockRequest = mock();
        HttpServletResponse mockResponse = mock();
        RequestDispatcher mockRequestDispatcher = mock();
        when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockRequestDispatcher);
        when(mockRequest.getParameter(anyString())).thenReturn("test");

        new RegistrationServlet().doPost(mockRequest, mockResponse);

        verify(mockRequest, times(1)).getRequestDispatcher(eq("/Register_2.jsp"));
    }
}