package business.abstracts;

public interface Validator<T> {
    boolean validate(T object);
}
