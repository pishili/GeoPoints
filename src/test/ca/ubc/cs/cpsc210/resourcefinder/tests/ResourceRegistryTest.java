package ca.ubc.cs.cpsc210.resourcefinder.tests;

import ca.ubc.cs.cpsc210.resourcefinder.model.Resource;
import ca.ubc.cs.cpsc210.resourcefinder.model.ResourceRegistry;
import ca.ubc.cs.cpsc210.resourcefinder.model.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

// unit tests for ResourceRegistry class
public class ResourceRegistryTest {
    private ResourceRegistry testRegistry;
    private Set<Service> requestedServices;
    private Resource r1;
    private Resource r2;
    private Resource r3;
    private Resource r4;


    @BeforeEach
    public void runBefore() {
        testRegistry = new ResourceRegistry();
        requestedServices = new HashSet<>();
        r1 = new Resource("Res 1", null);
        r2 = new Resource("Res 2", null);
        r3 = new Resource("Res 3", null);
        r4 = new Resource("Res 4", null);
    }

    @Test
    public void testGetResources() {
        testRegistry.addResource(r1);
        testRegistry.addResource(r2);
        // template for unit tests
        assertEquals(2, testRegistry.getResources());
    }

    @Test
    public void testgetResourcesOfferingService() {
        testRegistry.addResource(r1);
        testRegistry.addResource(r2);
        r1.addService(Service.FOOD);
        r1.addService(Service.YOUTH);
        r2.addService(Service.YOUTH);
        r2.addService(Service.PROGRAMMING);
        assertEquals(r1, testRegistry.getResourcesOfferingService(Service.FOOD));
    }

    @Test
    public void testgetResourcesOfferingAllServicesInSetTrue() {
        Set<Service> services = new HashSet<>();
        services.add(Service.FOOD);
        services.add(Service.YOUTH);
        testRegistry.addResource(r1);
        r1.addService(Service.FOOD);
        r1.addService(Service.YOUTH);
        assertEquals(r1, testRegistry.getResourcesOfferingAllServicesInSet(services));
    }

    @Test
    public void testgetResourcesOfferingAllServicesInSetFalse() {
        Set<Service> services = new HashSet<>();
        services.add(Service.FOOD);
        services.add(Service.YOUTH);
        testRegistry.addResource(r1);
        testRegistry.addResource(r2);
        r2.addService(Service.YOUTH);
        r2.addService(Service.PROGRAMMING);
//        assertTrue(testRegistry.getResourcesOfferingAllServicesInSet(services));
        assertEquals(null, testRegistry.getResourcesOfferingAllServicesInSet(services));
    }

    @Test
    public void testgetResourcesOfferingAnyServicesInSet() {
        Set<Service> services = new HashSet<>();
        services.add(Service.FOOD);
        services.add(Service.YOUTH);
        testRegistry.addResource(r1);
        testRegistry.addResource(r2);
        r2.addService(Service.YOUTH);
        r2.addService(Service.PROGRAMMING);
//        assertTrue(testRegistry.getResourcesOfferingAllServicesInSet(services));
        assertEquals(r2, testRegistry.getResourcesOfferingAnyServicesInSet(services));
    }

    // MODIFIES: this
    // EFFECTS:  adds services to resources and resources to registry
    private void loadResources() {
        r1.addService(Service.FOOD);
        r1.addService(Service.SHELTER);
        r2.addService(Service.YOUTH);
        r2.addService(Service.FOOD);
        r3.addService(Service.SENIOR);
        r4.addService(Service.SHELTER);
        r4.addService(Service.FOOD);
        r4.addService(Service.LEGAL);

        testRegistry.addResource(r1);
        testRegistry.addResource(r2);
        testRegistry.addResource(r3);
        testRegistry.addResource(r4);
    }

    @Test
    public void testAddOneResource() {
        testRegistry.addResource(r1);
        List<Resource> resources = testRegistry.getResources();
//        assertEquals(1, resources.size());
//        assertTrue(resources.contains(r1));
    }
}