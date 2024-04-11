/**
 * Exemple sur les interfaces multiples
 */

package corriges.cours;

// Interface Radio
interface IRadio {
    void setVolume(Integer volume);
    
    // Methode default nommee start
    default void sonnerie() {
        System.out.println("Sonne comme une radio.");
    }
}

// Interface reveil
interface IReveil {
    void setHeure(String heure);
    
    // Methode default nommee start
    default void sonnerie() {
        System.out.println("Sonne comme une reveil.");
    }
}

// Classe RadioReveil implementant les interfaces
class RadioReveil implements IRadio, IReveil {
    // Proprietes
    // radio = true, reveil = false
    private Boolean typeAppareil;
    private String heure;
    private Integer volume;
    
    // Constructeur
    public RadioReveil(Boolean typeAppareil) {
        this.typeAppareil = typeAppareil;
        this.heure = "00h00m00s";
        this.volume = 0;
    }
    
    // Methode avec choix de la methode default a utilisee
    @Override
    public void sonnerie() {
        if (this.typeAppareil) {
            IRadio.super.sonnerie();
        }
        else {
            IReveil.super.sonnerie();
        }
    }
    
    // Getters
    public String getTypeAppareil() {
        return (this.typeAppareil) ? "Radio" : "Reveil";
    }

    public String getHeure() {
        return this.heure;
    }

    public Integer getVolume() {
        return this.volume;
    }
    
    // Setters
    @Override
    public void setHeure(String heure) {
        this.heure = heure;
    }

    @Override
    public void setVolume(Integer volume) {
        this.volume = volume;
    }    
}

// Classe principale
public class InterfacesMultiples {
    public static void main(String[] args) {
        Boolean radioReveil = false;
        // radio = true, reveil = false
        
        RadioReveil rr = new RadioReveil(radioReveil);
        System.out.println("Type : " + rr.getTypeAppareil());
        System.out.println("Heure : " + rr.getHeure());
        System.out.println("Volume : " + rr.getVolume());
        
        rr.sonnerie();
        
        System.out.println();
        
        rr.setHeure("12h10m20s");
        rr.setVolume(100);
        
        System.out.println("Type : " + rr.getTypeAppareil());
        System.out.println("Heure : " + rr.getHeure());
        System.out.println("Volume : " + rr.getVolume());

        rr.sonnerie();
    }
}