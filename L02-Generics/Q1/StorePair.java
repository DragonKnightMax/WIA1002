public class StorePair<T extends Comparable<T>> implements Comparable<StorePair<T>> {
    private T first, second;

    public StorePair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "first = " + first + " second = " + second;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StorePair<?>) {
            return ((StorePair<?>) obj).getFirst().equals(first);
        }
        return false;
    }

    @Override
    public int compareTo(StorePair<T> o) {
        return first.compareTo(o.getFirst());
    }
}
