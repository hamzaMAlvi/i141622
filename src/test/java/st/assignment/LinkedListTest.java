package st.assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

import org.junit.Test;

import st.assignment.LinkedList;

public class LinkedListTest {

	@Test
	public void testSize() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(5);
		int x=tmp.size();
		assertEquals(2, x);
	}

	@Test
	public void testClear() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(5);
		tmp.clear();
		int x=tmp.size();
		assertEquals(0, x);
	}

	@Test
	public void testLinkedList() {
		LinkedList<Integer> tmp=new LinkedList<>();
		assertNotNull(tmp);
	}

	@Test
	public void testLinkedListCollectionOfQextendsE() {
		ArrayList<Integer> tmp=new ArrayList<>();
		tmp.add(10);
		tmp.add(20);
		LinkedList<Integer> tmp1=new LinkedList<>(tmp);
		assertEquals(10, (int)tmp1.get(0));
		assertEquals(10, (int)tmp1.get(0));
		assertEquals(2, tmp1.size());
	}

	@Test
	public void testLinkBefore() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(5);
		tmp.add(25);
		tmp.linkBefore(20, tmp.node(2));
		tmp.linkBefore(15, tmp.node(1));
		tmp.linkBefore(30, tmp.node(0));
		assertEquals(15, (int)tmp.get(2));
		assertEquals(20, (int)tmp.get(4));
		assertEquals(30, (int)tmp.get(0));
	}

	@Test
	public void testUnlink() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(5);
		tmp.unlink(tmp.node(0));
		assertEquals(5, (int)tmp.get(0));
		assertEquals(1, (int)tmp.size());
		tmp.add(10);
		tmp.unlink(tmp.node(1));
		assertEquals(1, (int)tmp.size());
	}

	@Test
	public void testGetFirst() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(5);
		int x=tmp.getFirst();
		assertEquals(10, x);
	}

	@Test(expected=NoSuchElementException.class)
	public void testGetFirstEx() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.getFirst();
	}

	@Test
	public void testGetLast() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(5);
		int x=tmp.getLast();
		assertEquals(5, x);
	}

	@Test(expected=NoSuchElementException.class)
	public void testGetLastEx() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.getLast();
	}

	@Test
	public void testRemoveFirst() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(5);
		int x=tmp.removeFirst();
		assertEquals(10, x);
	}

	@Test(expected=NoSuchElementException.class)
	public void testRemoveFirstEx() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.removeFirst();
	}

	@Test
	public void testRemoveLast() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(5);
		int x=tmp.removeLast();
		assertEquals(5, x);
	}

	@Test(expected=NoSuchElementException.class)
	public void testRemoveLastEx() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.removeLast();
	}

	@Test
	public void testAddFirst() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.addFirst(10);
		tmp.addFirst(20);
		assertEquals(20, (int)tmp.get(0));
	}

	@Test
	public void testAddLast() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.addLast(10);
		tmp.addLast(20);
		assertEquals(20, (int)tmp.get(1));
	}

	@Test
	public void testContainsObject() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.addLast(10);
		assertTrue(tmp.contains(10));
		assertFalse(tmp.contains(15));
	}

	@Test
	public void testRemoveObject() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		boolean tmp1=tmp.remove(null);
		assertFalse(tmp1);
		assertEquals(1, tmp.size());
		tmp.add(null);
		tmp1=tmp.remove(null);
		assertTrue(tmp1);
		assertEquals(1, tmp.size());
		tmp.add(20);
		tmp1=tmp.remove((Object)20);
		assertTrue(tmp1);
		assertEquals(1, tmp.size());
		tmp1=tmp.remove((Object)20);
		assertFalse(tmp1);
		assertEquals(1, tmp.size());
	}

	@Test
	public void testAddAllCollectionOfQextendsE() {
		ArrayList<Integer> tmp=new ArrayList<>();
		tmp.add(10);
		tmp.add(20);
		LinkedList<Integer> tmp1=new LinkedList<>();
		assertTrue(tmp1.addAll(tmp));
		assertFalse(tmp1.addAll(new ArrayList<>()));
	}

	@Test
	public void testAddAllIntCollectionOfQextendsE() {
		LinkedList<Integer> tmp1=new LinkedList<>();
		assertFalse(tmp1.addAll(0,new ArrayList<>()));
		ArrayList<Integer> tmp=new ArrayList<>();
		tmp.add(10);
		tmp.add(20);
		tmp1.add(5);
		assertTrue(tmp1.addAll(0,tmp));
	}

	@Test
	public void testSetIntE() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(20);
		int x=tmp.set(1, 30);
		int y=tmp.get(1);
		assertEquals(20, x);
		assertEquals(30, y);
	}

	@Test
	public void testAddIntE() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(1,20);
		tmp.add(1,30);
		assertEquals(30, (int)tmp.get(1));
		assertEquals(20, (int)tmp.get(2));
	}

	@Test
	public void testRemoveInt() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(20);
		tmp.add(30);
		int x=tmp.remove(1);
		assertEquals(20, x);
		assertEquals(2, tmp.size());
	}

	@Test
	public void testIndexOfObject() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		int x=tmp.indexOf(null);
		assertEquals(-1, x);
		tmp.add(null);
		x=tmp.indexOf(null);
		assertEquals(1, x);
	}

	@Test
	public void testLastIndexOfObject() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(10);
		tmp.add(30);
		int x=tmp.lastIndexOf(10);
		assertEquals(1, x);
		x=tmp.lastIndexOf(20);
		assertEquals(-1, x);
		x=tmp.lastIndexOf(null);
		assertEquals(-1, x);
		tmp.add(null);
		x=tmp.lastIndexOf(null);
		assertEquals(3, x);
	}

	@Test
	public void testPeek() {
		LinkedList<Integer> tmp=new LinkedList<>();
		Object x=tmp.peek();
		assertNull(x);
		tmp.add(10);
		x=tmp.peek();
		assertEquals(10, x);
	}

	@Test
	public void testElement() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		Object x=tmp.element();
		assertEquals(10, x);
	}

	@Test
	public void testPoll() {
		LinkedList<Integer> tmp=new LinkedList<>();
		Object x=tmp.poll();
		assertNull(x);
		tmp.add(10);
		x=tmp.poll();
		assertEquals(10, x);
	}

	@Test
	public void testRemove() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		Object x=tmp.remove();
		assertEquals(10, x);
	}

	@Test
	public void testOffer() {
		LinkedList<Integer> tmp=new LinkedList<>();
		assertTrue(tmp.offer(10));
	}

	@Test
	public void testOfferFirst() {
		LinkedList<Integer> tmp=new LinkedList<>();
		assertTrue(tmp.offerFirst(10));
	}

	@Test
	public void testOfferLast() {
		LinkedList<Integer> tmp=new LinkedList<>();
		assertTrue(tmp.offerLast(10));
	}

	@Test
	public void testPeekFirst() {
		LinkedList<Integer> tmp=new LinkedList<>();
		Object x=tmp.peekFirst();
		assertNull(x);
		tmp.add(10);
		x=tmp.peekFirst();
		assertEquals(10, x);
	}

	@Test
	public void testPeekLast() {
		LinkedList<Integer> tmp=new LinkedList<>();
		Object x=tmp.peekLast();
		assertNull(x);
		tmp.add(10);
		x=tmp.peekLast();
		assertEquals(10, x);
	}

	@Test
	public void testPollFirst() {
		LinkedList<Integer> tmp=new LinkedList<>();
		Object x=tmp.pollFirst();
		assertNull(x);
		tmp.add(10);
		x=tmp.pollFirst();
		assertEquals(10, x);
	}

	@Test
	public void testPollLast() {
		LinkedList<Integer> tmp=new LinkedList<>();
		Object x=tmp.pollLast();
		assertNull(x);
		tmp.add(10);
		x=tmp.pollLast();
		assertEquals(10, x);
	}

	@Test
	public void testPush() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.push(10);
		assertEquals(10,(int) tmp.pop());
	}

	@Test
	public void testRemoveFirstOccurrence() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(10);
		boolean x=tmp.removeFirstOccurrence(10);
		assertTrue(x);
	}

	@Test
	public void testRemoveLastOccurrence() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		boolean tmp1=tmp.removeLastOccurrence(null);
		assertFalse(tmp1);
		assertEquals(1, tmp.size());
		tmp.add(null);
		tmp1=tmp.removeLastOccurrence(null);
		assertTrue(tmp1);
		assertEquals(1, tmp.size());
		tmp.add(20);
		tmp1=tmp.removeLastOccurrence((Object)20);
		assertTrue(tmp1);
		assertEquals(1, tmp.size());
		tmp1=tmp.removeLastOccurrence((Object)20);
		assertFalse(tmp1);
		assertEquals(1, tmp.size());
	}
	
	@Test
	public void testListIteratorInt() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		ListIterator<Integer> tmp1=tmp.listIterator(0);
		assertNotNull(tmp1);
		ListIterator<Integer> tmp2=tmp.listIterator(1);
		assertNotNull(tmp2);
	}

	@Test
	public void testDescendingIterator() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		Iterator<Integer> tmp1=tmp.descendingIterator();
		assertNotNull(tmp1);
	}

	@Test
	public void testClone() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		LinkedList<Integer> tmp1=(LinkedList<Integer>)tmp.clone();
		assertEquals(10, (int)tmp1.get(0));
	}

	@Test
	public void testToArray() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(20);
		Object[] tmp1=tmp.toArray();
		assertEquals(10, (int)tmp1[0]);
		assertEquals(20, (int)tmp1[1]);
	}

	@Test
	public void testToArrayTArray() {
		LinkedList<Integer> tmp1=new LinkedList<>();
		tmp1.add(20);
		tmp1.add(10);
		Integer[] tmp=tmp1.toArray(new Integer[]{});
		assertEquals(20, (int)tmp[0]);
		Integer[] tmp2=tmp1.toArray(new Integer[3]);
		assertEquals(20, (int)tmp2[0]);
	}

	@Test
	public void testSpliterator() {
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(20);
		tmp.add(10);
		Spliterator<Integer> tmp1=tmp.spliterator();
		assertNotNull(tmp1);
	}
	
	@Test
	public void testSpliteratorEstimate(){
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(20);
		tmp.add(10);
		Spliterator<Integer> tmp1=tmp.spliterator();
		long x=tmp1.estimateSize();
		assertEquals(2, x);
	}

	@Test
	public void testSpliteratorTrySplit(){
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(20);
		tmp.add(10);
		Spliterator<Integer> tmp1=tmp.spliterator();
		Spliterator<Integer> tmp2=tmp1.trySplit();
		assertNotNull(tmp2);
		LinkedList<Integer> tmp3=new LinkedList<>();
		Spliterator<Integer> tmp4=tmp.spliterator();
		Spliterator<Integer> tmp5=tmp1.trySplit();
		assertNull(tmp5);		
	}

	@Test(expected=NullPointerException.class)
	public void testSpliteratorEachRemainingEx(){
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(20);
		tmp.add(10);
		Spliterator<Integer> tmp1=tmp.spliterator();
		tmp1.forEachRemaining(null);
	}
	
	@Test
	public void testSpliteratorEachRemaining(){
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(20);
		tmp.add(10);
		Spliterator<Integer> tmp1=tmp.spliterator();
		tmp1.forEachRemaining(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				assertTrue(tmp.contains(t));
			}
		});
	}

	@Test
	public void testSpliteratorTryAdvance(){
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(20);
		tmp.add(10);
		Spliterator<Integer> tmp1=tmp.spliterator();
		boolean tmp2=tmp1.tryAdvance(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				assertTrue(tmp.contains(t));
			}
		});
		assertTrue(tmp2);
		LinkedList<Integer> tmp3=new LinkedList<>();
		Spliterator<Integer> tmp4=tmp3.spliterator();
		boolean tmp5=tmp4.tryAdvance(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
			}
		});
		assertFalse(tmp5);
	}

	@Test(expected=NullPointerException.class)
	public void testSpliteratorTryAdvanceEx(){
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(20);
		tmp.add(10);
		Spliterator<Integer> tmp1=tmp.spliterator();
		tmp1.tryAdvance(null);
	}

	@Test
	public void testSpliteratorCharacter(){
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(20);
		tmp.add(10);
		Spliterator<Integer> tmp1=tmp.spliterator();
		int x=tmp1.characteristics();
		assertEquals(16464, x);
	}
	
	@Test
	public void testDescendingIteratorClass(){
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(20);
		tmp.add(30);
		tmp.add(40);
		Iterator<Integer> tmp1=tmp.descendingIterator();
		boolean x=tmp1.hasNext();
		assertTrue(x);
		int y=tmp1.next();
		assertEquals(40, y);
		tmp1.remove();
		y=tmp1.next();
		assertEquals(30, y);
	}

	@Test(expected=NoSuchElementException.class)
	public void testListIteratorNextEx(){
		LinkedList<Integer> tmp=new LinkedList<>();
		ListIterator<Integer> tmp1=tmp.listIterator(0);
		tmp1.next();
	}

	@Test(expected=NoSuchElementException.class)
	public void testListIteratorPreviousEx(){
		LinkedList<Integer> tmp=new LinkedList<>();
		ListIterator<Integer> tmp1=tmp.listIterator(0);
		tmp1.previous();
	}

	@Test
	public void testListIteratorClass(){
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(20);
		tmp.add(30);
		ListIterator<Integer> tmp1=tmp.listIterator(0);
		boolean x=tmp1.hasNext();
		assertTrue(x);
		int y=tmp1.next();
		assertEquals(10, y);
		x=tmp1.hasPrevious();
		assertTrue(x);
		y=tmp1.previous();
		assertEquals(10, y);
		y=tmp1.nextIndex();
		assertEquals(0, y);
		y=tmp1.previousIndex();
		assertEquals(-1, y);
	}

	@Test
	public void testListIteratorRemove(){
		LinkedList<Integer> tmp=new LinkedList<>();
		tmp.add(10);
		tmp.add(20);
		ListIterator<Integer> tmp1=tmp.listIterator(0);
		tmp1.add(30);
		tmp1.add(40);
		tmp1.next();
		tmp1.remove();
		tmp1.next();
		tmp1.set(30);
		tmp1.add(50);
		tmp1.forEachRemaining(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
			}
		});
	}

}
