package app.animales;


public class Pez extends Vertebrado{
    private int cantidadAletas;
    private boolean tieneEscamas;

    public void setCantidadAletas(int cantidadAletas){
        this.cantidadAletas = cantidadAletas;
    }

    public void setTieneEscamas(boolean tieneEscamas){
        this.tieneEscamas = tieneEscamas;
    }

    public int getCantidadAletas(){
        return this.cantidadAletas;
    }

    public boolean getTieneEscamas(){
        return this.tieneEscamas;
    }

}
