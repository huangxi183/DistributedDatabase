package edu.nyu.adb;

public class DistributedDatabase {
  public static void main(String[] args) {
    TransactionManager transactionManager = new TransactionManager(args[0]);
    transactionManager.init();

  }
}
