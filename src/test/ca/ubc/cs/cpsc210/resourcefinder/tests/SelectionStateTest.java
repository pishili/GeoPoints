package ca.ubc.cs.cpsc210.resourcefinder.tests;

import ca.ubc.cs.cpsc210.resourcefinder.model.Resource;
import ca.ubc.cs.cpsc210.resourcefinder.model.ResourceRegistry;
import ca.ubc.cs.cpsc210.resourcefinder.model.SelectionState;
import ca.ubc.cs.cpsc210.resourcefinder.model.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.fail;


// unit tests for SelectionState class
public class SelectionStateTest {
    private SelectionState testSelectionState;
    private ResourceRegistry registry;
    private Resource r1;
    private Resource r2;
    private Resource r3;
    private Resource r4;

    @BeforeEach
    public void runBefore() {
        registry = new ResourceRegistry();
        loadResources();
        testSelectionState = new SelectionState(registry);
    }

    @Test
    public void testsetSelectedServices() {
        // template for unit tests
        Set<Service>  selectedServices= new HashSet<>();
        selectedServices.add(Service.FOOD);
        selectedServices.add(Service.SHELTER);
        assertEquals(selectedServices, testSelectionState.getResourcesWithSelectedServices());
    }

    @Test
    public void testSelectAny() {
        testSelectionState.setSelectAny();
        testSelectionState.selectService(Service.FOOD);
        assertEquals(3, testSelectionState.getResourcesWithSelectedServices().size());
    }

    @Test
    public void testSelectAll() {
        testSelectionState.setSelectAll();
        testSelectionState.selectService(Service.FOOD);
        testSelectionState.selectService(Service.SHELTER);
        assertEquals(2, testSelectionState.getResourcesWithSelectedServices().size());
    }

    @Test
    public void testSelectAnyReturnsAllResources() {
        testSelectionState.setSelectAny();
        testSelectionState.selectService(null);
        Set<Resource> resources = new HashSet<>();
        resources.add(r1);
        resources.add(r2);
        resources.add(r3);
        resources.add(r4);
        assertEquals(4, testSelectionState.getResourcesWithSelectedServices().size());
    }

//    @Test
//    public void testSeX() {
//        // template for unit tests
//        fail("Test not implemented ");
//    }

    // MODIFIES: this
    // EFFECTS:  adds services to resources and resources to resource registry
    private void loadResources() {
        r1 = new Resource("Res 1", null);
        r2 = new Resource("Res 2", null);
        r3 = new Resource("Res 3", null);
        r4 = new Resource("Res 4", null);

        r1.addService(Service.FOOD);
        r1.addService(Service.SHELTER);
        r2.addService(Service.YOUTH);
        r2.addService(Service.FOOD);
        r3.addService(Service.SENIOR);
        r3.addService(Service.COUNSELLING);
        r4.addService(Service.SHELTER);
        r4.addService(Service.FOOD);
        r4.addService(Service.LEGAL);

        registry.addResource(r1);
        registry.addResource(r2);
        registry.addResource(r3);
        registry.addResource(r4);
    }
}