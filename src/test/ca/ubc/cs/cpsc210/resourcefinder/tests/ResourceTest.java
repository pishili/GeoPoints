package ca.ubc.cs.cpsc210.resourcefinder.tests;

import ca.ubc.cs.cpsc210.resourcefinder.model.Resource;
import ca.ubc.cs.cpsc210.resourcefinder.model.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// unit tests for Resource class
public class ResourceTest {
    private Resource testResource;
    private Set<Service> requestedServices;

    @BeforeEach
    public void runBefore() {
        testResource = new Resource("UBC Library", null);
        testResource.addService(Service.COUNSELLING);
        testResource.addService(Service.PROGRAMMING);
    }

    @Test
    public void tesGetName() {
        // template for unit tests
        assertEquals("UBC Library", testResource.getName());
    }

    @Test
    public void testHasService() {
//        testResource.services.add(Service.SHELTER);
        assertEquals(2, testResource.getServices().size());
        assertEquals(true, testResource.offersService(Service.PROGRAMMING));
    }

    @Test
    public void testofferAllServiceInRequestedServices(Set<Service> requestedServices) {
        requestedServices.add(Service.FOOD);
        requestedServices.add(Service.PROGRAMMING);
        requestedServices.add(Service.SENIOR);
        assertFalse(testResource.offersAllServicesInSet(requestedServices));
    }

    @Test
    public void testofferAnyServiceInRequestedServices(Set<Service> requestedServices) {
        assertTrue(testResource.offersAnyServicesInSet(requestedServices));
    }

    @Test
    public void testAddOneResource() {
//        testRegistry.addResource(r1);
//        List<Resource> resources = testRegistry.getResources();
//        assertEquals(1, resources.size());
//        assertTrue(resources.contains(r1));
    }
}