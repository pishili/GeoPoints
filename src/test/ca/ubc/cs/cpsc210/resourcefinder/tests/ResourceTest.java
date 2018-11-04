package ca.ubc.cs.cpsc210.resourcefinder.tests;

import ca.ubc.cs.cpsc210.resourcefinder.model.Resource;
import ca.ubc.cs.cpsc210.resourcefinder.model.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// unit tests for Resource class
public class ResourceTest {
    private Resource testResource;

    @BeforeEach
    public void runBefore() {
        testResource = new Resource("Family Services", null);
        testResource.addService(Service.FOOD);
        testResource.addService(Service.SHELTER);
    }

    @Test
    public void tesGetName() {
        // template for unit tests
        assertEquals("Family Services", testResource.getName());
    }

    @Test
    public void testHasService() {
//        testResource.services.add(Service.SHELTER);
        assertEquals(2, testResource.getServices().size());
        assertEquals(true, testResource.offersService(Service.FOOD));
    }
}