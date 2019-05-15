package by.it.bildziuh.calc;

public class Report {

    private String name = "";
    private String startTime = "";
    private String finishTime = "";
    private String operations = "";

    public void setName(String name) {
        this.name = name;
    }

    void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    void setOperations(String operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return name + '\n' +
                "start time: " + startTime + '\n' +
                "operations: " + operations + '\n' +
                "finish time: " + finishTime;
    }
}
