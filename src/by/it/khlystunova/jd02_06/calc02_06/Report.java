package by.it.khlystunova.jd02_06.calc02_06;
/*Вариант C. Доработайте программу так, чтобы:
На основе паттерна builder формировался текстовый отчет об операциях в учебном проекте.
 В состав отчета должны входить:
•заголовок отчета;
•время запуска и завершения работы пакета;
•введенные операции и результаты их выполнения.
Спроектируйте и реализуйте два варианта отчета:
•краткий (например: даты short, сообщения об ошибках содержат только тип)
•полный (например: даты short, сообщения об ошибках детализированы)*/

public class Report {

    private String name = "";
    private String startTime = "";
    private String finishTime = "";
    private String operationsAndResults = "";

    public void setName(String name) {
        this.name = name;
    }

    void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    void setOperationsAndResults(String operationsAndResults) {
        this.operationsAndResults = operationsAndResults;
    }

    @Override
    public String toString() {
        return   name + '\n' +
                "start Time = " + startTime + '\n' +'\n'+
                "operations And Results = " + operationsAndResults + '\n' +
                "finish Time = " + finishTime;
    }
}
