package test.framework;

import retrofit2.Response;

public class ServerResponse<E> {

     private E entity;

     private String error;

     private boolean successful;

    public ServerResponse() {
    }

    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
