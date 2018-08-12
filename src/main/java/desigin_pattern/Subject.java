package desigin_pattern;

public interface Subject {
 // 添加一个观察者
    void registerObserver(Observer observer);
    
    // 移除一个观察者
    void removeObserver(Observer observer);
    
    // 通知所有注册的Observer，来执行它们的update方法
    void notifyObservers();
}
