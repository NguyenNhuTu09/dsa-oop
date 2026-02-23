package com.example.JavaCore.CustomImplementation;

public class ArrayListImpl<E> {
    private Object[] array;
	private int size;
	private static final int INITIAL_CAPACITY = 10;

	public ArrayListImpl(){
		array = new Object[INITIAL_CAPACITY];
		size = 0;
	}

	private void resize(){
		Object[] newArray = new Object[array.length * 2];
		System.arraycopy(array, 0, newArray, 0, size);
		array = newArray;
	}

	public void add(E element){
		if(size == array.length)
			resize();
		array[size++] = element;
	}

	public void add(int index, E element){
		if(index < 0 || index > size) throw new IndexOutOfBoundsException();
		if(size == array.length)
			resize();
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = element;
		size++;
	}

	@SuppressWarnings("unchecked") // bỏ qua cảnh báo của trình biên dịch về an toàn kiểu dữ liệu
	public E get(int index){
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		return (E) array[index];	
	}

	@SuppressWarnings("unchecked")
	public E remove(int index){
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		// 2 3 6 4 8 9 10 0 0 0 
		// 0 1 2 3 4 5 6

		// index = 4;
		// size = 7;
		E element = (E) array[index]; // do cơ chế Type Ensure(tự động xóa kiểu Generics tự định nghĩa khi add vào mảng Object)
		// nên cần ép kiểu tường minh phần tử array[index];
		System.arraycopy(array,index + 1,array,index,size - index - 1);
		array[--size] = null;
		return element;
	}
}
