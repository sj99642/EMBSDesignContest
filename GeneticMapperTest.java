package geneticmapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionObserver;
import org.uncommons.watchmaker.framework.PopulationData;
import org.uncommons.watchmaker.framework.termination.GenerationCount;
import org.uncommons.watchmaker.swing.evolutionmonitor.EvolutionMonitor;

public class GeneticMapperTest {

	public static void main(String[] args){
		
		
		System.out.println("Running class: GeneticMapper");
		System.out.println("");

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		System.out.println(dateFormat.format(date));
		System.out.println("");
		
		
		// instantiate application tasks and comms
		
		Task T0 = new Task("T0");
		Task T1 = new Task("T1");
		Task T2 = new Task("T2");
		Task T3 = new Task("T3");
		Task T4 = new Task("T4");
		Task T5 = new Task("T5");
		Task T6 = new Task("T6");
		Task T7 = new Task("T7");
		Task T8 = new Task("T8");
		Task T9 = new Task("T9");
		Task T10 = new Task("T10");
		Task T11 = new Task("T11");
		Task T12 = new Task("T12");
		Task T13 = new Task("T13");
		Task T14 = new Task("T14");
		Task T15 = new Task("T15");
		Task T16 = new Task("T16");
		Task T17 = new Task("T17");
		Task T18 = new Task("T18");
		Task T19 = new Task("T19");
		Task T20 = new Task("T20");
		Task T21 = new Task("T21");
		Task T22 = new Task("T22");
		Task T23 = new Task("T23");
		Task T24 = new Task("T24");
		Task T25 = new Task("T25");
		Task T26 = new Task("T26");
		Task T27 = new Task("T27");
		Task T28 = new Task("T28");
		Task T29 = new Task("T29");
		Task T30 = new Task("T30");
		Task T31 = new Task("T31");
		Task T32 = new Task("T32");
		Task T33 = new Task("T33");
		Task T34 = new Task("T34");
		Task T35 = new Task("T35");
		Task T36 = new Task("T36");
		Task T37 = new Task("T37");
		Task T38 = new Task("T38");
		Task T39 = new Task("T39");
		Task T40 = new Task("T40");
		Task T41 = new Task("T41");
		Task T42 = new Task("T42");
		Task T43 = new Task("T43");
		Task T44 = new Task("T44");
		Task T45 = new Task("T45");
		Task T46 = new Task("T46");
		Task T47 = new Task("T47");
		Task T48 = new Task("T48");
		Task T49 = new Task("T49");
		Task T50 = new Task("T50");
		Task T51 = new Task("T51");
		Task T52 = new Task("T52");
		Task T53 = new Task("T53");
		
		
		
		T0.setCost(0.38);
		T1.setCost(0.19);
		T2.setCost(0.29);
		T3.setCost(0.09);
		T4.setCost(0.26);
		T5.setCost(0.41);
		T6.setCost(0.13);
		T7.setCost(0.32);
		T8.setCost(0.33);
		T9.setCost(0.18);
		T10.setCost(0.08);
		T11.setCost(0.16);
		T12.setCost(0.17);
		T13.setCost(0.22);
		T14.setCost(0.11);
		T15.setCost(0.36);
		T16.setCost(0.14);
		T17.setCost(0.07);
		T18.setCost(0.51);
		T19.setCost(0.12);
		T20.setCost(0.27);
		T21.setCost(0.09);
		T22.setCost(0.36);
		T23.setCost(0.25);
		T24.setCost(0.24);
		T25.setCost(0.52);
		T26.setCost(0.06);
		T27.setCost(0.21);
		T28.setCost(0.53);
		T29.setCost(0.20);
		T30.setCost(0.42);
		T31.setCost(0.49);
		T32.setCost(0.20);
		T33.setCost(0.15);
		T34.setCost(0.34);
		T35.setCost(0.27);
		T36.setCost(0.09);
		T37.setCost(0.28);
		T38.setCost(0.33);
		T39.setCost(0.05);
		T40.setCost(0.47);
		T41.setCost(0.55);
		T42.setCost(0.34);
		T43.setCost(0.39);
		T44.setCost(0.46);
		T45.setCost(0.06);
		T46.setCost(0.36);
		T47.setCost(0.11);
		T48.setCost(0.62);
		T49.setCost(0.45);
		T50.setCost(0.42);
		T51.setCost(0.64);
		T52.setCost(0.29);
		T53.setCost(0.59);
		
		
		Task[] tasks = new Task[54];
		tasks[0]=T0;
		tasks[1]=T1;
		tasks[2]=T2;
		tasks[3]=T3;
		tasks[4]=T4;
		tasks[5]=T5;
		tasks[6]=T6;
		tasks[7]=T7;
		tasks[8]=T8;
		tasks[9]=T9;
		tasks[10]=T10;
		tasks[11]=T11;
		tasks[12]=T12;
		tasks[13]=T13;
		tasks[14]=T14;
		tasks[15]=T15;
		tasks[16]=T16;
		tasks[17]=T17;
		tasks[18]=T18;
		tasks[19]=T19;
		tasks[10]=T10;
		tasks[21]=T21;
		tasks[22]=T22;
		tasks[23]=T23;
		tasks[24]=T24;
		tasks[25]=T25;
		tasks[26]=T26;
		tasks[27]=T27;
		tasks[28]=T28;
		tasks[29]=T29;
		tasks[30]=T30;
		tasks[31]=T31;
		tasks[32]=T32;
		tasks[33]=T33;
		tasks[34]=T34;
		tasks[35]=T35;
		tasks[36]=T36;
		tasks[37]=T37;
		tasks[38]=T38;
		tasks[39]=T39;
		tasks[40]=T40;
		tasks[41]=T41;
		tasks[42]=T42;
		tasks[43]=T43;
		tasks[44]=T44;
		tasks[45]=T45;
		tasks[46]=T46;
		tasks[47]=T47;
		tasks[48]=T48;
		tasks[49]=T49;
		tasks[50]=T50;
		tasks[51]=T51;
		tasks[52]=T52;
		tasks[53]=T53;
		
		
		

		Communication c0 = new Communication(T27,T34);
		Communication c1 = new Communication(T50,T28);
		Communication c2 = new Communication(T33,T26);
		Communication c3 = new Communication(T16,T30);
		Communication c4 = new Communication(T7,T48);
		Communication c5 = new Communication(T43,T21);
		Communication c6 = new Communication(T8,T38);
		Communication c7 = new Communication(T14,T34);
		Communication c8 = new Communication(T23,T26);
		Communication c9 = new Communication(T17,T8);
		Communication c10 = new Communication(T22,T9);
		Communication c11 = new Communication(T49,T27);
		Communication c12 = new Communication(T22,T41);
		Communication c13 = new Communication(T1,T49);
		Communication c14 = new Communication(T35,T13);
		Communication c15 = new Communication(T47,T4);
		Communication c16 = new Communication(T41,T30);
		Communication c17 = new Communication(T40,T3);
		Communication c18 = new Communication(T14,T1);
		Communication c19 = new Communication(T26,T13);
		Communication c20 = new Communication(T27,T42);
		Communication c21 = new Communication(T48,T2);
		Communication c22 = new Communication(T16,T29);
		Communication c23 = new Communication(T0,T8);
		Communication c24 = new Communication(T20,T32);
		Communication c25 = new Communication(T42,T40);
		Communication c26 = new Communication(T12,T28);
		Communication c27 = new Communication(T36,T11);
		Communication c28 = new Communication(T22,T2);
		Communication c29 = new Communication(T18,T18);
		Communication c30 = new Communication(T28,T18);
		Communication c31 = new Communication(T4,T32);
		Communication c32 = new Communication(T44,T36);
		Communication c33 = new Communication(T25,T41);
		Communication c34 = new Communication(T43,T37);
		Communication c35 = new Communication(T37,T2);
		Communication c36 = new Communication(T30,T49);
		Communication c37 = new Communication(T3,T33);
		Communication c38 = new Communication(T39,T40);
		Communication c39 = new Communication(T2,T0);
		Communication c40 = new Communication(T21,T17);
		Communication c41 = new Communication(T8,T33);
		Communication c42 = new Communication(T33,T7);
		Communication c43 = new Communication(T34,T44);
		Communication c44 = new Communication(T45,T33);
		Communication c45 = new Communication(T11,T3);
		Communication c46 = new Communication(T19,T8);
		Communication c47 = new Communication(T0,T9);
		Communication c48 = new Communication(T38,T11);
		Communication c49 = new Communication(T12,T39);
		Communication c50 = new Communication(T35,T42);
		Communication c51 = new Communication(T46,T20);
		Communication c52 = new Communication(T41,T32);
		Communication c53 = new Communication(T5,T44);
		Communication c54 = new Communication(T44,T13);
		Communication c55 = new Communication(T26,T41);
		Communication c56 = new Communication(T13,T4);
		Communication c57 = new Communication(T6,T0);
		Communication c58 = new Communication(T15,T10);
		Communication c59 = new Communication(T31,T39);
		Communication c60 = new Communication(T17,T5);
		Communication c61 = new Communication(T29,T7);
		Communication c62 = new Communication(T24,T40);
		Communication c63 = new Communication(T21,T43);
		Communication c64 = new Communication(T13,T23);
		Communication c65 = new Communication(T19,T26);
		Communication c66 = new Communication(T32,T10);
		Communication c67 = new Communication(T9,T26);
		Communication c68 = new Communication(T23,T4);
		Communication c69 = new Communication(T10,T5);

		
		

		
		c0.setVolume(0.47);
		c1.setVolume(0.45);
		c2.setVolume(0.13);
		c3.setVolume(0.27);
		c4.setVolume(0.52);
		c5.setVolume(0.43);
		c6.setVolume(0.44);
		c7.setVolume(0.19);
		c8.setVolume(0.15);
		c9.setVolume(0.32);
		c10.setVolume(0.28);
		c11.setVolume(0.05);
		c12.setVolume(0.22);
		c13.setVolume(0.12);
		c14.setVolume(0.52);
		c15.setVolume(0.2);
		c16.setVolume(0.23);
		c17.setVolume(0.06);
		c18.setVolume(0.51);
		c19.setVolume(0.12);
		c20.setVolume(0.52);
		c21.setVolume(0.23);
		c22.setVolume(0.34);
		c23.setVolume(0.13);
		c24.setVolume(0.37);
		c25.setVolume(0.49);
		c26.setVolume(0.06);
		c27.setVolume(0.15);
		c28.setVolume(0.1);
		c29.setVolume(0.4);
		c30.setVolume(0.12);
		c31.setVolume(0.44);
		c32.setVolume(0.38);
		c33.setVolume(0.2);
		c34.setVolume(0.19);
		c35.setVolume(0.06);
		c36.setVolume(0.42);
		c37.setVolume(0.25);
		c38.setVolume(0.11);
		c39.setVolume(0.2);
		c40.setVolume(0.14);
		c41.setVolume(0.21);
		c42.setVolume(0.33);
		c43.setVolume(0.04);
		c44.setVolume(0.07);
		c45.setVolume(0.3);
		c46.setVolume(0.34);
		c47.setVolume(0.16);
		c48.setVolume(0.11);
		c49.setVolume(0.41);
		c50.setVolume(0.35);
		c51.setVolume(0.06);
		c52.setVolume(0.21);
		c53.setVolume(0.12);
		c54.setVolume(0.28);
		c55.setVolume(0.31);
		c56.setVolume(0.2);
		c57.setVolume(0.09);
		c58.setVolume(0.34);
		c59.setVolume(0.36);
		c60.setVolume(0.18);
		c61.setVolume(0.09);
		c62.setVolume(0.11);
		c63.setVolume(0.29);
		c64.setVolume(0.23);
		c65.setVolume(0.38);
		c66.setVolume(0.08);
		c67.setVolume(0.11);
		c68.setVolume(0.32);
		c69.setVolume(0.23);

		Communication[] comms = new Communication[70];
		comms[0]=c0;
		comms[1]=c1;
		comms[2]=c2;
		comms[3]=c3;
		comms[4]=c4;
		comms[5]=c5;
		comms[6]=c6;
		comms[7]=c7;
		comms[8]=c8;
		comms[9]=c9;
		comms[10]=c10;
		comms[11]=c11;
		comms[12]=c12;
		comms[13]=c13;
		comms[14]=c14;
		comms[15]=c15;
		comms[16]=c16;
		comms[17]=c17;
		comms[18]=c18;
		comms[19]=c19;
		comms[10]=c10;
		comms[21]=c21;
		comms[22]=c22;
		comms[23]=c23;
		comms[24]=c24;
		comms[25]=c25;
		comms[26]=c26;
		comms[27]=c27;
		comms[28]=c28;
		comms[29]=c29;
		comms[30]=c30;
		comms[31]=c31;
		comms[32]=c32;
		comms[33]=c33;
		comms[34]=c34;
		comms[35]=c35;
		comms[36]=c36;
		comms[37]=c37;
		comms[38]=c38;
		comms[39]=c39;
		comms[40]=c40;
		comms[41]=c41;
		comms[42]=c42;
		comms[43]=c43;
		comms[44]=c44;
		comms[45]=c45;
		comms[46]=c46;
		comms[47]=c47;
		comms[48]=c48;
		comms[49]=c49;
		comms[50]=c50;
		comms[51]=c51;
		comms[52]=c52;
		comms[53]=c53;
		comms[54]=c54;
		comms[55]=c55;
		comms[56]=c56;
		comms[57]=c57;
		comms[58]=c58;
		comms[59]=c59;
		comms[60]=c60;
		comms[61]=c61;
		comms[62]=c62;
		comms[63]=c63;
		comms[64]=c64;
		comms[65]=c65;
		comms[66]=c66;
		comms[67]=c67;
		comms[68]=c68;
		comms[69]=c69;
		
		Chip C0 = new Chip("C0");
		Chip C1 = new Chip("C1");
		Chip C2 = new Chip("C2");
		Chip C3 = new Chip("C3");
		Chip C4 = new Chip("C4");
		Chip C5 = new Chip("C5");
		Chip C6 = new Chip("C6");
		Chip C7 = new Chip("C7");
		Chip C8 = new Chip("C8");
		Chip C9 = new Chip("C9");
		Chip C10 = new Chip("C10");
		Chip C11 = new Chip("C11");
		Chip C12 = new Chip("C12");
		Chip C13 = new Chip("C13");
		Chip C14 = new Chip("C14");
		Chip C15 = new Chip("C15");
		
		Chip[] chips= new Chip[16];
		chips[0] = C0;
		chips[1] = C1;
		chips[2] = C2;
		chips[3] = C3;
		chips[4] = C4;
		chips[5] = C5;
		chips[6] = C6;
		chips[7] = C7;
		chips[8] = C8;
		chips[9] = C9;
		chips[10] = C10;
		chips[11] = C11;
		chips[12] = C12;
		chips[13] = C13;
		chips[14] = C14;
		chips[15] = C15;
		
		
		
		
		
		// instantiate mapper
		// passing as argument the array of tasks, array of comms and number of processors in the platform
		
		GeneticMapper mapper = new GeneticMapper(tasks, comms, 16);
		
		
		// set parameters to tune the two elements of the fitness function
		mapper.setAlpha(1.0);
		mapper.setBeta(1.0);		
		

		// use watchmaker framework's debugging and visualisation features
		
		mapper.getEngine().addEvolutionObserver(new EvolutionObserver<int[]>()
				{
		    public void populationUpdate(PopulationData<? extends int[]> data)
		    {
		        System.out.println("Generation: " + data.getGenerationNumber() + ", fitness: " + data.getBestCandidateFitness() + ", mapping: "+ printMapping(data.getBestCandidate()));
		    }
		});
	
//		EvolutionMonitor<int[]> monitor = new EvolutionMonitor<int[]>();
		
//		mapper.getEngine().addEvolutionObserver(monitor);
//		
//		JFrame frame = new JFrame("Evolution Monitor");
//		frame.getContentPane().add(monitor.getGUIComponent());
//		frame.pack();
//		frame.setVisible(true);
		
		int[] result = mapper.getEngine().evolve(1000, 20, new GenerationCount(180)); // evolve for 180 generations
		System.out.println("Execution terminated - best mapping:");
		System.out.println(printMapping(result));
		System.out.println("");
		
		System.out.println("Overloaded processors: "+mapper.getOverutilisedProcessors(result));
		System.out.println("Interprocessor comms: "+mapper.getInterprocessorCommunication(result));
		
		
		date = new Date();
		System.out.println("");
		System.out.println(dateFormat.format(date));
		
		
		
	}
	
	
	public static String printMapping(int[] mapping){
		
		String output = "[";
		for(int i=0;i<mapping.length-1;i++){
			
			output = output + mapping[i] + " - ";
		}
		output = output + mapping[mapping.length-1] + "]";
		return output;
	}
	
	
}
