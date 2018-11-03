package ca.ubc.cs.cpsc210.resourcefinder.model;


import java.util.*;

// Registry of available resources
public class ResourceRegistry {
    private List<Resource> resources;

    // EFFECTS: constructs empty resource registry
    public ResourceRegistry() {
        resources = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: add resource to registry, maintains resources in the order added to registry
    public void addResource(Resource resource) {
        // stub
        resources.add(resource);
    }

    // EFFECTS: returns resources in registry as unmodifiable list (in order that they were added
    // to registry)
    public List<Resource> getResources() {

        return resources;
    }

    // EFFECTS: returns set of resources in registry that offer the given service
    public Set<Resource> getResourcesOfferingService(Service service) {
        Set<Resource> result = new HashSet<>();
        for(Resource resource:resources) {
            if(resource.offersService(service)){
                result.add(resource);
            }
        }
        return result;
    }

    // EFFECTS: returns set of resources in registry that offer all the services in requestedServices set
    public Set<Resource> getResourcesOfferingAllServicesInSet(Set<Service> requestedServices) {
        Set<Resource> result = new HashSet<>();
        for (Resource resource : resources) {
            if (resource.offerAllServicesInSet(requestedServices)) {
                result.add(resource);
            }
        }
        return result;
    }

    // EFFECTS: returns set of resources in registry that off any of the services in requestedServices set
    public Set<Resource> getResourcesOfferingAnyServicesInSet(Set<Service> requestedServices) {

        Set<Resource> result = new HashSet<>();
        for(Resource resource: resources) {
            if(resource.offerAnyServiceInSet(requestedServices)) {
                result.add(resource);
            }
        }
        return result;  // stub
    }
}
