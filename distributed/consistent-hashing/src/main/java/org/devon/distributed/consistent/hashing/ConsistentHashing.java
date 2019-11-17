package org.devon.distributed.consistent.hashing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author dewen.ye
 * @datetime 2019/11/9 4:06 PM
 * @since
 */
public class ConsistentHashing<T extends HashNode> {

	private final char SIGNAL = '#';
	private final int numberOfReplicas;

	private Set<HashNode> realNodes;

    private final SortedMap<Integer,T> ring = new TreeMap<>();

    private final HashFunction hashFunction;


	public ConsistentHashing(int numberOfReplicas, Collection<T> realNodes) {
		this(numberOfReplicas,realNodes,new MD5HashFunction());
	}

	public ConsistentHashing(int numberOfReplicas, Collection<T> realNodes, HashFunction hashFunction) {
		this.realNodes = new HashSet<>();
		this.numberOfReplicas = numberOfReplicas;
		this.hashFunction = hashFunction;
		for (T realNode : realNodes) {
                add(realNode);
		}
	}


	public T getNode(Object key){
       if(ring.isEmpty()){
       	return null;
	   }
       int hash  = hashFunction.hash(key);
       T node  = ring.get(hash);
       if(node == null){
		   // inexact match -- find the next value in the circle
		   SortedMap<Integer, T> tailMap = ring.tailMap(hash);
		   hash = tailMap.isEmpty() ? ring.firstKey() : tailMap.firstKey();
		   node = ring.get(hash);
	   }
       return node;
	}

	private void add(T node){
		realNodes.add(node);
		for (int i = 0; i <numberOfReplicas ; i++) {
			 ring.put(hashFunction.hash(node.getNodeName()+SIGNAL+i),node);
		}
	}

	/**
	 * This returns the closest n unique nodes in order for the object.
	 *
	 * This will return a list that has all nodes if n > number of nodes.
	 *
	 * @param key the key
	 * @param n the n
	 * @return the n unique nodes for
	 */
	public List<T> getNUniqueNodesFor(Object key, int n) {
		if (ring.isEmpty()) {
			return Collections.emptyList();
		}

		if (n > realNodes.size()) {
			n = realNodes.size();
		}

		List<T> list = new ArrayList<>(n);
		int hash = hashFunction.hash(key);
		for (int i = 0; i < n; i++) {
			if (!ring.containsKey(hash)) {
				// go to next element.
				SortedMap<Integer, T> tailMap = ring.tailMap(hash);
				hash = tailMap.isEmpty() ? ring.firstKey() : tailMap.firstKey();
			}
			T candidate = ring.get(hash);
			if (!list.contains(candidate)) {
				list.add(candidate);
			} else {
				i--; // try again.
			}
			// find the next element in the circle
			hash++;
		}
		return list;
	}

}
