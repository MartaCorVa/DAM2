package cat.paucasesnoves.sppsp;

/**
 *
 * @author marta
 */
public class Exercici03 {

    public static void main(String[] args) {
        Double percentatgeIRPF = Double.parseDouble(args[0]);
        
        int horesTreballades = 45;
        double souHora = 8;
        double souBase = 40 * souHora;
        double souExtra = (horesTreballades - 40) * souHora * 2;
        double souTotal = horesTreballades * souHora;
        double souBrut = souBase + souExtra;
               
        double irpf = (souBrut * percentatgeIRPF) / 100;
        double souNet = souBrut - irpf;
        
        if (horesTreballades < 40) {
            System.out.println("El treballador cobra: " + souTotal + "€.");
        } else {
            System.out.println("El treballador cobra: " + souBase + "€ base i " + souExtra
                    + "€ d'hores extra. Total a cobrar: " + (souBase + souExtra) + "€.");

        }
        
        System.out.println("L'IRPF és: " + irpf + "€. El salari net és: " + souNet + "€.");
        System.out.println("Sou mensual: " + souNet * 4 + "€.");
    }
    
}
