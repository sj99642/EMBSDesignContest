package geneticmapping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionEngine;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.FitnessEvaluator;
import org.uncommons.watchmaker.framework.GenerationalEvolutionEngine;
import org.uncommons.watchmaker.framework.SelectionStrategy;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.selection.StochasticUniversalSampling;

import lsi.evo.IntegerArrayCrossover;
import lsi.evo.IntegerArrayFactory;
import lsi.evo.IntegerArrayMutation;

public class GeneticMapper implements FitnessEvaluator<int[]>{

	Task[] tasks;
	Communication[] comms;
	Chip[] chips;
	int processors;
	EvolutionEngine<int[]> engine;
	double alpha = 1.0;
	double beta = 1.0;
	
	public GeneticMapper(Task[] tasks, Communication[] comms, Chip[] chips, int processors) {

		this.tasks=tasks;
		this.comms=comms;
		this.processors=processors;

		
		
		// generates chromosomes with tasks.size() genes (one gene per task)
		// and genes can contain integers from 0 up to "processors - 1"
		
		IntegerArrayFactory factory = new IntegerArrayFactory(processors-1, tasks.length);
		
		
		// create a pipeline that applies cross-over then mutation
		
		List<EvolutionaryOperator<int[]>> operators
		    = new LinkedList<EvolutionaryOperator<int[]>>();

		operators.add(new IntegerArrayCrossover(1,new Probability(0.7)));
		operators.add(new IntegerArrayMutation(processors-1, new Probability(0.1)));

		EvolutionaryOperator<int[]> pipeline = new EvolutionPipeline<int[]>(operators);

		// instantiate evolutionary engine
		SelectionStrategy<Object> selection = new StochasticUniversalSampling();
		Random rng = new MersenneTwisterRNG();

		engine = new GenerationalEvolutionEngine<int[]>(factory,
		                                                pipeline,
		                                                this,  // uses itself as fitness function
		                                                selection,
		                                                rng);	
	
		
		
	}

	
	
	// allows external classes to access the evolution engine
	// useful for debugging and analysis/display of results
	
	public EvolutionEngine<int[]> getEngine(){return engine;}
	



	
	// method called by the evolutionary engine
	// to calculate the fitness of a given individual
	
	// simplistic approach:
	// fitness = alpha * number of overutilised processors + beta * inter-processor communication volume


	public double getFitness(int[] arg0, List<? extends int[]> arg1) {

		
		int overUtilProcs = getOverutilisedProcessors(arg0);
			
		long interprocessorComms = getInterprocessorCommunication(arg0);
		
		return alpha * overUtilProcs + beta * interprocessorComms;
	
		
		// TODO Auto-generated method stub
		// return 0;
	}


	// calculates the number of overutilised processors
	
	public double getCost(int[] mapping) {
		double cost = 0;
		double mesh = 16;
		double factorFc = 0;
		double factorFi = 0;
		
		for (int i=0;i<mapping.length;i++) {
			
		}
		
		
		
		cost = mesh + factorFc + factorFi;
		
		return cost;
	}
	
	public int getOverutilisedProcessors(int[] mapping){
		
		
		double[] utilisation = new double[processors];
		System.out.println(mapping);
		
		for(int i=0;i<mapping.length;i++){
			
			utilisation[mapping[i]]+= tasks[i].getCost();
			
			System.out.println(mapping[i]);
			
		}
		
		int overUtilProcs = 0;
		
		for(int u=0;u<utilisation.length;u++){
			
			if(utilisation[u]>1) {
				
				overUtilProcs++;
				
			}
			
		}
		
		return overUtilProcs;
	}
	
	
	
	// calculates the total inter-processor communication volume

	
	public long getInterprocessorCommunication(int[] mapping){
		
		long interprocessorComms = 0;

		
		for(int j=0;j<comms.length;j++){
			
			int procSender = mapping[getTaskIndex(comms[j].sender)];
			int procReceiver = mapping[getTaskIndex(comms[j].receiver)];
			
			if(procSender!=procReceiver){
				
				interprocessorComms += comms[j].getVolume();
				
			}
			
		}
		
		
		return interprocessorComms;
	}
	
	
	
	// returns the index of a given task in the array
	
	private int getTaskIndex(Task t){
	
		for(int i=0; i<tasks.length;i++){
			
			if(t==tasks[i]) return i;
			
		}
		
		return -1;
	}
	
	private double[] getChipsCosts(Chip[] chips){
		double[] costs = new double[chips.length];
		for (int i = 0;i <= chips.length;i++) {
			costs[i] = chips[1].getCost();
		}
		return costs;
	}
	
	private Chip getHighCostChip(Chip[] chips){
		int x = 0;
		for (int i = 0;i <= chips.length;i++) {
			if(this.getChipsCosts(chips)[i] > chips[x].getCost()) {
				x = i;
			}
		}
		return chips[x];
	}
	
	private double getChipInput(Chip chip, Communication[] comms) {
		double cost =0;
		for (int i = 0;i <= chip.getTasks().length;i++) {
			for (int j = 0;j <= comms.length;j++) {
				if(comms[j].getReceiver().getName() == chip.getTasks()[i].getName()){
					cost+=comms[j].getVolume();
					}
				}
		}
		return cost;
	}
	
	private double getChipOutput(Chip chip, Communication[] comms) {
		double cost =0;
		for (int i = 0;i <= chip.getTasks().length;i++) {
			for (int j = 0;j <= comms.length;j++) {
				if(comms[j].getSender().getName() == chip.getTasks()[i].getName()){
					cost+=comms[j].getVolume();
					}
				}
		}
		return cost;
	}
	
	
	

	public boolean isNatural() {
		
		return false; // meaning a lower fitness value denotes a fitter individual
		
	}
	
	
	public void setAlpha(double alpha){this.alpha=alpha;}
	public void setBeta(double beta){this.beta=beta;}
	
	
}
