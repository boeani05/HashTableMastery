package com.boeani.logic;

import com.boeani.db.Database;
import com.boeani.entry.Entry;

import java.util.Iterator;
import java.util.List;

public record Logic(Database db) {

    public void put(String key, int value) {
        List<Entry> currentBucket;
        int index;
        int hashCodeOfKey;

        Entry newEntry = new Entry(key, value);

        hashCodeOfKey = key.hashCode();

        if (hashCodeOfKey < 0) {
            hashCodeOfKey = Math.abs(hashCodeOfKey);
        }

        index = hashCodeOfKey % db.getCapacity();

        currentBucket = db.getBucket(index);

        for (Entry entry : currentBucket) {
            if (entry.getKey().equals(newEntry.getKey())) {
                entry.setValue(value);
                System.out.println("\n--- Table UPDATED successfully ---");
                return;
            }
        }

        currentBucket.add(newEntry);
        System.out.println("\n--- Successfully added NEW entry ---");
        db.setSize(db.getSize() + 1);
    }

    public int get(String key) {
        List<Entry> currentBucket;
        int index;
        int hashCodeOfKey;

        hashCodeOfKey = key.hashCode();

        if (hashCodeOfKey < 0) {
            hashCodeOfKey = Math.abs(hashCodeOfKey);
        }

        index = hashCodeOfKey % db.getCapacity();

        currentBucket = db.getBucket(index);

        for (Entry entry : currentBucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        System.out.println("\n--- Key " + key + " does not exist ---");
        return -1;
    }

    public void remove(String key) {
        List<Entry> currentBucket;
        Iterator<Entry> entryIterator;
        int index;
        int hashCodeOfKey;

        hashCodeOfKey = key.hashCode();

        if (hashCodeOfKey < 0) {
            hashCodeOfKey = Math.abs(hashCodeOfKey);
        }

        index = hashCodeOfKey % db.getCapacity();

        currentBucket = db.getBucket(index);

        entryIterator = currentBucket.iterator();

        while (entryIterator.hasNext()) {
            Entry entry = entryIterator.next();
            if (entry.getKey().equals(key)) {
                entryIterator.remove();

                System.out.println("\n--- " + key + " removed successfully ---");

                db.setSize(db.getSize() - 1);

                return;
            }
        }

        System.out.println("\n--- " + key + " not found ---");
    }

    public boolean containsKey(String key) {
        List<Entry> currentBucket;
        int index;
        int hashCodeOfKey;

        hashCodeOfKey = key.hashCode();

        if (hashCodeOfKey < 0) {
            hashCodeOfKey = Math.abs(hashCodeOfKey);
        }

        index = hashCodeOfKey % db.getCapacity();

        currentBucket = db.getBucket(index);

        for (Entry entry : currentBucket) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return db.getSize();
    }
}
