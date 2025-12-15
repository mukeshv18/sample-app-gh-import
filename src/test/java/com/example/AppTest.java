package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link App} class.
 */
public class AppTest {
    private App app;

    @Before
    public void setUp() {
        app = new App();
    }

    @Test
    public void testGetGreeting_ReturnsDefaultGreeting() {
        assertEquals("Hello World!", app.getGreeting());
    }

    @Test
    public void testGetGreeting_WithName_ReturnsPersonalizedGreeting() {
        assertEquals("Hello John!", app.getGreeting("John"));
    }

    @Test
    public void testGetGreeting_WithNameContainingSpaces_TrimsSpaces() {
        assertEquals("Hello Jane!", app.getGreeting("  Jane  "));
    }

    @Test
    public void testGetGreeting_WithNull_ReturnsDefaultGreeting() {
        assertEquals("Hello World!", app.getGreeting(null));
    }

    @Test
    public void testGetGreeting_WithEmptyString_ReturnsDefaultGreeting() {
        assertEquals("Hello World!", app.getGreeting(""));
    }

    @Test
    public void testGetGreeting_WithWhitespaceOnly_ReturnsDefaultGreeting() {
        assertEquals("Hello World!", app.getGreeting("   "));
    }

    @Test
    public void testAppInstance_IsNotNull() {
        assertNotNull(app);
    }
}
