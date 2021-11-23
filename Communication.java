package geneticmapping;

public class Communication {

		Task sender;
		Task receiver;
		String name;
		double volume;

		
		public Communication(Task s, Task r){
			
			sender=s;
			receiver=r;
		}

		public void setName(String s){
			
			name = s;
		}
		
		public String getName(){
			
			return name;
		}
		
		public Task getReceiver() {
			return receiver;
		}

		public Task getSender() {
			return sender;
		}


		/**
		 * @return the communication volume
		 */
		public double getVolume() {
			return volume;
		}

		/**
		 * @param d the communication volume to set
		 */
		public void setVolume(double d) {
			this.volume = d;
		}

		
	}
