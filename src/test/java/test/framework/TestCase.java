package test.framework;

public class TestCase<E> {

    private String message;

    private boolean expectedSuccess;

    private E data;

    public TestCase() {
    }

    public TestCase(String message, boolean expectedSuccess) {
        this.message = message;
        this.expectedSuccess = expectedSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isExpectedSuccess() {
        return expectedSuccess;
    }

    public void setExpectedSuccess(boolean expectedSuccess) {
        this.expectedSuccess = expectedSuccess;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "-->>>>>>>> \tExpected result: "+ expectedSuccess +"\n message: "+ message;
    }
}
