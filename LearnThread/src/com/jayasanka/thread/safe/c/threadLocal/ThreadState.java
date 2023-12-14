package com.jayasanka.thread.safe.c.threadLocal;

public class ThreadState {
	public static final ThreadLocal<StateHolder> statePerThread = new ThreadLocal<StateHolder>() {

		@Override
		protected StateHolder initialValue() {
			return new StateHolder("active");
		}
	};

	public static StateHolder getState() {
		return statePerThread.get();
	}
}
