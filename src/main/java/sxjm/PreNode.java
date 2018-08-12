package sxjm;

public class PreNode {
    private int preNodeNum;// 最优 前一个节点
    private Double nodeStep;// 最小步长

    public PreNode(int preNodeNum, Double nodeStep) {
        this.preNodeNum = preNodeNum;
        this.nodeStep = nodeStep;
    }

    public int getPreNodeNum() {
        return preNodeNum;
    }

    public void setPreNodeNum(int preNodeNum) {
        this.preNodeNum = preNodeNum;
    }

    public Double getNodeStep() {
        return nodeStep;
    }

    public void setNodeStep(Double nodeStep) {
        this.nodeStep = nodeStep;
    }
}
