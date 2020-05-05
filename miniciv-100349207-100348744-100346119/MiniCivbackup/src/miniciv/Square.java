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
	/*************MIS VARIBLES*************/
	int type;
	String nameIcon; 
	int level;
	boolean locked;
	float health = 1;
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
    			return "plain.png";//LLANURA
			case 1: 
    			return "tree.png";//BOSQUE
			case 2:
				return "sea.png";//MAR
			case 3:
				return "montana.jpeg";//MONTANA
			case 4: 
				return "palmera.png";//SELVA
			//***********EDIFICIOS**********//
			case 10: 
				return "cuartel.png";//CUARTEL
			case 11:
				return "colegio.png";//COLEGIO
			case 12:
				return "granja.jpg";//GRANJA
			case 13: 
				return "mina.jpeg";//MINA	
			case 14:
				return "aserradero.png";//ASSERADERO
			case 15:
				return "barquito.png";//BARCO
			case 16:
				return "casa.png";//CASA
			case 17:
				return "mercado.jpg";//MERCADO
			case 101: 
				return "coloso.png";//Coloso de rodas
			case 102:
				return "campnou.png";//Camp Nou
			case 103:
				return "caraprogramador.png";
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
        //System.out.println("NO IMPLEMENTADO Square: float getHealth()");
        return health;
    }
    
    /**
     * Establece el nivel de la casilla al nivel indicado, siempre que no exceda el máximo permitido.
     * @param level El nuevo nivel para la casilla.
     */
    public void setLevel(int level) {
        //System.out.println("NO IMPLEMENTADO Square: void setLevel(int level)");
        this.level = level;
    }    
    
    /**
     * Devuelve todos los costes de construcción (o subida de nivel) de recursos y población para esta casilla, dependiendo del nivel indicado.
     * @param level El nivel de la casilla para el que se quieren obtener los costes.
     * @return Array de ints con los costes de construcción de cada recurso y la nueva población asentada y empleada.
     */
    public int[] getCostsBuild(int level){
    	level = 0; 
      // System.out.println("NO IMPLEMENTADO Square: int[] getCostsBuild(int level)");
      //Casa
      int[] ConstrCasa = new int [6];
      ConstrCasa[Constants.RS_GOLD] = 100;
      ConstrCasa[Constants.RS_WOOD] = 300;
      ConstrCasa[Constants.RS_POPULATION_NEEDED] = 30;
    //Mercado
      int[] ConstrMercado = new int [6];
      ConstrMercado[Constants.RS_GOLD] = 100;
      ConstrMercado[Constants.RS_WOOD] = 200;
    //Barco
      int[] ConstrBarco = new int [6];
      ConstrBarco[Constants.RS_GOLD] = 200;
      ConstrBarco[Constants.RS_WOOD] = 400;
    //Mina
      int[] ConstrMina = new int [6];
      ConstrMina[Constants.RS_GOLD] = 100;
      ConstrMina[Constants.RS_WOOD] = 200;
    //Aserradero
      int[] ConstrAserradero = new int [6];
      ConstrAserradero[Constants.RS_GOLD] = 100;
      ConstrAserradero[Constants.RS_WOOD] = 200;
    //Granja
      int[] ConstrGranja = new int [6];
      ConstrGranja[Constants.RS_GOLD] = 150;
      ConstrGranja[Constants.RS_WOOD] = 300;
    //Escuela
      int[] ConstrEscuela = new int [6];
      ConstrEscuela[Constants.RS_GOLD] = 1500;
      ConstrEscuela[Constants.RS_WOOD] = 1500;
    //Cuartel
      int[] ConstrCuartel = new int [6];
      ConstrCuartel[Constants.RS_GOLD] = 3000;
      ConstrCuartel[Constants.RS_WOOD] = 3000;
    //Coloso
      int[] ConstrColoso = new int [6];
      ConstrColoso[Constants.RS_GOLD] = 7000;
      ConstrColoso[Constants.RS_WOOD] = 7000;
      ConstrColoso[Constants.RS_CULTURE] = 10000;
    //Nou Camp
      int[] ConstrNouCamp = new int [6];
      ConstrNouCamp[Constants.RS_GOLD] = 100;
      ConstrNouCamp[Constants.RS_WOOD] = 300;
      
      
       switch(type){
       case Constants.CO_BARRACKS:
    	   return ConstrCuartel;
       case Constants.CO_BOAT:
    	   return ConstrBarco;
       case Constants.CO_FARM: 
    	   return ConstrGranja;
       case Constants.CO_HOUSE:
    	   return ConstrCasa;
       case Constants.CO_MARKET:
    	   return ConstrMercado;
       case Constants.CO_MINE:
    	   return ConstrMina;
       case Constants.CO_SAWMILL:
    	   return ConstrAserradero;
       case Constants.CO_SCHOOL:
    	   return ConstrEscuela;
       case Constants.CO_CUSTOM_1:
    	   return ConstrColoso;
       case Constants.CO_CUSTOM_2:
    	   return ConstrNouCamp;
     
       }
        return new int [6];
        
    }
    
    /**
     * Devuelve todos los costes de reparación de recursos y población para esta casilla.
     * @return Array de ints con los costes de reparación de cada recurso y la nueva población asentada y empleada.
     */
    public int[] getCostsRepair() {
        //System.out.println("NO IMPLEMENTADO Square: int[] getCostsRepair()");
        return new int [6];
    }
    
    /**
     * Devuelve todos los costes de mantenimiento de recursos por turno para esta casilla.
     * @return Array de ints que incluye los costes de mantenimiento de cada recurso por turno.
     */
    public int[] getCostsPerTurn() {
        //System.out.println("NO IMPLEMENTADO Square: int[] getCostsPerTurn()");
        //Costes BARCO
        int [] costesBarco = new int [4];
        costesBarco[Constants.RS_GOLD] = -8;
        costesBarco[Constants.RS_WOOD] = -8;
        //Costes GRANJA
        int [] costesGranja = new int [4];
        costesGranja[Constants.RS_GOLD] = -5;
        costesGranja[Constants.RS_WOOD] = -3;
        //Costes CASA
        int [] costesCasa = new int [4];
        costesCasa[Constants.RS_GOLD] = -4;
        costesCasa[Constants.RS_WOOD] = -8;
        costesCasa[Constants.RS_FOOD] = -15;
        //Costes MERCADO
        int [] costesMercado = new int [4];
        costesMercado[Constants.RS_FOOD] = -60;
        //Costes MINA
        int [] costesMina = new int [4];
        costesMina[Constants.RS_FOOD] = -10;
        costesMina[Constants.RS_WOOD] = -2;
        //Costes ASERRADERO
        int[] costesAserradero = new int [4];
        costesAserradero[Constants.RS_GOLD] = -2;
        costesAserradero[Constants.RS_FOOD] = -10;
        //Costes ESCUELA
        int [] costesEscuela = new int [4];
        costesEscuela[Constants.RS_GOLD] = -15;
        costesEscuela[Constants.RS_FOOD] = -60;
        costesEscuela[Constants.RS_WOOD] = -8;
        //Costes CUARTEL
       int [] costesCuartel = new int [4];
       costesCuartel[Constants.RS_GOLD] = -50;
       costesCuartel[Constants.RS_WOOD] = -30;
       costesCuartel[Constants.RS_FOOD] = -60;
        //Costes NouCamp
       int [] costesNouCamp = new int [4];
       costesNouCamp[Constants.RS_GOLD] = -200;
       costesNouCamp[Constants.RS_WOOD] = -800;
       switch(type){
       	case Constants.CO_BOAT:
       		return costesBarco;
       	case Constants.CO_FARM:
       		return costesGranja;
		case Constants.CO_HOUSE:
			return costesCasa;
		case Constants.CO_MARKET:
			return costesMercado;
		case Constants.CO_MINE:
			return costesMina;
        case Constants.CO_SAWMILL:
        	return costesAserradero;
        case Constants.CO_SCHOOL:
        	return costesEscuela;
        case Constants.CO_BARRACKS:
        	return costesCuartel;
        case Constants.CO_CUSTOM_2:
        	return costesNouCamp;
        default: return new int [4];
       }
    }
    
    /**
     * Devuelve todos los ingresos de recursos por turno para esta casilla.
     * @return Array de ints que incluye los ingresos de cada recurso por turno.
     */
    public int[] getProductionPerTurn() {
       // System.out.println("NO IMPLEMENTADO Square: int[] getProductionPerTurn()");
        //Produccion BARCO
        int [] produccionBarco = new int [4];
        produccionBarco[Constants.RS_FOOD] = 100;
        //Produccion GRANJA
        int [] produccionGranja = new int [4];
        produccionGranja[Constants.RS_FOOD] = 50;
        //Produccion CASA
        int [] produccionCasa = new int [4];
        //Produccion MERCADO
        int [] produccionMercado = new int [4];
        produccionMercado[Constants.RS_WOOD] = 15;
        produccionMercado[Constants.RS_GOLD] = 15;
        //Produccion MINA
        int [] produccionMina = new int [4];
        produccionMina[Constants.RS_GOLD] = 80;
        //Produccion ASERRADERO
        int [] produccionAserradero = new int [4];
        produccionAserradero[Constants.RS_WOOD] = 80;
        //produccion ESCUELA
        int [] produccionEscuela = new int [4];
        produccionEscuela[Constants.RS_CULTURE] = 80;
        //produccion CUARTEL
        int [] produccionCuartel = new int [4];
        
        //Aqui mediante el tipo de cada construccion se devolveran unos beneficios;
        switch(type){
        case Constants.CO_BOAT:
        	return produccionBarco;
		case Constants.CO_FARM:
        	return produccionGranja;
		case Constants.CO_HOUSE:
        	return produccionCasa;
		case Constants.CO_MARKET:
			return produccionMercado;
		case Constants.CO_MINE:
			return produccionMina;
        case Constants.CO_SAWMILL:
        	return produccionAserradero;
        case Constants.CO_SCHOOL:
        	return produccionEscuela;
        case Constants.CO_BARRACKS:
        	return produccionCuartel;
        default: return new int [4];
        }
    }
    
}
