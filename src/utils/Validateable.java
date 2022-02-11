package utils;

public interface Validateable {
    /**
     * validates all fields after csv deserialization
     * @return
     */
    public boolean validate();
}
