package view.temperaturePresenter;

import core.ModelFactory;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TemperatureModel;
import model.temp.Temperature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperaturePresenterViewModel {
    private StringProperty t0value, t1value, t2value, radiatorValue, warningLabel;
    private ModelFactory modelFactory;


    public TemperaturePresenterViewModel(ModelFactory modelFactory) {
        this.modelFactory=modelFactory;
        t0value = new SimpleStringProperty();
        t1value = new SimpleStringProperty();
        t2value = new SimpleStringProperty();
        radiatorValue = new SimpleStringProperty();
        warningLabel = new SimpleStringProperty();
        updateData();
       // temperatureModel.addPropertyChangeListener("Temperature added",this::propertyChangeIndoor);
     //   temperatureModel.addPropertyChangeListener("Outdoor Temperature added",this::propertyChangeOutdoor);

    }

    public StringProperty t0ValueProperty() {
        return t0value;
    }

    public StringProperty t1ValueProperty() {
        return t1value;
    }

    public StringProperty t2ValueProperty() {
        return t2value;
    }

    public StringProperty radiatorValueProperty() {
        return radiatorValue;
    }

    public StringProperty warningLabelProperty() {
        return warningLabel;
    }


    public void updateData() {
        Temperature t1 = modelFactory.getTemperatureModel().getLastInsertedTemperature("t1");
        if (t1 != null) {
            Platform.runLater(() -> t1value.set(t1.getValue()+""));
        } else {
            Platform.runLater(() -> t1value.set("No data"));
        }
        Temperature t2 = modelFactory.getTemperatureModel().getLastInsertedTemperature("t2");
        if (t2 != null) {
            Platform.runLater(() -> t2value.set(t2.getValue()+""));
        } else {
            Platform.runLater(() -> t2value.set("No data"));
        }
        Temperature t0 =modelFactory.getTemperatureModel().getLastAddedOutdoorTemperature();

        if (t0 !=null){
            Platform.runLater(()->t0value.set(t0.getValue()+""));
        }
        else{
            Platform.runLater(()->t0value.set("No data"));
        }
    }


   /* public void propertyChangeIndoor(PropertyChangeEvent evt) {
        Temperature temperature = (Temperature) evt.getNewValue();
        if (temperature.getId().equals("t1"))
        {
            Platform.runLater(() -> t1value.set(temperature.getValue()+""));
        }
        else if (temperature.getId().equals("t2"))
        {
            Platform.runLater(() -> t2value.set(temperature.getValue()+""));
        }
        else {
            Platform.runLater(() -> t1value.set("No data"));
            Platform.runLater(() -> t2value.set("No data"));
        }
    }
    public void propertyChangeOutdoor(PropertyChangeEvent evt){
        Temperature temperature =(Temperature) evt.getNewValue();
        if (temperature.getId().equals("t0"))
        {
            Platform.runLater(() -> t0value.set(temperature.getValue()+""));
        }
        else {
            Platform.runLater(() -> t0value.set("No data"));
        }
    }*/
}
