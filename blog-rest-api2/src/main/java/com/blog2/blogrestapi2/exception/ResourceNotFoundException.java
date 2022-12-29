package com.blog2.blogrestapi2.exception;

public class ResourceNotFoundException extends RuntimeException {

    private String resource;
    private String name;
    private Object value;

    public ResourceNotFoundException(String resource, String name, Object value) {
        super("'" + resource + "'" +
                " resource with " +
                "'" + name + "'" +
                " of " + value.toString() +
                " is not found");
        this.resource = resource;
        this.name = name;
        this.value = value;
    }

    public String getResource() {
        return resource;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
