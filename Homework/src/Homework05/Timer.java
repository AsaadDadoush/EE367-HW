package Homework05;

public class Timer {
  private boolean running;
  
  private long tStart;
  
  private long tFinish;
  
  private long tAccum;
  
  public Timer() {
    reset();
  }
  
  public void start() {
    this.running = true;
    this.tStart = System.currentTimeMillis();
    this.tFinish = this.tStart;
  }
  
  public long stop() {
    this.tFinish = System.currentTimeMillis();
    if (this.running) {
      this.running = false;
      long diff = this.tFinish - this.tStart;
      this.tAccum += diff;
      return diff;
    } 
    return 0L;
  }
  
  public long elapsed() {
    if (this.running)
      return System.currentTimeMillis() - this.tStart; 
    return this.tAccum;
  }
  
  public void reset() {
    this.running = false;
    this.tStart = 0L;
    this.tFinish = 0L;
    this.tAccum = 0L;
  }
}
