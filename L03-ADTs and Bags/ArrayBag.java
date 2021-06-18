public class ArrayBag<T> implements BagInterface<T> {
    private static final int DEFAULT_CAPACITY = 25;
    private T[] bag;
    private int numberOfEntries;

    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }

        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return (numberOfEntries >= bag.length);
    }

    @Override
    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }

    @Override
    public boolean add(T newEntry) {
        if (newEntry == null) {
            throw new IllegalArgumentException("New entry must not be null");
        }
        else if (!isFull()) {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }
        return false;
    }

    @Override
    public T remove() {
        T result = null;
        if (!isEmpty()) {
            result = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        if (!isEmpty()) {
            for (int i = 0; i < numberOfEntries; i++) {
                if (bag[i].equals(anEntry)) {
                    // shift remaining items left by one
                    for (int j = i; j < numberOfEntries - 1; j++) {
                        bag[j] = bag[j+1];
                    }

                    bag[numberOfEntries - 1] = null;
                    numberOfEntries--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean contains(T anEntry) {
        if (!isEmpty()) {
            for (int i = 0; i < numberOfEntries; i++) {
                if (bag[i].equals(anEntry)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[i];
        }
        return result;
    }

    // Q2
    @Override
    public BagInterface<T> union(BagInterface<T> aBag) {
        T[] bagA = this.toArray();
        T[] bagB = aBag.toArray();

        int totalSize = bagA.length + bagB.length;
        ArrayBag<T> unionBag = new ArrayBag<>(totalSize);

        for (int i = 0; i < bagA.length; i++) {
            unionBag.add(bagA[i]);
        }

        for (int i = 0; i < bagB.length; i++) {
            unionBag.add(bagB[i]);
        }
        return unionBag;
    }

    // Q3
    @Override
    public BagInterface<T> intersection(BagInterface<T> aBag) {
        T[] bagA = this.toArray();
        T[] bagB = aBag.toArray();
        ArrayBag<T> intersectionBag = new ArrayBag<>(bagA.length);

        for (int i = 0; i < bagA.length; i++) {
            for (int j = 0; j < bagB.length; j++) {
                if (bagA[i].equals(bagB[j])) {
                    intersectionBag.add(bagB[j]);
                    bagB[j] = null;
                    break;  // go to next loop
                }
            }
        }
        return intersectionBag;
    }

    // Q4
    @Override
    public BagInterface<T> difference(BagInterface<T> aBag) {
        T[] bagA = this.toArray();
        T[] bagB = aBag.toArray();
        ArrayBag<T> differenceBag = new ArrayBag<>(bagA.length);

        // set duplicate items to null
        for (int i = 0; i < bagA.length; i++) {
            for (int j = 0; j < bagB.length; j++) {
                if (bagA[i].equals(bagB[j])) {
                    bagA[i] = null;
                    bagB[j] = null;
                    break;
                }
            }
        }

        for (int i = 0; i < bagA.length; i++) {
            if (bagA[i] != null) {
                differenceBag.add(bagA[i]);
            }
        }
        return differenceBag;
    }
}
