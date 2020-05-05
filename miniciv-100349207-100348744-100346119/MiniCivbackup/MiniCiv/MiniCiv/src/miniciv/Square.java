/*
f * Universidad Carlos III de Madrid (UC3M)
 * Programación 2015-2016
 */
package miniciv;

/**
 * Uno de los cuadrantes en los que se divide el mapa del juego. Puede
 * representar tanto un edificio como un cierto terreno sin nada construido.
 * @author Planning and Learning Group (PLG)
 */
public class Square {
    // NOTA: Pueden crearse nuevas variables globales y métodos.
	int type;
	String nameIcon; 
	int level;
	boolean locked;
	
    /**
     * El constructor de la casilla. Recibe como parámetro un int para establecer
     * todas las caractecterísticas de la casilla según sea el tipo indicado.
     * @param idTypeSquare Identificador del tipo de casilla.
     */
    public Square(int idTypeSquare) {
        //System.out.println("NO IMPLEMENTADO Square: Square(int idTypeSquare)");
        
        	//NOTA: idTypeSquare tiene que tener estos valores según sea el tipo de casilla:        
            /* llanura = 0;
            Bosque = 1;
            Mar = 2;
            Montaña = 3;
            Selva = 4;
        
            Cuartel = 10;
            Colegio = 11;    
            Granja = 12;
            Mina = 13;
            Aserradero = 14;
            Barco = 15;
            Casa = 16;
            Mercado = 17;
            */
            //Para la parte optativa de crear edificios nuevos:
            //Personalizado1 = 101;
            //Personalizado2 = 102;
            //Personalizado3 = 103;
            //Personalizado4 = 104;
            //Personalizado5 = 105;
    	type = idTypeSquare; 
    	nameIcon = this.getNameIcon();
    	locked = true;
        level = 0;
    }   
    
    /**
     * Devuelve el identificador del tipo de esta casilla.
     * @return Identificador del tipo de casilla.
     */
    public int getType(){
         return type;
    }

    /**
     * Devuelve el nombre del fichero que tiene el icono asociado a este tipo de casilla para que pueda ser mostrado en la interfaz.
     * @return Nombre del fichero del icono de la casilla.
     */
    public  String getNameIcon(){
    		switch(type){
    		//************TERRENO***********//
    		case 0:
    			return "llanura.jpg";//LLANURA
			case 1: 
    			return "1435177891_46.png";//BOSQUE
			case 2:
				return "mar.jpg";//MAR
			case 3:
				return "1435177938_Mountain.png";//MONTANA
			case 4: 
				return "1435177985_palm_tree.png";//SELVA
			//***********EDIFICIOS**********//
			case 10: 
				return "1435961357_museum.png";//CUARTEL
			case 11:
				return "1435160648_graduationcap.png";//COLEGIO
			case 12:
				return "1435160771_zanahoria.png";//GRANJA
			case 13: 
				return "1435161063_diamond.png";//MINA	
			case 14:
				return "1435160535_Untitled-2-44.png";//ASSERADERO
			case 15:
				return "1435160565_sail_boat.png";//BARCO
			case 16:
				return "1435160375_home.png";//CASA
			case 17:
				return "1435160824_coins.png";//MERCADO
    		default: 
    			return "";
    		}
        
    }
    
    /**
     * Devuelve si esta casilla está bloqueada o no.
     * @return True si la casilla está bloqueada y false en caso contrario.
     */
    public boolean isLocked(){
    	if(locked == true){return true;}
    	else{return false;}
    }
    
    /**
     * Devuelve el nivel actual de esta casilla.
     * @return El nivel de la casilla.
     */
    public int getLevel(){
        //System.out.println("NO IMPLEMENTADO Square: int getLevel()");
        return level;
    }

    /**
     * Devuelve los puntos de golpe (vida) restantes de esta casilla.
     * @return Número real de 0 a 1 que indica los puntos de golpe (vida) restantes.
     */
    public float getHealth() {
        System.out.println("NO IMPLEMENTADO Square: float getHealth()");
        return 0;
    }
    
    /**
     * Establece el nivel de la casilla al nivel indicado, siempre que no exceda el máximo permitido.
     * @param level El nuevo nivel para la casilla.
     */
    public void setLevel(int level) {
        System.out.println("NO IMPLEMENTADO Square: void setLevel(int level)");
    }    
    
    /**
     * Devuelve todos los costes de construcción (o subida de nivel) de recursos y población para esta casilla, dependiendo del nivel indicado.
     * @param level El nivel de la casilla para el que se quieren obtener los costes.
     * @return Array de ints con los costes de construcción de cada recurso y la nueva población asentada y empleada.
     */
    public int[] getCostsBuild(int level){
        System.out.println("NO IMPLEMENTADO Square: int[] getCostsBuild(int level)");
        return new int[6];
    }
    
    /**
     * Devuelve todos los costes de reparación de recursos y población para esta casilla.
     * @return Array de ints con los costes de reparación de cada recurso y la nueva población asentada y empleada.
     */
    public int[] getCostsRepair() {
        System.out.println("NO IMPLEMENTADO Square: int[] getCostsRepair()");
        return new int[6];
    }
    
    /**
     * Devuelve todos los costes de mantenimiento de recursos por turno para esta casilla.
     * @return Array de ints que incluye los costes de mantenimiento de cada recurso por turno.
     */
    public int[] getCostsPerTurn() {
        System.out.println("NO IMPLEMENTADO Square: int[] getCostsPerTurn()");
        return new int[4];
    }
    
    /**
     * Devuelve todos los ingresos de recursos por turno para esta casilla.
     * @return Array de ints que incluye los ingresos de cada recurso por turno.
     */
    public int[] getProductionPerTurn() {
        System.out.println("NO IMPLEMENTADO Square: int[] getProductionPerTurn()");
        return new int[4];
    }
    
}
