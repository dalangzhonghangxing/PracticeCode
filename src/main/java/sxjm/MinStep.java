package sxjm;

import java.util.List;

public class MinStep {
    private boolean reachable;// 是否可达
    private Double minStep;// 最短步长
    private List<Integer> step;// 最短路径

    public MinStep() {}

    public MinStep(boolean reachable, Double minStep) {
        this.reachable = reachable;
        this.minStep = minStep;
    }

    public boolean isReachable() {
        return reachable;
    }

    public void setReachable(boolean reachable) {
        this.reachable = reachable;
    }

    public Double getMinStep() {
        return minStep;
    }

    public void setMinStep(Double minStep) {
        this.minStep = minStep;
    }

    public List<Integer> getStep() {
        return step;
    }

    public void setStep(List<Integer> step) {
        this.step = step;
    }
}
