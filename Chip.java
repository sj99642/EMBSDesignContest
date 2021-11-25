package geneticmapping;

public class Chip {
	protected String name;
	protected double cost;
	private Task[] Tasks;
	private double factorFc = 1;
	
	
	public Chip(String s){
		
		name=s;
	}


	public String getName() {
		return name;
	}
	
	/**
	 * @return the cost
	 */
	
	public void addTask(Task t) {
		if(this.cost + t.getCost() <= this.factorFc) {
			Task[] oldTasks = Tasks;
			Tasks = new Task[Tasks.length + 1];
			Tasks[0] = t;
			this.cost += t.getCost();
			for (int i = 1;i <= Tasks.length;i++) {
				Tasks[i] = oldTasks[i-1];
			}
		}
		
	}
	
	public void removeTask(Task t) {
		Task[] lastTasks = Tasks;
		Tasks = new Task[Tasks.length - 1];
		this.cost -= t.getCost();
		for (int i = 0;i <= Tasks.length;i++) {
			if(t.getName() != lastTasks[i].getName()) {
				Tasks[i] = lastTasks[i];
			}
		}
	}
	
	
	public Task[] getTasks() {
		return Tasks;
	}
	
	public double getCost() {
		return cost;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void setfactorFc(double factorFc) {
		this.factorFc = factorFc;
	}

}
