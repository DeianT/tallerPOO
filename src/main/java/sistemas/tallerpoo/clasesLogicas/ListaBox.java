package sistemas.tallerpoo.clasesLogicas;

/**
 *
 * @author Deian
 */
public class ListaBox {
    private static final int CANTIDAD = 10;
    private static final Box[] boxes = new Box[CANTIDAD];
    private static boolean primeraInstancia = true;

    public ListaBox() {
        if(primeraInstancia){
            primeraInstancia = false;
            for (int i = 0; i < boxes.length; i++) {
                boxes[i] = new Box(i + 1, null, null, false);
            }
        }
    }
    
    public Box obtenerBoxDesocupado() throws Exception{
        for(Box b: boxes){
            if(!b.isOcupado()){
                return b;
            }
        }
        throw new Exception("No hay boxes disponibles");
    }

    public Box[] getBoxes() {
        return boxes;
    }

    public Box obtenerBox(int numero) {
        try{
            return boxes[numero - 1];
        }
        catch(IndexOutOfBoundsException e){
            return null;
        }
    }
    
    public int cantidad(){
        return CANTIDAD;
    }
}