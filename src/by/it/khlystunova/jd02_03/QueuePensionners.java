package by.it.khlystunova.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueuePensionners {

  private QueuePensionners(){}

  private static final BlockingDeque<Buyer> PENSIONNERS_QUEUE = new LinkedBlockingDeque<>(30);


    static  void add(Buyer buyer){
      PENSIONNERS_QUEUE.addLast(buyer);
    }

  static Buyer extract(){
      return PENSIONNERS_QUEUE.pollFirst();
  }

  static  int getSize() {
      return PENSIONNERS_QUEUE.size();
  }
}
