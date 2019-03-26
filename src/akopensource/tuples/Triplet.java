package akopensource.tuples;

public class Triplet {

    private Object firstElem, secondElem, thirdElem;

    public Triplet(Object firstElem, Object secondElem, Object thirdElem) {
        this.firstElem = firstElem;
        this.secondElem = secondElem;
        this.thirdElem = thirdElem;
    }

    public Object getFirstElem() {
        return firstElem;
    }

    public Object getSecondElem() {
        return secondElem;
    }

    public Object getThirdElem() {
        return thirdElem;
    }
}
