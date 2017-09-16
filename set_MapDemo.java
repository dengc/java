import java.util.*;


public class set_MapDemo {

	public static void main(String[] args) {

		Set<String> names = new TreeSet<String>();

		names.add("Jerry");
		names.add("Tom");
		names.add("David");
		names.remove("David");
		names.remove("D");

		System.out.println(names.isEmpty());
		System.out.println(names.size());
		System.out.println(names.contains("Jerry"));

		Iterator<String> iter = names.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}

		System.out.println("Map==========================");

		Map<String, Integer> scores = new TreeMap<String, Integer>();

		scores.put("Jerry", 94);
		scores.put("Jerry", 100);
		scores.put("Tom", 77);
		scores.put("Dean", 45);
		scores.remove("Dean");
		System.out.println(scores.get("Jerry"));

		Iterator<String> namesIter = scores.keySet().iterator();

		Iterator<Map.Entry<String, Integer>> scoresMapIter = scores.entrySet().iterator();
		while (scoresMapIter.hasNext()) {
			Map.Entry<String, Integer> curr = scoresMapIter.next();

			curr.setValue(6666);
			System.out.println(curr.getKey() + ": " + curr.getValue());
		}
	}
}
