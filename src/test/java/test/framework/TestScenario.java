package test.framework;

public class TestScenario<E> {

    private E entity;

    private boolean expectedSuccess;

    public TestScenario(E entity, boolean expectedResult) {
        this.entity = entity;
        this.expectedSuccess = expectedResult;
    }

    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }

    public boolean isExpectedSuccess() {
        return expectedSuccess;
    }

    public void setExpectedSuccess(boolean expectedSuccess) {
        this.expectedSuccess = expectedSuccess;
    }
}
