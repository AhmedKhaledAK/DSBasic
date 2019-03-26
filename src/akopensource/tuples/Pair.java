package akopensource.tuples;

public class Pair {

    private Object firstElem, secondElem;

    public Pair(Object firstElem, Object secondElem) {
        this.firstElem = firstElem;
        this.secondElem = secondElem;
    }

    public Object getFirstElem() {
        return firstElem;
    }

    public Object getSecondElem() {
        return secondElem;
    }

}
