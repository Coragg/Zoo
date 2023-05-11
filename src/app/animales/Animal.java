package app.animales;

public class Animal {
    private String name, color;
    private double peso;

    // method set
    public void setName(String name){
        this.name = name;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    // method get
    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }

    public double getPeso(){
        return this.peso;
    }

}
