/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import static java.lang.Math.sin;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;



/**
 *
 * @author Komp
 */
@Named(value = "logicBean")
@RequestScoped
public class LogicBean {

    private int firstNumber;
    private int secondNumber;
    private List<Student> students;
    private LineChartModel lineModel;
    

    public LogicBean() {
        students = new ArrayList<>();
        students.add(new Student("Jacek", "Gulij", 3.85));
        students.add(new Student("Grzegorz", "Otworowski", 4.12));
        students.add(new Student("Adrian", "Brother", 4.21));
        students.add(new Student("Ewelina", "Bamberska", 4.44));
        students.add(new Student("Mateusz", "Bąk", 4.55));
        
        lineModel = new LineChartModel();
        LineChartSeries series = new LineChartSeries();
        series.setLabel("Sinus");
        
        for(double i=0; i<=360; i+=10){
            series.set(i,sin(Math.toRadians(i)));
        }
        
        lineModel.addSeries(series);
        lineModel.setTitle("Sinus Chart");
        lineModel.setZoom(true);
        Axis xAxis = lineModel.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(360);
        xAxis.setTickCount(37);
        lineModel.getAxis(AxisType.Y).setLabel("Values");
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int sum() {
        FacesContext context = FacesContext.getCurrentInstance();
        int sum = firstNumber + secondNumber;
        FacesMessage message = new FacesMessage(Integer.toString(firstNumber) + "+" + Integer.toString(secondNumber) + "=" + Integer.toString(sum));
        context.addMessage("sumMessage", message);
        return sum;
    }

    public Date currentDate() {
        Date date = new Date();
        return date;
    }

    /**
     * @return the firstNumber
     */
    public int getFirstNumber() {
        return firstNumber;
    }

    /**
     * @param firstNumber the firstNumber to set
     */
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * @return the secondNumber
     */
    public int getSecondNumber() {
        return secondNumber;
    }

    /**
     * @param secondNumber the secondNumber to set
     */
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * @return the lineModel
     */
    public LineChartModel getLineModel() {
        return lineModel;
    }

    /**
     * @param lineModel the lineModel to set
     */
    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }

}
