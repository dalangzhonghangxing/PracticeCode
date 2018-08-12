package desigin_pattern;

public interface Observer {
    // 当Subject调用notifyObservers后，会调用这个方法
    void update(int i);
}
