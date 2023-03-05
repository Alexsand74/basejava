package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else {
            storage[index] = r;
        }
    }

    public void update(Resume oldResume, Resume resume) {
        int i = getIndex(oldResume.getUuid());
        if (i == -1) {
            System.out.println(" Resume " + oldResume.getUuid() + " not exist ");
        } else {
            storage[i] = resume;
        }
    }

    public void save(Resume r) {
        int i = getIndex(r.getUuid());
        if (i != -1 || size == storage.length) {
            System.out.println(" Resume " + r.getUuid() + " already exist ");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int i = getIndex(uuid);
        if (i >= 0) {
            return storage[getIndex(uuid)];
        } else {
            System.out.println(uuid + " ERROR no element !!!");
            return null;
        }
    }

    public void delete(String uuid) {
        int i = getIndex(uuid);
        if (i >= 0) {
            storage[i] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println(uuid + " ERROR no element !!!");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
