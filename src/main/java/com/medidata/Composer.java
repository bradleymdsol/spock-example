package com.medidata;

import java.io.PrintWriter;

public class Composer {

  private Composed composed1;
  private Composed composed2;
  private PrintWriter writer;

  public Composer(Composed composed1, Composed composed2, PrintWriter writer) {
    this.composed1 = composed1;
    this.composed2 = composed2;
    this.writer = writer;
  }

  public void execute() {
    composed1.run();
  }

  public void write() {
    writer.write(composed1.run());
  }

  public void writeMore() {
    writer.write(composed1.run());
    writer.write(composed1.run());
  }

  public void executeLots() {
    for (int i = 0; i < 5; i++) {
      composed2.run();
    }
  }
}
