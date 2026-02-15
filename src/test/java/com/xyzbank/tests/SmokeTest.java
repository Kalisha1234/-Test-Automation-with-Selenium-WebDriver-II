package com.xyzbank.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Smoke Tests")
@Feature("Basic Validation")
public class SmokeTest {

    @Test
    @DisplayName("Simple passing test")
    @Description("Verify basic test execution works")
    @Severity(SeverityLevel.CRITICAL)
    public void testBasicAssertion() {
        assertTrue(true, "This test should always pass");
    }
    
    @Test
    @DisplayName("Basic math test")
    @Description("Verify test framework is working")
    @Severity(SeverityLevel.NORMAL)
    public void testMath() {
        assertEquals(4, 2 + 2, "Math should work");
    }
}
