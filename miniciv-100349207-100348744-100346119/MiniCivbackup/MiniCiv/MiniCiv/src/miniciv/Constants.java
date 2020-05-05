/*
 * Universidad Carlos III de Madrid (UC3M)
 * Programacion 2015-2016
 */
package miniciv;

/**
 * @author Planning and Learning Group (PLG)
 */
public class Constants {
    //NOTA: No modificar esta clase.
  
    public static final int MAP_WIDTH = 10;
    public static final int MAP_HEIGHT = 10;
    
    public static final int NUM_RESOURCES = 4;
    public static final int NUM_COSTS = 2 + NUM_RESOURCES;
    public static final int NUM_LEVELS = 3;
    
    public static final int RS_WOOD = 0;
    public static final int RS_GOLD = 1;
    public static final int RS_FOOD = 2;
    public static final int RS_CULTURE = 3;
    public static final int RS_POPULATION_SETTLED = 4;
    public static final int RS_POPULATION_NEEDED = 5;
        
    public static final int TE_PLAIN = 0;
    public static final int TE_FOREST = 1;
    public static final int TE_WATER = 2;
    public static final int TE_MOUNTAIN = 3;
    public static final int TE_JUNGLE = 4;
    
    public static final int CO_BARRACKS = 10;
    public static final int CO_SCHOOL = 11;    
    public static final int CO_FARM = 12;
    public static final int CO_MINE = 13;
    public static final int CO_SAWMILL = 14;
    public static final int CO_BOAT = 15;
    public static final int CO_HOUSE = 16;
    public static final int CO_MARKET = 17;
    public static final int CO_CUSTOM_1 = 101;
    public static final int CO_CUSTOM_2 = 102;
    public static final int CO_CUSTOM_3 = 104;
    public static final int CO_CUSTOM_4 = 105;
    public static final int CO_CUSTOM_5 = 106;
    
    public static final float POPULATION_PROPORTION = 0.7f;
    
    public static final float PROBABILITY_ATTACK = 0.5f;    
    public static final float PROBABILITY_DAMAGE_CONSTRUCTION = 0.5f;
    public static final float PROPORTION_DAMAGE_MAX_CONSTRUCTION = 0.4f;
    
    public static final int MINIMUM_RESOURCES_ALLOWED = -100;
    
    public static final int COST_EXPAND_SQUARE = 1500; 
    public static final int PIXELS_EDGE_SQUARE = 50;
    
    public static final int NUM_PLAYERS = 1;
    public static final int MAX_PLAYER_CITIES = 1;
    
    public static final float MULT_COST_REPAIR = 0.5f;
    public static final float MULT_REDUCTION_POPULATION = 0.6f;    
    
    public static final float MULT_LEVEL_INCOME = 0.6f;
    public static final float MULT_LEVEL_COSTS_MAINTENANCE = 0.6f;
    public static final float MULT_LEVEL_COSTS_BUILDING = 0.4f; 
    public static final float MULT_LEVEL_POPULATION = 0.6f; 
    
    public static final int END_CONTINUE = 0;
    public static final int END_POPULATION = 1;
    public static final int END_TURNS = 2;
    public static final int END_WIN = 3;
    public static final int END_GOLD = 11;
    public static final int END_WOOD = 12;
    public static final int END_FOOD = 13;
    public static final int END_GLOBAL_DOMINATION = 14;
    
}
