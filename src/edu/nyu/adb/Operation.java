package edu.nyu.adb;

import java.util.Date;

public class Operation {

  public enum OpType {
    read,
    write
  }

  private OpType opType;
  private int transId;
  private int variableIndex;
  private int value = 0;
  private Date timestamp;

  // For read operation
  public Operation(OpType type, int variableIndex, Date timestamp, int transId) {
    this.opType = type;
    this.variableIndex = variableIndex;
    this.timestamp = timestamp;
    this.transId = transId;
  }

  // For write operation
  public Operation(OpType type, int variableIndex, int value, Date timestamp, int transId) {
    this.opType = type;
    this.variableIndex = variableIndex;
    this.value = value;
    this.timestamp = timestamp;
    this.transId = transId;
  }

  public int getTransId() {
    return this.transId;
  }

  public OpType getType() {
    return this.opType;
  }

  public int getVariableIndex() {
    return variableIndex;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date date) {
    this.timestamp = date;
  }

  @Override
  public int hashCode() {
    int key = 31;
    int res = 1;
    res = key * res + ((this.opType == null) ? 0 : this.opType.hashCode());
    res = key * res + variableIndex;
    res = key * res + value;
    res = key * res + ((this.timestamp == null) ? 0 : this.timestamp.hashCode());
    return res;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Operation)) {
      return false;
    }
    else if (this == obj) {
      return true;
    }
    Operation other = (Operation) obj;
    if (this.opType == null || other.opType == null || !this.opType.equals(other.opType)) {
      return false;
    }
    if (this.variableIndex != other.variableIndex) {
      return false;
    }
    if (this.value != other.value) {
      return false;
    }
    if (this.timestamp == null || other.timestamp == null || this.timestamp.equals(other.timestamp)) {
      return false;
    }
    return true;
  }
}
