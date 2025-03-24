


package GA;

import java.util.ArrayList;
import java.util.Random;

import javax.print.Doc;

import Logger.MyLogger;
import MCTs.MCTs;
import ConnectX.Algorithm;

public class GeneticAlgorithm {

    ArrayList<Algorithm> population;
    ArrayList<Integer> fitness;
    Random random;

    MyLogger logger;
    String option;
    ArrayList<Double> parameters;
    int populationSize;
    int iterations;
    int numPlays;
    int numberOfStrategies;
    int gameMode;
    int log; 
    int debug;


    public GeneticAlgorithm(MyLogger logger, String option, ArrayList<Double> parameters, int populationSize, int iterations, int numPlays, int numberOfStrategies, int gameMode, int log, int debug){
        this.logger = logger;
        this.option = option;
        this.parameters = parameters;
        this.populationSize = populationSize;
        this.iterations = iterations;
        this.numPlays = numPlays;
        this.numberOfStrategies = numberOfStrategies;
        this.gameMode = gameMode;
        this.log = log;
        this.debug = debug;
        population = new ArrayList<>();
        fitness = new ArrayList<>();
    }

    public int[] convertIntToBinary(int number){
        int binaryValue[] = {0,0,0,0,0,0,0,0};
        if(number < 0){
            binaryValue[0] = 1;
            number = -number;
        }
        for(int i = 0; i < binaryValue.length; i++){
            // System.out.println("LOL " + i + " NUM " + (number & (1 << i)));
            if((number & (1 << i)) == 1 << i){
                binaryValue[Math.abs(i - 7)] = 1;
            }
        }
        return binaryValue;
        // int binaryValue[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        // for(int i = 0; i < binaryValue.length; i++){
        //     if((number & (1 << i)) == 1 << i){
        //         binaryValue[Math.abs(i - 15)] = 1;
        //     }
        // }
        // return binaryValue;
    }

    public double convertBinaryToInt(int strategy[]){
        // double strategyValue = 0;
        // for(int i = 0; i < strategy.length; i++){
        //     if(strategy[i] == 1){
        //         strategyValue = strategyValue + (double)Math.pow(2, (Math.abs(i - 15)));
        //     }
        // }
        // return strategyValue
        // double strategyValue = 0;
        // for(int i = 0; i < strategy.length; i++){
        //     if(strategy[i] == 1){
        //         strategyValue = strategyValue + (double)Math.pow(2, (Math.abs(i - 7)));
        //     }
        // }
        // return strategyValue;
        double strategyValue = 0;
        for(int i = 1; i < strategy.length; i++){
            if(strategy[i] == 1){
                strategyValue = strategyValue + (double)Math.pow(2, (Math.abs(i - 7)));
            }
        }
        if(strategy[0] == 1){
            strategyValue = -strategyValue;
        }
        return strategyValue;
    }

    public void generateRandomPopulation(){
        random = new Random();
        for(int i = 0; i < populationSize; i++){
            ArrayList<Double> strategyList = new ArrayList<>(parameters);
            for(int j = 0; j < numberOfStrategies; j++){
                strategyList.add((double)(127 - random.nextInt(254)));
                // if(j == 4){
                //     strategyList.add((double)80);
                // }
                // else{
                //     strategyList.add((double)-70);
                // }
                // strategyList.add((double)(3 - random.nextInt(6)));
            }
            population.add(new Algorithm(option, strategyList));
        }
    }

    public void sortPopulation(){
        for(int i = 0; i < populationSize; i++){
            int maxIndex = i;
            for(int j = i + 1; j < populationSize; j++){
                if(fitness.get(j) > fitness.get(maxIndex)){
                    maxIndex = j;
                }
            }
            Algorithm tempChromosome = population.get(maxIndex);
            int tempFitness = fitness.get(maxIndex);
            fitness.set(maxIndex, fitness.get(i));
            population.set(maxIndex, population.get(i));
            fitness.set(i, tempFitness);
            population.set(i, tempChromosome);
        }
    }

    public int rouletteWheelSelection(ArrayList<Double> weights){
        ArrayList<Double> accumulation = new ArrayList<>();
        accumulation.add(weights.get(0));
        for (int i = 1; i < weights.size(); i++) {
            accumulation.add(accumulation.get(i - 1) + weights.get(i));
        }
        double p = Math.random();
        int chosenIndex = -1;
        for (int index = 0; index < accumulation.size(); index++) {
            if (accumulation.get(index) > p) {
                chosenIndex = index;
                break;
            }
        }
        if (chosenIndex == -1) {
            chosenIndex = 0;
        }
        return chosenIndex;
    }

    public void uniformCrossover(ArrayList<Double> tempChromosome1List, ArrayList<Double> tempChromosome2List, double swappingProb){
        random = new Random();
        for(int i = 0; i < tempChromosome1List.size(); i++){
            int[] chromosome1Value = convertIntToBinary(tempChromosome1List.get(i).intValue());
            int[] chromosome2Value = convertIntToBinary(tempChromosome2List.get(i).intValue());
            for(int j = 0; j < chromosome1Value.length; j++){
                double crossover = random.nextDouble();

                if(crossover > swappingProb){
                    int temp = chromosome1Value[j];
                    chromosome1Value[j] = chromosome2Value[j];
                    chromosome2Value[j] = temp;
                }
            }
            tempChromosome1List.set(i, convertBinaryToInt(chromosome1Value));
            tempChromosome2List.set(i, convertBinaryToInt(chromosome2Value));
        }
    }

    public void bitFlipMutation(ArrayList<Double> tempChromosomeList){
        random = new Random();
        for(int i = 0; i < tempChromosomeList.size(); i++){
            int[] chromosomeValue = convertIntToBinary(tempChromosomeList.get(i).intValue());
            int index = random.nextInt(chromosomeValue.length);
            chromosomeValue[index] = -chromosomeValue[index] + 1;
            tempChromosomeList.set(i, convertBinaryToInt(chromosomeValue));
        }
    }
    // public ArrayList<Integer> convertDoubleToInt(ArrayList<Integer> doubleList){
    //     ArrayList<Integer> intList = new ArrayList<>();
    //     for (Double d : doubleList) {
    //         intList.add(d.intValue()); // Convert Double to Integer
    //     }
    //     return intList;
    // }
    public ArrayList<Double> copyArrayList(ArrayList<Integer> tempBoard){
        ArrayList<Double> newArrayList = new ArrayList<>();
        for(int i = 0; i < tempBoard.size(); i++){
            newArrayList.add((double)tempBoard.get(i));
        }
        return newArrayList;
    }

    public void runGenetic(){
        generateRandomPopulation();
        ArrayList<Algorithm> newPopulation = new ArrayList<>();
        for(int i = 0; i < population.size() * 0.2; i++){
            newPopulation.add(population.get(i));
        }
        int totalFitness = 0;
        for(int k = 0; k < iterations; k++){
            // System.out.println(")))))))))))))");
            totalFitness = 0;
            fitness = new ArrayList<>();
            // System.out.println(")))))))))))))");
            // CALCULATE FITNESS
            for(int i = 0; i < populationSize; i++){
                FitnessFunction fitnessFunction = new FitnessFunction(logger, newPopulation, population.get(i), numPlays, gameMode, log, debug);
                // System.out.println(")))))))))))))");
                fitness.add(fitnessFunction.runFitness());
                totalFitness = totalFitness + fitness.get(i);
            }
            // System.out.println(")))))))))))))");
            sortPopulation();
            newPopulation = new ArrayList<>();
            // System.out.println(")))))))))))))");
            ArrayList<Integer> newFitness = new ArrayList<>();
            // 0.25
            for(int i = 0; i < population.size() * 0.2; i++){
                newPopulation.add(population.get(i));
                newFitness.add(fitness.get(i));
                logger.addInfo("Number: " + i + "   Fitness:  "  + fitness.get(i) + "  StrategyList 1 " + newPopulation.get(i).strategies);
            }
            // System.out.println(")))))))))))))");
            logger.addInfo("%%%%%%%%%%%%%%%%%%%%%%%   <" + k + ">  %%%%%%%%%%%%%%%%%%%%%");
            // for(int i = 0; i < fitness.size(); i++){
            //     System.out.printf("Number: " + i);
            //     System.out.printf("   Fitness:  "  + fitness.get(i));
            //     for(int j = 0; j < numberOfStrategies; j++){
            //         System.out.printf("   Strategy" + j + ":  " + population.get(i).strategies.get(j));
            //     }
            //     System.out.printf("\r\n");
            //     logger.addInfo("Number: " + i + "   Fitness:  "  + fitness.get(i) + "  StrategyList " + population.get(i));
            // }
            // System.out.println("--------------------------------------------");
            while(newPopulation.size() < population.size()){
                // System.out.println(")))))))))))))");
                ArrayList<Double> weights = new ArrayList<>();
                for(int i = 0; i < populationSize; i++){
                    double weightValue = ((double)fitness.get(i) / totalFitness);
                    weights.add(weightValue);
                }
                int choice1 = rouletteWheelSelection(weights);
                int choice2 = rouletteWheelSelection(weights);
                ArrayList<Double> tempChromosome1StrategyList = copyArrayList(population.get(choice1).strategies);
                ArrayList<Double> tempChromosome2StrategyList = copyArrayList(population.get(choice2).strategies);
                if(Math.random() < 0.4){
                    double swappingProb = 0.5;
                    uniformCrossover(tempChromosome1StrategyList, tempChromosome2StrategyList, swappingProb);
                }
                if(Math.random() < 0.2){
                    bitFlipMutation(tempChromosome1StrategyList);
                }
                if(Math.random() < 0.2){
                    bitFlipMutation(tempChromosome2StrategyList);
                }
                ArrayList<Double> newParameters1 = new ArrayList<>(parameters);
                newParameters1.addAll(tempChromosome1StrategyList);
                ArrayList<Double> newParameters2 = new ArrayList<>(parameters);
                newParameters2.addAll(tempChromosome2StrategyList);
                newPopulation.add(new Algorithm(option, newParameters1));
                if(newPopulation.size() < population.size()){
                    newPopulation.add(new Algorithm(option,newParameters2));
                }
            }
            population = new ArrayList<>();
            for(int i = 0; i < populationSize; i++){
                population.add(newPopulation.get(i));
            }
        }
        totalFitness = 0;
        fitness = new ArrayList<>();
        for(int i = 0; i < populationSize; i++){
            FitnessFunction fitnessFunction = new FitnessFunction(logger, population, population.get(i), numPlays, gameMode, log, debug);
            fitness.add(fitnessFunction.runFitness());
            totalFitness = totalFitness + fitness.get(i);
        }
        sortPopulation();
    }
}












// package GA;

// import java.util.ArrayList;
// import java.util.Random;
// import Logger.MyLogger;
// import MCTs.*;
// import ConnectX.*;

// public class GeneticAlgorithm {
//     MyLogger logger;
//     int populationSize;
//     int debug;
//     int iterations;
//     ArrayList<Object> populationMCTs;
//     ArrayList<Integer> fitnessList;
//     Random random;
//     int numberOfStrategies;
//     int totalFitness;
//     int gameMode;
//     int numPlays;
//     int backPropagations;
//     int log;
//     public GeneticAlgorithm(MyLogger logger, int populationSize, int iterations, int numPlays, int backPropagations, int numberOfStrategies, int gameMode, int log, int debug){
//         this.logger = logger;
//         this.populationSize = populationSize;
//         this.iterations = iterations;
//         this.gameMode = gameMode;
//         this.numberOfStrategies = numberOfStrategies;
//         this.numPlays = numPlays;
//         this.backPropagations = backPropagations;
//         this.log = log;
//         System.out.println("POPULATIONSIZE: " + populationSize);
//         System.out.println("ITERATION: " + iterations);
//         System.out.println("GAMEMODE: "+ gameMode);
//         population = new ArrayList<>();
//         fitnessList = new ArrayList<>();
//     }
    // public int[] convertIntToBinary(int number){
    //     int binaryValue[] = {0,0,0,0,0,0,0,0};
    //     for(int i = 0; i < binaryValue.length; i++){
    //         if((number & (1 << i)) == 1 << i){
    //             binaryValue[Math.abs(i - 7)] = 1;
    //         }
    //     }
    //     return binaryValue;
    // }

    // public int convertBinaryToInt(int strategy[]){
    //     int strategyValue = 0;
    //     for(int i = 0; i < strategy.length; i++){
    //         if(strategy[i] == 1){
    //             strategyValue = strategyValue + (int)Math.pow(2, (Math.abs(i - 7)));
    //         }
    //     }
    //     return strategyValue;
    // }
    // public void generateRandomPopulationMCTs(){
    //     random = new Random();
    //     for(int i = 0; i < populationSize; i++){
    //         population.add(new MCTs(backPropagations,debug));
    //         population.get(i).enableRules(1,1);
    //         ArrayList<Integer> strategyList = new ArrayList<>();
    //         for(int j = 0; j < numberOfStrategies; j++){
    //             strategyList.add(random.nextInt(256));
    //         }
    //         population.get(i).enableStrategy(strategyList);
    //     }
    // }
//     public void generateRandomPopulation(){
//         random = new Random();
//         for(int i = 0; i < populationSize; i++){

//         }
//     }
//     public void sortPopulation(){
//         for(int i = 0; i < populationSize; i++){
//             int maxIndex = i;
//             for(int j = i + 1; j < populationSize; j++){
//                 if(fitnessList.get(j) > fitnessList.get(maxIndex)){
//                     maxIndex = j;
//                 }
//             }
//             MCTs tempChromosome = population.get(maxIndex);
//             int tempFitness = fitnessList.get(maxIndex);
//             fitnessList.set(maxIndex, fitnessList.get(i));
//             population.set(maxIndex, population.get(i));
//             fitnessList.set(i, tempFitness);
//             population.set(i, tempChromosome);
//         }
//     }
//     public int rouletteWheelSelection(ArrayList<Double> weights) {
//         // Calculate the cumulative sum of weights
//         ArrayList<Double> accumulation = new ArrayList<>();
//         accumulation.add(weights.get(0));
//         for (int i = 1; i < weights.size(); i++) {
//             accumulation.add(accumulation.get(i - 1) + weights.get(i));
//         }
//         // Generate a random number between 0 and 1s
//         double p = Math.random();
//         // Initialize the chosen index
//         int chosenIndex = -1;

//         // Iterate through the accumulation array to find the chosen index
//         for (int index = 0; index < accumulation.size(); index++) {
//             //System.out.println(accumulation.get(index));
//             // if the cumulative sum at position index is bigger than p
//             if (accumulation.get(index) > p) {
//                 // Set the chosen index and exit the loop
//                 chosenIndex = index;
//                 break;
//             }
//         }

//         if (chosenIndex == -1) {
//             chosenIndex = 0; // Fallback to the first chromosome
//         }

//         // Assign the chosen index as the output
//         return chosenIndex;
//     }
//     public void uniformCrossover(ArrayList<Integer> tempChromosome1List, ArrayList<Integer> tempChromosome2List, double swappingProb){
//         for(int i = 0; i < tempChromosome1List.size(); i++){
//             Random random = new Random();
//             int[] chromosome1Value = convertIntToBinary(tempChromosome1List.get(i));
//             int[] chromosome2Value = convertIntToBinary(tempChromosome2List.get(i));
//             for(int j = 0; j < chromosome1Value.length; j++){
//                 double crossover = random.nextDouble();

//                 if(crossover > swappingProb){
//                     int temp = chromosome1Value[j];
//                     chromosome1Value[j] = chromosome2Value[j];
//                     chromosome2Value[j] = temp;
//                 }
//             }
//             tempChromosome1List.set(i, convertBinaryToInt(chromosome1Value));
//             tempChromosome2List.set(i, convertBinaryToInt(chromosome2Value));
//             // tempChromosome1List.set(i, connect4BinaryToInt(chromosome1Value));
//         }
//     }
//     public void bitFlipMutation(ArrayList<Integer> tempChromosomeList){
//         for(int i = 0; i < tempChromosomeList.size(); i++){
//             Random random = new Random();
//             int[] chromosomeValue = convertIntToBinary(tempChromosomeList.get(i));
//             int index = random.nextInt(chromosomeValue.length);
//             chromosomeValue[index] = -chromosomeValue[index] + 1;
//             tempChromosomeList.set(i, convertBinaryToInt(chromosomeValue));
//         }
//     }
//     public ArrayList<Integer> copyArrayList(ArrayList<Integer> tempBoard){
//         ArrayList<Integer> newArrayList = new ArrayList<>();
//         for(int i = 0; i < tempBoard.size(); i++){
//             newArrayList.add(tempBoard.get(i));
//         }
//         return newArrayList;
//     }

//     public void runGeneticMCTs(){
//         generateRandomPopulation();
//         for(int k = 0; k < iterations; k++){
//             totalFitness = 0;
//             fitnessList = new ArrayList<>();
//             // CALCULATE FITNESS
//             for(int i = 0; i < populationSize; i++){
//                 FitnessFunction fitnessFunction = new FitnessFunction(population, population.get(i), numPlays, logger, gameMode,log, 3);
//                 fitnessList.add(fitnessFunction.getFitness());
//                 totalFitness = totalFitness + fitnessFunction.getFitness();
//             }
//             // SORT POPULATION
//             sortPopulation();
//             // CREATE A NEW POPULATION WITH TOP 25 PERCENT
//             ArrayList<MCTs> newPopulation = new ArrayList<>();
//             ArrayList<Integer> newFitnessList = new ArrayList<>();
//             int newPopulationSize = 0;
//             for(int i = 0; i < populationSize * 0.25; i++){
//                 newPopulation.add(population.get(i));
//                 newFitnessList.add(fitnessList.get(i));
//                 newPopulationSize = newPopulationSize + 1;
//             }
//             for(int i = 0; i < fitnessList.size(); i++)
//             {
//                 // System.out.println("NUMBER:  " + i + "  strategy1Value:  " + population.get(i).strategyList.get(0) + "  strategy2Value:   " + population.get(i).strategyList.get(1) + "  Fitness:    " + fitnessList.get(i));
//                 System.out.printf("Number: " + i);
//                 System.out.printf("   Fitness:  "  + fitnessList.get(i));
//                 for(int j = 0; j < numberOfStrategies; j++){
//                     System.out.printf("   Strategy" + j + ":  " + population.get(i).strategyList.get(j));
//                 }
//                 System.out.printf("\r\n");
//             }
//             System.out.println("------------------------------------------------------");
//             while (newPopulation.size() < population.size()) {
//                 // SELECTION
//                 ArrayList<Double> weights = new ArrayList<>();
//                 for(int i = 0; i < populationSize; i++){
//                     double weightValue = ((double)fitnessList.get(i) / totalFitness);
//                     weights.add(weightValue);
//                 }
//                 int choice1 = rouletteWheelSelection(weights);
//                 int choice2 = rouletteWheelSelection(weights);

//                 ArrayList<Integer> tempChromosome1StrategyList = copyArrayList(population.get(choice1).strategyList);
//                 ArrayList<Integer> tempChromosome2StrategyList =  copyArrayList(population.get(choice2).strategyList);

//                 // CROSSOVER

//                 if(Math.random() < 0.6){
//                     double swappingProb = 0.5;
//                     uniformCrossover(tempChromosome1StrategyList, tempChromosome2StrategyList, swappingProb);
//                 }

//                 // MUTATION
//                 if(Math.random() < 0.4){
//                     bitFlipMutation(tempChromosome1StrategyList);
//                 }
//                 if(Math.random() < 0.4){
//                     bitFlipMutation(tempChromosome2StrategyList);
//                 }
//                 newPopulation.add(new MCTs(population.get(choice1).iterations, debug));
//                 newPopulation.get(newPopulation.size() - 1).enableStrategy(tempChromosome1StrategyList);
//                 if(newPopulation.size() < population.size()){
//                     newPopulation.add(new MCTs(population.get(choice2).iterations, debug));
//                     newPopulation.get(newPopulation.size() - 1).enableStrategy(tempChromosome2StrategyList);
//                 }

//                 //
//             }
//             population = new ArrayList<>();
//             for(int i = 0; i < populationSize; i++){
//                 population.add(newPopulation.get(i));
//             }
//         }
//         totalFitness = 0;
//         fitnessList = new ArrayList<>();
//         for(int i = 0; i < populationSize; i++){
//             FitnessFunction fitnessFunction = new FitnessFunction(population, population.get(i), numPlays, logger, gameMode,log ,3);
//             fitnessList.add(fitnessFunction.getFitness());
//             totalFitness = totalFitness + fitnessFunction.getFitness();
//         }
//         sortPopulation();
//         for(int i = 0; i < fitnessList.size(); i++)
//         {
//             // System.out.println("NUMBER:  " + i + "  strategy1Value:  " + population.get(i).strategyList.get(0) + "  strategy2Value:   " + population.get(i).strategyList.get(1) + "  Fitness:    " + fitnessList.get(i));
//             System.out.printf("Number: " + i);
//             System.out.printf("   Fitness:  "  + fitnessList.get(i));
//             for(int j = 0; j < numberOfStrategies; j++){
//                 System.out.printf("   Strategy" + j + ":  " + population.get(i).strategyList.get(j));
//             }
//             System.out.printf("\r\n");
//         }
//     }
// }
