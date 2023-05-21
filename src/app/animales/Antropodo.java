package app.animales;

public class Antropodo extends Invertebrado{
    private int cantidadParesPatas;
    private boolean antenas;

    public void setCantidadParesPatas(int cantidadParesPatas){
        this.cantidadParesPatas = cantidadParesPatas;
    }

    public void setAntenas(boolean antenas){
        this.antenas = antenas;
    }

    public int getCantidadParesPatas(){
        return this.cantidadParesPatas;
    }

    public boolean getAntenas(){
        return this.antenas;
    }


}
