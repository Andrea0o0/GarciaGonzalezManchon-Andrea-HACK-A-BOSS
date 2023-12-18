package practicalexercises;

import practicalexercises.models.Appliance;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] randomColor = new String[]{"White","Silver","Black"};
        for (int i=0; i < 3;i++){
            Random rand = new Random();
            Appliance appliance = new Appliance(i,"Brand" + (i+1),"Model" + (i+1) ,rand.nextInt(200),randomColor[i]);
            System.out.println("Appliance " + (i+1) + ": Brand -> " + appliance.getBrand() + ", Model -> " + appliance.getModel() + ", Consumption -> " + appliance.getConsumption());
        }
        Appliance applianceWithoutParameters = new Appliance();

        System.out.println("Brand of Appliance without parameters: " + applianceWithoutParameters.getBrand());
    }
}