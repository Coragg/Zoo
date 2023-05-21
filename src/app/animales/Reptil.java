package app.animales;

public class Reptil extends Vertebrado{
    private String tierraMarAmbos;

    public void setTierraMar(String typeReptil){
        this.tierraMarAmbos = typeReptil;
    }

    public String getTierraMarAmbos(){
        return this.tierraMarAmbos;
    }
}
