package com.blog.blogrestapi.exception;


public class ResourceNotFoundException extends RuntimeException {
    private final String resourceName;
    private final String fieldName;
    private long fieldValue;
    private String fieldValueString;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        // Post not found with id : 1
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValueString) {
        // Post not found with id : 1
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValueString));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValueString = fieldValueString;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }

    public String getFieldValueString() {
        return fieldValueString;
    }
}

