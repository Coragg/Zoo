package app.animales;


public class Mamifero extends  Vertebrado{
    private int cantidadPatas;
    
    public void setCantidadPatas(int cantidadPatas){
        this.cantidadPatas = cantidadPatas;
        }
    public int getCantidadPatas(){
        return this.cantidadPatas;
    }

}
