/*
 * Universidad Carlos III de Madrid (UC3M)
 * Programacion 2015-2016
 */
package miniciv;

/**
 * Uno de los jugadores que están jugando la partida.
 * @author Planning and Learning Group (PLG)
 */
public class Player {  
/************MIS CONSTANTES******************/
	public static final int MADERA = 0;
	public static final int ORO = 1;
	public static final int COMIDA = 2;
	public static final int CULTURA = 3;
	public static final int POBLACION_ASENTADA = 4;
	public static final int POBLACION_NECESARIA = 5;
/****************************************/
    // NOTA: Pueden crearse nuevas variables globales y métodos.
/************MIS VARIABLES***************/
	int[] resources = new int[6];
	int idPlayer = 0;
	int population;
/****************************************/
    /**
     * Constructor de la clase jugador.
     * @param id Identificador unívoco.
     */
    public Player(int id){
    	
    	idPlayer = id;
    	resources[MADERA] = 1000;
    	resources[ORO] = 500;
    	resources[COMIDA] = 500;
    	resources[CULTURA] = 1000;
    	resources[POBLACION_ASENTADA] = 0;
    	resources[POBLACION_NECESARIA] = 0;
    }
    
    /**
     * Devuelve los recursos almacenados por el jugador.
     * @return Array con todos los recursos almacenados por el jugador.
     */
    public int[] getResources(){
        /*
        NOTA: Cada recurso debe estar guardado en un cierto índice del array.
            Índice madera = 0
            Índice oro = 1
            Índice comida = 2;
            Índice cultura = 3;
        */
       
        return this.resources;
    }

    /**
     * Devuelve una de las ciudades fundadas por el jugador.
     * @param idCity Identificador unívoco de la ciudad que se quiere obtener.
     * @return La ciudad con el identificador indicado.
     */
    public City getCity(int idCity){
        System.out.println("NO IMPLEMENTADO Player: City getCity(int idCity)");
        return null;
    }
    
    /**
     * Devuelve la población total asentada en las construcciones de todas las ciudades fundadas por el jugador.
     * @return La población total asentada del jugador.
     */
    public int getPopulationSettled(){
        System.out.println("NO IMPLEMENTADO Player: int getPopulationSettled()");
        return population;
    }

    /**
     * Devuelve la población total necesaria para que funcionen todos las construcciones de todas las ciudades fundadas por el jugador.
     * @return La población necesaria total del jugador.
     */
    public int getPopulationNeeded(){
        System.out.println("NO IMPLEMENTADO Player: int getPopulationNeeded()");
        return 0;
    }
    
    /**
     * Devuelve la población total disponible del jugador, que es la diferencia entre la población total asentada y la población total necesaria.
     * @return La población total disponible del jugador.
     */
    public int getPopulationAvailable(){
        System.out.println("NO IMPLEMENTADO Player: int getPopulationAvailable()");
        return 0;
    }

}
