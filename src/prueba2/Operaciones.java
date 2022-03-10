/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba2;

/**
 *
 * @author S1820
 */
public class Operaciones {

    private double Velocidad;
    private double angulo;
    private double masa;
    private double altura;
    private double viento;
    private double tiempo;
    private double gravedad;
    private double Vx, Vy;

    public double getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(double Velocidad) {
        this.Velocidad = Velocidad;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getViento() {
        return viento;
    }

    public void setViento(double viento) {
        this.viento = viento;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public double getGravedad() {
        return gravedad;
    }

    public void setGravedad(double gravedad) {
        this.gravedad = gravedad;
    }

    // OPERACIONES
    public String VelocidadInstaResTiempo() {
        double cosTheta = Math.cos(Math.toRadians(getAngulo()));
        double sinTheta = Math.sin(Math.toRadians(getAngulo()));
        if(getViento()==0)
        {
              this.Vx = (getVelocidad() * cosTheta);
        }
        else
        {
            this.Vx = (getVelocidad()*cosTheta)+(getViento()/getMasa())*getTiempo();
        }
      
        this.Vy = getVelocidad() * sinTheta - getGravedad() * getTiempo();
        String vector = Vx + " " + Vy;
        return vector;
    }

    public double DistanciaT() {

        double cosTheta = Math.cos(Math.toRadians(getAngulo()));
        double x = getVelocidad() * cosTheta * getTiempo();
        return x;
    }

    public double AnguloInsta() {

        double Ains = this.Vy / this.Vx;
        return Ains;
    }

    public double DistanciaMax() {
        double cosTheta = Math.cos(Math.toRadians(getAngulo()));
        double sinTheta = Math.sin(Math.toRadians(getAngulo()));
        double xmax = ((getVelocidad() * cosTheta) * (2 * getVelocidad() * sinTheta)) / getGravedad();
        return xmax;
    }

    public double AlturaInstan() {
        double sinTheta = Math.sin(Math.toRadians(getAngulo()));
        double yins = (getVelocidad() * sinTheta) * getTiempo() - (0.5 * getGravedad() * getTiempo() * getTiempo());
        return yins;
    }

    public double AlturaMax() {
        double sinTheta = Math.sin(Math.toRadians(getAngulo()));
        double ymax = ((getVelocidad() * getVelocidad()) * sinTheta * sinTheta) / (2 * getGravedad());
        return ymax;
    }
    public double EnergiaCineInsta()
    {
        double Energacine=0.5*getMasa()*getVelocidad()*getVelocidad();
        return Energacine;
    }
    public double EnergiaPotencial()
    {
        double energiaP=getMasa()*getGravedad()*AlturaInstan();
        return energiaP;
    }
    public double trabajoViento()
    {
        double Htotal = AlturaMax();
        double Wroz = -(getMasa()*getGravedad()*(getAltura()+AlturaMax()))-(0.5*getMasa()*getVelocidad()*getVelocidad())+(getMasa()*getVelocidad()*getAltura()+0.5*getMasa()*getVelocidad()*getVelocidad());
        return Wroz;
    }
    public double EnergiaMecanica()
    {
        double energiaMe = 0.5*getMasa()*(getVelocidad()*getVelocidad())+getMasa()*getGravedad()*getAltura();
        return energiaMe;
    }
}
