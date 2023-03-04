package com.urise.webapp.model;

/**
 * Initial resume class
 */
public class Resume {
    // Unique identifier
    String uuid;
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getUuid() {
        return uuid;
    }
    @Override
    public String toString() {
        return uuid;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Resume)) return false;
//        Resume resume = (Resume) o;
//        return Objects.equals(getUuid(), resume.getUuid());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getUuid());
//    }
}
