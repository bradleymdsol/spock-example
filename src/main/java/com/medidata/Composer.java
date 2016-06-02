package com.medidata;

import java.io.PrintWriter;

public class Composer {

  private Composed composed1;
  private Composed composed2;
  private PrintWriter writter;

  public Composer(Composed composed1, Composed composed2, PrintWriter writter) {
    this.composed1 = composed1;
    this.composed2 = composed2;
    this.writter = writter;
  }

  public void execute() {
    composed1.run();
  }

  public void write() {
    writter.write(composed1.run());
  }
}
